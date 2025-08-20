# 📝 Spring Boot TODO Application

A simple **Spring Boot REST API** project for managing TODO tasks.  
This project demonstrates REST fundamentals, CRUD operations, database integration, best practices, and basic security.

---

## 🚀 Features

### ✅ REST API Fundamentals
- Set up Spring Boot REST controllers
- Build endpoints for CRUD operations
- Use `@RestController`, `@RequestMapping`, `@PathVariable`, and `@RequestBody`
- Differentiate between **GET**, **POST**, **PUT**, and **DELETE** methods
- Handle path variables and query parameters effectively
- Leverage `@ResponseStatus` to control HTTP responses

---

### ✅ Connect to Databases with Spring Data JPA
- Integrate with **MySQL** 
- Use Spring Data JPA repositories
- Map entities with JPA annotations
- Perform custom queries using JPQL and native SQL
- Use projections and DTOs to control data exposure

---

### ✅ CRUD Operations
- Create REST endpoints for full CRUD functionality
- Return JSON data using **Jackson**
- Use `@PostMapping`, `@PutMapping`, `@DeleteMapping`, and `@GetMapping` effectively
- Build reusable service-layer logic
- Avoid code duplication with generic service/repository patterns
- Handle **entity not found** scenarios gracefully
- Respond with appropriate **status codes** for create/update/delete operations

---

### ✅ REST Best Practices
- Use proper HTTP status codes
- Path & Query data validation
- Object data validation
- Apply request validation with `@Valid` and custom validators
- Structure consistent response models
- Implement global exception handling with `@ControllerAdvice`
- Leverage `@ResponseEntity` for flexible responses
- Avoid exposing internal domain objects directly in responses

---

### ✅ Secure Your REST APIs
- Add basic authentication with **Spring Security**
- Secure endpoints by role or path
- Implement **JWT authentication** 
- Customize login/logout endpoints
- Configure stateless sessions using JWT
- Restrict **CORS** to specific domains
- **BCrypt hashing** for database passwords

---

## 🛠️ Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Maven

---
