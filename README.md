# Security Workshop

## PArt 1 - JWT

Aplicación para administrar menús para un restaurante

<br><br>
### [GET] getItems


>localhost:7000/api/menu/items

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/701c4ebc-c2c7-44c2-84eb-1e2c1e27b011)
<br><br>

### [GET] GetItemById


>localhost:7000/api/menu/items/2

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/afa0727a-8075-471d-8f06-d2670e25f748)

<br><br>
### [POST] createItem

>localhost:7000/api/menu/items

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/2115d59c-810e-4fb9-8ee5-8bf4ed23ca1f)

<br><br>

### Whatabyte demo client

Can list menu items

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/ae7ffca1-8ce8-40f4-a9d7-b97134b7b041)

<br>

Can not create new menu items

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/acfa2916-9ce3-45be-a099-baf61e6551dc)


<br><br>

### User configuration

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/0a193d8e-e879-45b7-9e98-ba2e273038fe)


<br>

### Login in

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/df97c9a1-f400-4efc-8f84-92fc57ad37a5)

Authenticated user

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/68b30918-55c5-41c6-962f-6108b00767f1)


### Creating new item

![image](https://github.com/Konstrictorman/menuApp/assets/5210457/b433803e-4a04-4739-9899-66bdb7844198)

Item successfully added
![image](https://github.com/Konstrictorman/menuApp/assets/5210457/01e0875a-b91a-4a1d-acb8-08de15a6feb0)



## Part 2 - AWS serverless application model

### Requirements

- The application must allow users to register (create an account).
- The application must allow users to authenticate using a password.
- The application must use Cognito to manage user accounts.
- The application must grant integrity and authorization.
- The application implements a minimal facebook-like social network. Every connected user can post messages and every user will see the posted messages. Last posted message is shown on top.
- The application must show how many users are currently connected.
- The application must updated the post feed and the number of connected users in Real-time.
- Access to WS must be secure.
 -Implement the simplest minimal application possible.

### Components

- First step should be implementing Lambda functions for user registration (account creation), authentication, posting and retrieve messages.
- Let's use DyanmoDB as the application datasource.
- Create a Cognito User Pool to manage user accounts, enabling username and password sign-up
- Expose API REST via AP Gateway

### Design

  ![image](https://github.com/Konstrictorman/menuApp/assets/5210457/b16431d3-a6ce-484c-a449-09e679e250ae)

### How authentication works

1. A client first log in via Cognito
2. After successful login, Cognito returns an id_token to the client;
3. The client sends a request to the API Gateway with the received id_token;
4. The API Gateway verifies in Cognito whether the id_token is valid;
5. Cognito will return to API Gateway a success response when the id_token is valid;
6. The API Gateway sends the request to the lambda function;
7. The lambda function executes and sends its response to the API Gateway;
8. The API Gateway sends the response to the client.


## References

- https://auth0.com/blog/manage-a-collection-of-secure-api-endpoints-with-postman/?_gl=1*1dihgfj*_gcl_au*OTY2NzIzNzczLjE2OTk3MTM1NDA.*_ga*MTUwMzMzODgxNi4xNjk5NzEzNTQw*_ga_QKMSDV5369*MTcwMDc1MTU5OS4yNS4xLjE3MDA3NTM2NzcuMzIuMC4w#Authorization-in-Postman
- https://auth0.com/docs/secure/tokens/access-tokens/get-management-api-access-tokens-for-testing
- https://medium.com/aws-lambda-serverless-developer-guide-with-hands/secure-microservices-with-api-gateway-using-amazon-cognito-user-pools-28ac32afeee2

