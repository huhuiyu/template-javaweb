import { server } from './server.js';

let preResult = document.getElementById('preResult');

server.post('/json.action', { test: '请求参数' }, (data) => {
  preResult.append(JSON.stringify(data, null, 2));
});
