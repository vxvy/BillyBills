# Billy Bills - Spring Boot Billing Application

## Project Overview
A Spring Boot application for billing management using Spring Batch for processing billing data.

## Technology Stack
- **Framework**: Spring Boot 3.5.6
- **Build Tool**: Maven
- **Database**: PostgreSQL
- **Batch Processing**: Spring Batch
- **Java Version**: 17

## Database Configuration
- **URL**: jdbc:postgresql://localhost:5432/bills
- **Username**: root
- **Password**: bills**25Y

## Build Commands
```bash
# Clean and install dependencies
mvn clean install

# Run the application
mvn spring-boot:run

# Run tests
mvn test
```

## Project Structure
```
src/main/java/vxvy/billy_bills/
├── core/
│   └── configuration/
│       └── BillingJobConfiguration.java
└── infraestructure/
    ├── BillyBillsApplication.java
    └── adapters/
        └── batch/
            └── BillingJob.java
```

## Key Components
- **BillyBillsApplication**: Main Spring Boot application entry point
- **BillingJobConfiguration**: Spring Batch job configuration
- **BillingJob**: Batch job implementation for billing processing