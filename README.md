# Spring Security Implementation in Java 11

Here are following endpoints

1) http://localhost:8080/order/authenticate (POST) : To get a jwt token. It requires username and password
2) http://localhost:8080/order/ (POST) : To create a order. It require order details

Authentication Required for following endpoints
3) http://localhost:8080/order/agent/{agentId} : It is used to get agent information. It requires jwt token and agentId
4) http://localhost:8080/order/assignToAgent : It is used to assign a order to a agent
5) http://localhost:8080/order/admin : It is get all orders of a admin
6) http://localhost:8080/order/assignToAdmin : It is used to assign order back to admin
