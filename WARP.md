# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Overview

BillyBills is a personal bill management application built with Spring Boot 3.5.6 and Spring Batch. The project uses PostgreSQL as the database and is containerized with Docker.

## Commands

### Database
```bash
# Start PostgreSQL database
docker-compose up -d

# Stop database
docker-compose down

# View database logs
docker logs bills_db

# Connect to database
docker exec -it bills_db psql -U root -d bills
```

### Application Development
```bash
# Build the application
cd billy-bills && ./mvnw clean compile

# Run tests
cd billy-bills && ./mvnw test

# Run specific test
cd billy-bills && ./mvnw test -Dtest=BillyBillsApplicationTests

# Package application
cd billy-bills && ./mvnw package

# Run application locally
cd billy-bills && ./mvnw spring-boot:run

# Clean build artifacts
cd billy-bills && ./mvnw clean
```

## Architecture

### Project Structure
- **Root directory**: Contains Docker configuration and database initialization
- **billy-bills/**: Main Spring Boot application directory
- **Database**: PostgreSQL container with Spring Batch metadata tables and basic user table

### Technology Stack
- **Framework**: Spring Boot 3.5.6 with Spring Batch
- **Database**: PostgreSQL 16
- **Build Tool**: Maven with wrapper scripts
- **Java Version**: 17
- **Package Structure**: `vxvy.billy_bills` (note: original package name was invalid)

### Key Components
- **BillyBillsApplication**: Main Spring Boot application class
- **BillingJobConfiguration**: Configuration class for Spring Batch jobs (currently placeholder)
- **Database Schema**: Includes Spring Batch metadata tables and a basic users table
- **Docker Setup**: PostgreSQL database with persistent volume and health checks

### Database Configuration
- **Connection**: `jdbc:postgresql://localhost:5432/bills`
- **Credentials**: Username `root`, password configured in both docker-compose and application.properties
- **Initialization**: `init.sql` creates necessary tables on first run
- **Spring Batch Tables**: Full metadata schema for job execution tracking

### Development Notes
- The application is in early development stage with basic structure in place
- Spring Batch job configuration is currently a placeholder awaiting implementation
- Database connection configured for local Docker PostgreSQL instance
- Maven wrapper scripts (`mvnw`) provided for consistent build environment