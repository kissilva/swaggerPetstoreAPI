# Run Commands for API Testing with K6 and Docker

## Running Tests with Docker
To execute tests using Docker Compose, use the following command:

```
    TYPE_TEST=<test_type> ENDPOINT_NAME=<endpoint_name> \
    bash -c 'docker-compose run --rm k6 run -e TYPE_TEST=$TYPE_TEST -e ENDPOINT_NAME=$ENDPOINT_NAME \
        --console-output=/results/"$TYPE_TEST"_"$ENDPOINT_NAME"_$(date +%Y%m%d-%H%M%S) /src/services/rest/testRunner.js'
```

### Example:
```
    TYPE_TEST=load_test ENDPOINT_NAME=find_pet_by_id \
    bash -c 'docker-compose run --rm k6 run -e TYPE_TEST=$TYPE_TEST -e ENDPOINT_NAME=$ENDPOINT_NAME \
        --console-output=/results/"$TYPE_TEST"_"$ENDPOINT_NAME"_$(date +%Y%m%d-%H%M%S) /src/services/rest/testRunner.js'
```

Replace `<test_type>` with one of the available test types:
- `stress_test`
- `load_test`
- `scalability_test`

Replace `<endpoint_name>` with an available API endpoint:
- `update_pet`
- `add_pet`
- `find_pets_by_status`
- `find_pet_by_id`
- `get_inventory`
- `place_order`
- `create_user`
- `login_user`

## Running Tests Locally with K6
If you want to execute tests without Docker, use:

```
    TYPE_TEST=<test_type> ENDPOINT_NAME=<endpoint_name> \
    bash -c 'k6 run -e TYPE_TEST=$TYPE_TEST -e ENDPOINT_NAME=$ENDPOINT_NAME \
        --console-output=/results/"$TYPE_TEST"_"$ENDPOINT_NAME"_$(date +%Y%m%d-%H%M%S) /src/services/rest/testRunner.js'

```

### Example:
```
 TYPE_TEST=load_test ENDPOINT_NAME=find_pet_by_id \
    bash -c 'k6 run -e TYPE_TEST=$TYPE_TEST -e ENDPOINT_NAME=$ENDPOINT_NAME \
        --console-output=/results/"$TYPE_TEST"_"$ENDPOINT_NAME"_$(date +%Y%m%d-%H%M%S) /src/services/rest/testRunner.js'
```

## Notes
- Ensure Docker is running before executing tests.
- Results will be stored in the `/results/` directory.
- Modify `performanceTestsConfig.js` and `apiEndpoints.js` to configure new test scenarios and API endpoints.

