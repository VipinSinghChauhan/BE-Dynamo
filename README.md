# Spring Security Implementation in Java 11

Here are following endpoints

1) https://dynamo-app.azurewebsites.net/order/authenticate (POST) : To get a jwt token. It requires username and password
2) https://dynamo-app.azurewebsites.net/order/ (POST) : To create a order. It require order details

Authentication Required for following endpoints

3) https://dynamo-app.azurewebsites.net/order/agent/{agentId} (GET): It is used to get agent information. It requires jwt token and agentId
4) https://dynamo-app.azurewebsites.net/order/assignToAgent (PUT): It is used to assign a order to a agent
5) https://dynamo-app.azurewebsites.net/order/admin (GET): It is get all orders of a admin
6) https://dynamo-app.azurewebsites.net/order/assignToAdmin (PUT): It is used to assign order back to admin
