package co.edu.escuelaing.menu.item;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/menu/items")
public class ItemController {
	private final ItemService service;

	public ItemController(ItemService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		List<Item> items = service.findAll();
		return ResponseEntity.ok().body(items);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> find(@PathVariable("id") Long id) {
		Optional<Item> item = service.find(id);
		return ResponseEntity.of(item);
	}

	@PostMapping
	public ResponseEntity<Item> create(@RequestBody Item item) {
		Item created = service.create(item);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getId())
				.toUri();
		return ResponseEntity.created(location).body(created);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> update(@PathVariable("id") Long id, @RequestBody Item updatedItem) {

		Optional<Item> updated = service.update(id, updatedItem);

		return updated.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> {
			Item created = service.create(updatedItem);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(created.getId()).toUri();
			return ResponseEntity.created(location).body(created);
		});
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Item> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}