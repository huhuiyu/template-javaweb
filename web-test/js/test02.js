import { ajax } from './ajax.js';

ajax.setBaseUrl('http://127.0.0.1:8080/javaweb');

//#region 查询演示

let txtUserName = document.getElementById('txtUserName');
let selEnable = document.getElementById('selEnable');
let btnQuery = document.getElementById('btnQuery');
let preResult = document.getElementById('preResult');

btnQuery.addEventListener('click', query);

function query() {
  ajax.get(
    '/user/query.servlet',
    {
      username: txtUserName.value,
      enable: selEnable.value,
    },
    (data) => {
      preResult.innerHTML = JSON.stringify(data, null, 2);
    }
  );
}

//#endregion

//#region 添加演示，json格式参数

let txtAUsername = document.getElementById('txtAUsername');
let txtAPwd = document.getElementById('txtAPwd');
let txtANickname = document.getElementById('txtANickname');
let btnAdd = document.getElementById('btnAdd');
let preInfo = document.getElementById('preInfo');

btnAdd.addEventListener('click', () => {
  ajax.post(
    '/user/add.servlet',
    {
      username: txtAUsername.value,
      password: txtAPwd.value,
      nickname: txtANickname.value,
    },
    (data) => {
      preInfo.innerHTML = JSON.stringify(data, null, 2);
    }
  );
});

//#endregion
