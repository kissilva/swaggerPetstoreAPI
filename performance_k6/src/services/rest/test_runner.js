import * as general_request from './api_request.js';
import * as globals from '../../globals/logger.js';
import * as general_data from '../../resources/api_endpoints.js';
import * as general_setup from '../../resources/performance_tests_config.js';
import { check, sleep } from 'k6';

export let options = general_setup.parametrization_test[__ENV.TYPE_TEST];

export function setup() {
    globals.headersLogs();
}

export default function () {
    let endpointKey = __ENV.ENDPOINT_NAME;
    let endpointData = general_data[endpointKey];

    if (!endpointData) {
        throw new Error(`The endpoint "${endpointKey}" is not defined in general_data`);
    }

    let { endpoint, method, body, params } = endpointData;

    let requestBody = body || null;
    let requestParams = params || {};
    let res = general_request.execute(method, endpoint, requestBody, requestParams);
    let success = check(res, {
        'Status is 200': (r) => r.status === 200
    });
    sleep(1);
    globals.logged(__VU, __ITER, res);
    if (!success) {
        console.error(`ERROR in test for endpoint "${endpoint}"`);
        console.error(`Method: ${method}`);
        console.error(`Status code: ${res.status}`);
        console.error(`Message error: ${res.body}`);
    }
}
