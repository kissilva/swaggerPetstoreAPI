
export function headersLogs(virutalUser, Iteration, res) {
  console.log('Virtual User | Iteracion | URL | RqUID | Status Response | Duration (ms) | Sending (ms) | Waiting (ms) | Receiving (ms) | Body Response')
 }

export function logged(virtualUser, Iteration, res) {
  console.log(`${virtualUser} | ${Iteration} | ${res.request.url} | ${res.request.headers['X-Rquid']} | ${res.status} | ${res.timings.duration} | ${res.timings.sending} | ${res.timings.waiting} | ${res.timings.receiving} | ${JSON.stringify(res.body)}`)
}

