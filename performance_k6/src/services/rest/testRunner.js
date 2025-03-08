import * as getGeneral from './apiRequest.js';
import * as globals from '../../globals/logger.js';
import * as general_data from '../../resources/apiEndpoints.js';
import * as setupGeneral from '../../resources/performanceTestsConfig.js';
import { check, sleep } from 'k6';

export let options = setupGeneral.parametrization_test[__ENV.TYPE_TEST];

export function setup() {
    globals.headersLogs();
}
export default function () {
    let endpointKey = __ENV.ENDPOINT_NAME ;
    let endpointData = general_data[endpointKey];

    if (!endpointData) {
        throw new Error(`El endpoint "${endpointKey}" no está definido en general_data`);
    }

    let { endpoint, method, body, params } = endpointData;

    let requestBody = body || null;
    let requestParams = params || {}; 

    let res = getGeneral.execute(method, endpoint, requestBody, requestParams);

    check(res, { 'Status is 200': (r) => r.status === 200 });

    sleep(1);
    globals.logged(__VU, __ITER, res);
}
