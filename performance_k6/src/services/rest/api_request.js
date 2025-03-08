import http from "k6/http";
import * as general_data from '../../resources/api_endpoints.js';

export let execute = (method, endpoint, bodyData = null, paramsData = null) => {
    const url = `${general_data.base_url}${endpoint}`;
    let params = paramsData ? paramsData : {};
    let payload = bodyData ? JSON.stringify(bodyData) : null;
    return http.request(method, url, payload, params);
};