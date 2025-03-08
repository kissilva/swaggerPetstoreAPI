module.exports = {
    "parametrization_test": {
        "stress_test": {
            stages: [
                { duration: '2m', target: 10 }, 
                { duration: '5m', target: 20 },
                { duration: '5m', target: 40 },
                { duration: '5m', target: 60 },
                { duration: '5m', target: 80 },
                { duration: '5m', target: 100 },
                { duration: '10m', target: 0 },
            ],
            thresholds: {
                http_req_duration: ['p(99)<500'], 
                http_req_failed: ['rate<0.02'], 
            },
            tags: {
                stack: 'GETs',
                layer: 'TEST',
                env: 'qa',
                service: 'PetStore API', 
                type_test: 'stress_test'
            }
        },
        "load_test": {
            stages: [
                { duration: '5m', target: 10 }, 
                { duration: '10m', target: 40 }, 
                { duration: '5m', target: 0 }, 
            ],
            thresholds: {
                http_req_duration: ['p(99)<500'], 
                http_req_failed: ['rate<0.01'], 
            },
            tags: {
                stack: 'GETs',
                layer: 'TestGets',
                env: 'qa',
                service: 'PetStore API', 
                type_test: 'load_test'
            }
        },
        "scalability_test": {
            stages: [
                { duration: '3m', target: 10 },  
                { duration: '5m', target: 20 },
                { duration: '5m', target: 50 },
                { duration: '5m', target: 100 }, 
                { duration: '5m', target: 150 }, 
                { duration: '5m', target: 200 }, 
                { duration: '10m', target: 0 }  
            ],
            thresholds: {
                http_req_duration: ['p(99)<500'], 
                http_req_failed: ['rate<0.02'], 
            },
            tags: {
                stack: 'GETs',
                layer: 'TEST',
                env: 'qa',
                service: 'PetStore API', 
                type_test: 'scalability_test'
            }
        }
    }
}