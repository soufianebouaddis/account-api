Hype - Account Management Service

Description

A Spring Boot REST API for account management using a pipeline-based architecture. Each operation flows through composable processor steps for validation, persistence, and error handling.

Stack

- Java 21
- Spring Boot 4.0.2
- PostgreSQL
- Spring Data JPA
- SpringDoc OpenAPI (Swagger)
- Lombok
- Maven

Flow

Create Account

Request → Controller → Service → Pipeline
↓
ValidationProcessor (check RIB uniqueness)
↓
SaveProcessor (persist to database)
↓
ErrorProcessor (log if failed)
↓
Response (200 OK with account details)

Update Account

Request → Controller → Service → Pipeline
↓
ExistProcessor (verify account exists)
↓
ValidationProcessor (validate updated fields)
↓
UpdateProcessor (save changes)
↓
ErrorProcessor (log if failed)
↓
Response

Get Account by ID

Request → Controller → Service → Pipeline
↓
FindByIdProcessor (fetch from database)
↓
ErrorProcessor (log if not found)
↓
Response

Get All Accounts

Request → Controller → Service → Pipeline
↓
FindAllProcessor (paginated fetch)
↓
ErrorProcessor (log if failed)
↓
Response with pagination

Delete Account

Request → Controller → Service → Pipeline
↓
ExistProcessor (verify exists)
↓
DeleteByIdProcessor (remove from database)
↓
ErrorProcessor (log if failed)
↓
Response

API Endpoints

POST /api/v1/accounts/create-account - Create account
GET /api/v1/accounts/get-account/{id} - Get by ID
GET /api/v1/accounts/get-all-accounts - Get all (paginated)
PUT /api/v1/accounts/update-account/{id} - Update account
DELETE /api/v1/accounts/delete-account/{id} - Delete account

Getting Started

1. Configure PostgreSQL in src/main/resources/application.yaml
2. Run: mvn clean install
3. Start: mvn spring-boot:run
4. Access Swagger: http://localhost:9099/swagger-ui.html

Architecture Pattern

Controller → Function Layer → Service → Pipeline → Processors → Repository

Each processor implements a single step in the operation pipeline. Pipelines are configured based on operation type. Contexts carry execution state through the pipeline, allowing any step to fail the operation with an error message.
