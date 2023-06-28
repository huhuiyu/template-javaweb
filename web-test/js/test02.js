import { server } from './server.js';

let preInfo = document.getElementById('preInfo');

//#region 获取用户和安全退出部分

let btnUser = document.getElementById('btnUser');
let btnLogout = document.getElementById('btnLogout');

btnUser.addEventListener('click', () => {
  server.post('/user/info.token', {}, (data) => {
    preInfo.innerHTML = '用户信息：' + JSON.stringify(data);
  });
});

btnLogout.addEventListener('click', () => {
  server.post('/user/logout.token', {}, (data) => {
    preInfo.innerHTML = '用户安全退出信息：' + JSON.stringify(data);
  });
});

//#endregion

//#region 用户登录部分

let txtUsername = document.getElementById('txtUsername');
let txtPassword = document.getElementById('txtPassword');
let btnLogin = document.getElementById('btnLogin');

btnLogin.addEventListener('click', () => {
  server.post(
    '/user/login.token',
    {
      username: txtUsername.value,
      password: txtPassword.value,
    },
    (data) => {
      preInfo.innerHTML = '用户登录信息：' + JSON.stringify(data);
    }
  );
});

//#endregion
