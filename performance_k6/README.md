# API Testing with K6 and Docker

## Project Overview
This project is designed to test the API endpoints of the Petstore API using K6 for performance testing. The framework supports multiple types of tests, including stress, load, and scalability tests.

## Prerequisites
Before running the tests, ensure that you have the following installed:
- Docker
- Docker Compose
- K6

## Instalacion

To clone this repository, run the following command in your terminal:

```
git clone git@github.com:kissilva/SwaggerPetstoreAPI.git
```

Ingresar al proyecto a través

```
cd swaggerPetstoreAPI_Performance_k6
```

## Docker - Compose

Start the required containers (Swagger Petstore, InfluxDB, and Grafana) for test execution and results visualization:
```
docker-compose up -d
```

To verify that the containers are running, execute:
```
docker ps
```

You should see three active containers:

* swagger-petstore
* grafana
* influxdb

## Project Structure
```
┣  dashboards 
┣  results 
┣  src
    ┣  globals 
        ┣ logger.js 
    ┣  resources 
        ┣  api_endpoints.js  
        ┣  performance_tests_config.js 
    ┣  services
        ┣ rest
            ┣  api_request.js 
            ┣  test_runner.js 
┣  docker-compose.yml 
┣  grafana-dashboard.yaml 
┣  grafana-datasource.yaml 
┣  RunCommands.md 
┣  README.md 
```
## Test Types
The following test types are defined in `performance_tests_config.js`:
- **stress_test**: Simulates an increasing number of users to determine system limits.
- **load_test**: Simulates a steady number of users to evaluate system performance under normal load.
 **scalability_test**: Evaluates how the system handles increasing loads over time.

## Available API Endpoints
Swagger Petstore API is available at:

* From the browser (local host): http://localhost:8080
* From a Docker container: http://swagger-petstore:8080

Endpoints defined in `api_endpoints.js`:
- **update_pet**: Updates pet information.
- **add_pet**: Adds a new pet.
- **find_pets_by_status**: Retrieves pets based on status.
- **find_pet_by_id**: Retrieves a pet by ID.
- **get_inventory**: Retrieves store inventory.
- **place_order**: Places an order for a pet.
- **create_user**: Creates a new user.
- **login_user**: Logs in a user.

## Running Tests
### Running with Docker
Use the following command to run a test using Docker Compose:
```
TYPE_TEST=<test_type> ENDPOINT_NAME=<endpoint_name> \
    bash -c 'docker-compose run --rm k6 run -e TYPE_TEST=$TYPE_TEST -e ENDPOINT_NAME=$ENDPOINT_NAME \
        --console-output=/results/"$TYPE_TEST"_"$ENDPOINT_NAME"_$(date +%Y%m%d-%H%M%S) /src/services/rest/test_runner.js'
```
Replace `<test_type>` with one of the defined test types in `performance_tests_config.js` and `<endpoint_name>` with an endpoint from `api_endpoints.js`.

### Running Locally
If you want to run the tests without Docker, execute:
```
TYPE_TEST=load_test ENDPOINT_NAME=find_pet_by_id \
    bash -c 'docker-compose run --rm k6 run -e TYPE_TEST=$TYPE_TEST -e ENDPOINT_NAME=$ENDPOINT_NAME \
        --console-output=/results/"$TYPE_TEST"_"$ENDPOINT_NAME"_$(date +%Y%m%d-%H%M%S) /src/services/rest/test_runner.js'
```

## Test Results
Test results are stored in the `/results/` directory, organized by test type and timestamp.

