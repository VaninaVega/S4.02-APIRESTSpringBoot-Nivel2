# S4.02-APIRESTSpringBoot-Nivel2

This is a Spring Boot project built with Maven as the dependency manager. It implements a complete CRUD for a `Fruta` entity and follows the MVC pattern, using REST best practices 
and persistence with a MySQL database.

## Requirements

- Java JDK (minimum version 11)
- Maven installed
- MySQL installed and running (e.g. via XAMPP, MAMP, or standalone)
- Postman (or another HTTP client) to test endpoints

## Database Configuration

Before running the app, make sure to:

1. Create a database named `fruitdb` in MySQL (or the name you use in `application.properties`).

2. Update your `src/main/resources/application.properties` file with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/frutasdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## How to Run the Application

1- Clone this repository or download the project.

2- Open a terminal in the root directory of the project.

3- Run the following Maven command:
```bash
bash
Copiar
Editar
mvn spring-boot:run
```
4- The application will be accessible at http://localhost:8081.

## API Endpoints
This API has been tested using Postman.

## MySQL Setup (Quick Guide)
You can use a tool like DBeaver, MySQL Workbench or the XAMPP panel to:

Start MySQL service.

Create a database (e.g., fruitdb).

Optionally test your connection and view the data.

