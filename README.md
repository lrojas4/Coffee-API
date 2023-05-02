# Coffee API
## Overview
A coffee order API built using Spring Boot and Java. 

## Tools and Technologies Used
* Java
* IDE - IntelliJ IDEA
* Spring Boot
* Maven
* PostgreSQL
* Postman  

# API Endpoints

| Request Type | URL                                   | Functionality                                           | Access  |
|--------------|---------------------------------------|---------------------------------------------------------|---------|
| POST         | auth/users/register/                  | Registers a user                                        | PUBLIC  |
| POST         | /auth/users/login/                    | Logs a user in                                          | PUBLIC  |
| GET          | /api/orders/                          | Lists all orders                                        | PRIVATE |
| GET          | /api/orders/{orderId}/                | Gets a single order with the suplied id                 | PRIVATE |
| POST         | /api/orders/                          | Creates a new order                                     | PRIVATE |
| PUT          | /api/orders/{orderId}/                | Updates the order with the supplied id                  | PRIVATE |
| DELETE       | /api/orders/{orderId}/                | Deletes an order with the supplied id                   | PRIVATE |
| GET          | /orders/{orderId}/coffees/            | Lists all coffees in the given order                    | PRIVATE |
| GET          | /orders/{orderId}/coffees/{coffeeId}/ | Gets a coffee with the supplied id from the given order | PRIVATE |
| POST         | /orders/{orderId}/                    | Creates a new recipe in the given order                 | PRIVATE |
| PUT          | /orders/{orderId}/coffees/{coffeeId}  | Updates a coffee in the given order                     | PRIVATE |
| DELETE       | /orders/{orderId}/coffees/{coffeeId}/ | Deletes a coffee in the given order                     | PRIVATE |

## Acknowledgements
* [Spring Boot Annotations](https://www.baeldung.com/spring-boot-annotations)






