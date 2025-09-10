# WFA Spring Boot API

Java 17 • Spring Boot 3 • MongoDB • JWT Security • Mockito tests

## Run
```bash
mvn spring-boot:run
```

## Env vars
```
MONGODB_URI=mongodb://localhost:27017
MONGODB_DB=wfa
JWT_SECRET=change-this-super-secret-at-least-256-bits
JWT_EXP_MINUTES=120
```

## Tests
```bash
mvn -q test
```

## Postman
- postman/WFA_API.postman_collection.json
- postman/WFA_Local.postman_environment.json

## Sample data
See sample_data.json (illustrative). Import into Mongo before running, or create via API.

Generated: 2025-08-27
