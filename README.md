# Swagger Petstore API Testing

This repository contains solutions for API test automation and performance testing for the **Swagger Petstore API**. It is divided into two separate projects:

1. **API Test Automation** (Java + Serenity BDD + Rest)
2. **API Performance Testing** (K6 + Docker + Grafana)

## Repository Structure
```

┣  swagger-petstore-testing/
   ┣ api-test-automation/ # Test automation framework 
   ┣ api-performance-test/ # Performance testing framework 
   └── README.md # General project documentation
   
```

## 1. API Test Automation
This project is an **API test automation framework** built with **Java, Serenity BDD, Gradle, and Rest**, following the **Screenplay Pattern** for modularity and maintainability.

### Tech Stack
- Java 11+
- Serenity BDD
- Gradle
- Rest 
- Cucumber

### Key Features
- Automates CRUD operations for **Users, Pets, and Orders**.
- Implements **Serenity Reports** for detailed test execution results.
- Uses **Cucumber BDD** for readable test scenarios.

### Run Tests
```
cd api-test-automation
./gradlew clean test
```
### Generate Serenity Reports
```
./gradlew aggregate

open target/site/serenity/index.html
```
## 2. API Performance Testing
This project is designed for load, stress, and scalability testing of the Swagger Petstore API using K6 and Docker.

### Tech Stack
- K6 for performance testing
- Docker & Docker Compose for containerized execution
- InfluxDB & Grafana for test result visualization 
### Test Types
- Load Testing – Simulates normal user load.
- Stress Testing – Identifies system limits.
- Scalability Testing – Evaluates performance over time.
### Run Performance Tests
```
cd api-performance-test
docker-compose up -d  # Start API, Grafana & InfluxDB
TYPE_TEST=load_test ENDPOINT_NAME=find_pet_by_id docker-compose run --rm k6 run /src/services/rest/testRunner.js
```
### View Results in Grafana
- Open: http://localhost:3000
- Dashboard: Swagger Pet store Performance k6 Results
# How to Use This Repository
- Clone the repository:
```
 git clone https://github.com/kissilva/swagger-petstore-testing.git
 cd swagger-petstore-testing
```
- Run API Test Automation:
```
cd api-test-automation
./gradlew clean test
```
- Run API Performance Tests:
```
cd api-performance-test
docker-compose up -d
docker-compose run --rm k6 run /src/services/rest/testRunner.js
```