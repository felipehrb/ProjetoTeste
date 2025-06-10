import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  scenarios: {    
    users_logging_in: {
      executor: 'ramping-vus',
      startVUs: 0,
      stages: [  
        { duration: '2m', target: 500 },
        { duration: '5m', target: 500 },
        { duration: '1m', target: 0 },
      ],
      exec: 'login',
    },
  },
};

export function login() {
  let res = http.post('http://localhost:3000/login', JSON.stringify({
    username: 'testuser',
    password: '1234',
  }), { headers: { 'Content-Type': 'application/json' } });

  check(res, {
    'login OK': (r) => r.status === 200,
    'response time < 500ms': (r) => r.timings.duration < 500,
  });
}

export function handleSummary(data) {
  return {
    'results.json': JSON.stringify(data),
  };
}