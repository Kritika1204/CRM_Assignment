# Employee Performance Management System

Spring Boot REST API for employee performance management with filtering capabilities.

## Technology Stack
- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (in-memory)
- Maven 3.8+

## Quick Start

1. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

2. **Access:**
   - API: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:testdb`
     - Username: `sa`
     - Password: (empty)

## API Endpoints

### Get All Employees
```
GET /api/employees
```

### Get Employees with Filters
```
GET /api/employees?score=8&reviewDate=2023-06-30
GET /api/employees?departments=Engineering,Marketing
GET /api/employees?projects=Web Application
```

### Get Employee Details
```
GET /api/employees/{id}
```

## Sample Data
Application automatically loads 4 employees, 3 departments, 3 projects, and performance reviews on startup.