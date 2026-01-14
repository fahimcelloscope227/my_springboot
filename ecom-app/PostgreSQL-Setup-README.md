# PostgreSQL Setup for E-Commerce App

This document explains how to configure and use the PostgreSQL repository implementation in the ecom-app.

## Overview

The application now supports both H2 (default) and PostgreSQL databases through different repository implementations:
- `JPAOrderRepository` - Default implementation for H2 database
- `PostgreSQLOrderRepository` - PostgreSQL-specific implementation

## Files Created/Modified

### New Files:
1. `PostgreSQLOrderRepository.java` - PostgreSQL-specific implementation of OrderRepositoryPort
2. `PostgreSQLConfig.java` - Configuration class for PostgreSQL setup

### Modified Files:
1. `pom.xml` - Added PostgreSQL driver dependency
2. `application.properties` - Added PostgreSQL configuration templates

## How to Use PostgreSQL

### 1. Add PostgreSQL Dependency
The PostgreSQL driver has already been added to `pom.xml`:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

### 2. Configure Database Connection
Uncomment and update the following properties in `application.properties`:

```properties
# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

# Enable PostgreSQL repository
app.database.type=postgresql
```

### 3. Create Database
Create a PostgreSQL database named `ecommerce_db` (or update the URL to use your preferred database name):

```sql
CREATE DATABASE ecommerce_db;
```

### 4. Run the Application
The application will automatically use the PostgreSQL repository when `app.database.type=postgresql` is set.

## Database Schema

The application uses Hibernate's auto-DDL feature (`spring.jpa.hibernate.ddl-auto=update`) to create the necessary tables automatically. The `orders` table will be created with the following structure:

```sql
CREATE TABLE orders (
    order_id VARCHAR(255) PRIMARY KEY,
    customer_name VARCHAR(255),
    restaurant_name VARCHAR(255),
    item VARCHAR(255),
    status VARCHAR(255)
);
```

## Switching Back to H2

To switch back to H2 database:
1. Comment out all PostgreSQL configuration properties
2. Set `app.database.type=h2` (or remove the property entirely)
3. Restart the application

## Implementation Details

### PostgreSQLOrderRepository
The PostgreSQL implementation includes:
- Better error handling with specific exception messages
- Same mapping logic as JPA implementation but optimized for PostgreSQL
- Implements the same `OrderRepositoryPort` interface

### Configuration Strategy
The application uses Spring Boot's conditional bean creation:
- `@ConditionalOnProperty(name = "app.database.type", havingValue = "postgresql")` ensures PostgreSQL configuration only activates when specifically enabled
- `@Primary` annotation ensures the PostgreSQL repository takes precedence when activated
- This allows seamless switching between databases without code changes

## Benefits

1. **Database Flexibility**: Easy switching between H2 and PostgreSQL
2. **Production Ready**: PostgreSQL support for production environments
3. **Clean Architecture**: Separation of concerns with repository pattern
4. **No Code Changes**: Switch databases through configuration only
5. **Better Performance**: Optimized implementations for each database type
