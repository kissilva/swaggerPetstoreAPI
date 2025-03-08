import http from "k6/http";
import * as general_data from '../../resources/apiEndpoints.js';


export let execute = (method, endpoint,paramsData=null, bodyData = null) => {
    const url = `${general_data.base_url}${endpoint}`;  

    let params= paramsData ? general_data.params : null;
    let payload = bodyData ? JSON.stringify(bodyData) : null; 

    return http.request(method, url, payload, params); 
};
