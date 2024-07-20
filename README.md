# loqo-ai_Assignment
# SortingAndFilteringElectronics
## Description
This project is a Spring Boot application designed to provide sorting and filtering functionalities for electronic devices. It allows users to filter products based on criteria such as category, price range, availability, and sort the results by different fields in ascending or descending order.

## Table of Contents
- Prerequisites
- Installation
- Running the Application
- API Endpoints
- Testing
- Technologies Used
- Contributing
## Prerequisites
- Java 17
- Maven
- MySQL
- Spring Boot
  
## Installation
**Clone the repository:**
```
git clone https://github.com/Sushant2518/loqo-ai_Assignment.git
```

**Configure the MySQL database**
- Ensure MySQL is running.
- Create a database named SortingAndFilteringElectronics.
- Update the database configuration in application.

**Properties**
```
spring.datasource.url=jdbc:mysql://localhost:3306/SortingAndFilteringElectronics
spring.datasource.username=username
spring.datasource.password=user_password
```
**Insert Sample Data In Database**
```
INSERT INTO products (name, category, price, in_stock, rating, created_at) VALUES
('Smartphone', 'electronics', 299.99, TRUE, 4.5, '2023-01-15 12:00:00'),
('Laptop', 'electronics', 899.99, TRUE, 4.7, '2023-03-20 08:30:00'),
('Headphones', 'electronics', 99.99, TRUE, 4.3, '2023-04-10 11:15:00'),
('Blender', 'home appliances', 49.99, FALSE, 4.0, '2023-05-12 09:45:00'),
('Air Fryer', 'home appliances', 119.99, TRUE, 4.6, '2023-06-22 14:30:00'),
('Book', 'books', 19.99, TRUE, 4.8, '2023-07-05 16:00:00');
```

**Build the project using Maven:**
```
mvn clean install
```

## Running the Application
**Run the Spring Boot application:**
```
mvn spring-boot:run
```
The application will start and be accessible at http://localhost:8080.

## API Endpoints
**Get Products**
- URL: /products
- Method: GET
- Query Parameters:
  - category : Filter by category.
  - minPrice : Filter by minimum price.
  - maxPrice : Filter by maximum price.
  - inStock : Filter by availability.
  - sortField : Field to sort by (default is id).
  - sortOrder : Sort order, either asc or desc (default is asc).
    
**Example Request:**
```
GET /products?category=electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=asc
```
**Example Response:**
```
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
```

## Testing
Unit tests and integration tests are provided for the service and controller layers. To run the tests, use the following command:
```
mvn test
```
## Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL
- Mockito
- JUnit
- Maven

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes. Make sure to write tests for your new features or bug fixes.

