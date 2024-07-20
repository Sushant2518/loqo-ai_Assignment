# loqo-ai_Assignment

SortingAndFilteringElectronics
This project is a Spring Boot application designed to provide sorting and filtering functionalities for electronic devices. It allows users to filter products based on criteria such as category, price range, availability, and sort the results by different fields in ascending or descending order.

Table of Contents
Prerequisites
Installation
Running the Application
API Endpoints
Testing
Technologies Used
Contributing
License
Prerequisites
Java 17
Maven 3.x
MySQL
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/SortingAndFilteringElectronics.git
cd SortingAndFilteringElectronics
Configure the MySQL database:

Ensure MySQL is running.
Create a database named SortingAndFilteringElectronics.
Update the database configuration in application.properties:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/SortingAndFilteringElectronics
spring.datasource.username=root
spring.datasource.password=root
Build the project using Maven:

bash
Copy code
mvn clean install
Running the Application
Run the Spring Boot application:

bash
Copy code
mvn spring-boot:run
The application will start and be accessible at http://localhost:8080.

API Endpoints
Get Products
URL: /products

Method: GET

Query Parameters:

category (optional): Filter by category.
minPrice (optional): Filter by minimum price.
maxPrice (optional): Filter by maximum price.
inStock (optional): Filter by availability.
sortField (optional): Field to sort by (default is id).
sortOrder (optional): Sort order, either asc or desc (default is asc).
Example Request:

http
Copy code
GET /products?category=electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=asc
Example Response:

json
Copy code
[
  {
    "id": 1,
    "name": "Smartphone",
    "category": "electronics",
    "price": 299.99,
    "inStock": true,
    "rating": 4.5,
    "createdAt": "2023-07-20T12:34:56Z"
  },
  {
    "id": 2,
    "name": "Laptop",
    "category": "electronics",
    "price": 899.99,
    "inStock": true,
    "rating": 4.7,
    "createdAt": "2023-07-20T12:34:56Z"
  },
  {
    "id": 3,
    "name": "Headphones",
    "category": "electronics",
    "price": 99.99,
    "inStock": true,
    "rating": 4.3,
    "createdAt": "2023-07-20T12:34:56Z"
  }
]
Testing
Unit tests and integration tests are provided for the service and controller layers. To run the tests, use the following command:

bash
Copy code
mvn test
Technologies Used
Spring Boot
Spring Data JPA
MySQL
Mockito
JUnit
Maven
Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes. Make sure to write tests for your new features or bug fixes.

License
This project is licensed under the MIT License. See the LICENSE file for details.