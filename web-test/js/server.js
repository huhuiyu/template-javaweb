import { AjaxClass } from './AjaxClass.js';

let server = new AjaxClass(
  'http://127.0.0.1:8080/javaweb',
  'javaweb_token_key'
);

export default server;
export { server as server };
