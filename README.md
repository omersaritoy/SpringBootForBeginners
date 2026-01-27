# Spring Boot 3, Spring 6 & Hibernate – Training Projects

This repository contains sample projects developed as part of the **Spring Boot 3, Spring Framework 6, and Hibernate for Beginners** course.

Throughout the course, modern Spring technologies were used to build real-world applications covering **REST APIs**, **Spring MVC**, **Spring Security**, **JPA/Hibernate**, **AOP**, and **Thymeleaf** with hands-on examples.

---

## 📌 Project Overview

The projects in this repository cover the following topics:

### 🚀 Spring Boot Fundamentals
- Creating projects with Spring Boot 3
- Using Spring Initializr
- Maven dependency management and starters
- Application configuration with `application.properties`
- Logging and Spring Boot Actuator

### 🔧 Spring Core
- Dependency Injection (DI)
- Inversion of Control (IoC)
- Bean lifecycle
- Annotation-based configuration

### 🗄️ Hibernate & JPA
- Entity mapping
- CRUD operations
- JPQL and native queries
- One-to-One, One-to-Many, Many-to-Many relationships
- Lazy vs Eager fetching
- Transaction management

### 🌐 RESTful Web Services
- REST API design
- `@RestController` usage
- Global exception handling
- JSON serialization/deserialization with Jackson
- PUT, PATCH, DELETE operations
- HATEOAS & HAL support

### 🔐 Spring Security
- Authentication and authorization
- Password hashing with BCrypt
- Role-based access control
- HTTP Basic and Form Login security
- Securing REST APIs

### 🖥️ Spring MVC & Thymeleaf
- MVC (Model–View–Controller) architecture
- Form handling with Thymeleaf
- Input validation (Bean Validation & Hibernate Validator)
- Basic UI with Bootstrap

### 🧩 AOP (Aspect-Oriented Programming)
- Defining aspects
- `@Before`, `@After`, `@Around` advices
- Logging and cross-cutting concerns

---

## 🛠️ Technologies Used

- **Java 17+**
- **Spring Boot  and Spring boot 4**
- **Spring Framework 6**
- **Spring Data JPA**
- **Hibernate**
- **Spring Security**
- **Spring MVC**
- **Thymeleaf**
- **MySQL**
- **Maven**

---

## ⚙️ Setup & Run

1. Clone the repository:

git clone https://github.com/omersaritoy/SpringBotForBeginners.git

2.Create the required database in MySQL.

3.Update database credentials in application.properties or application.yml:
spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=root
spring.datasource.password=your_password

4.Run the application:
mvn spring-boot:run

5.Access the application:

http://localhost:8080






