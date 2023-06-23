import { ajax } from './ajax.js';

ajax.setBaseUrl('http://127.0.0.1:10100');

//#region 查询演示

let txtDeptName = document.getElementById('txtDeptName');
let btnQuery = document.getElementById('btnQuery');
let preResult = document.getElementById('preResult');

btnQuery.addEventListener('click', query);

function query() {
  ajax.get(
    '/dept/queryAll',
    {
      deptName: txtDeptName.value,
    },
    (data) => {
      preResult.innerHTML = JSON.stringify(data, null, 2);
    }
  );
}

//#endregion

//#region 添加演示，json格式参数

let txtADeptName = document.getElementById('txtADeptName');
let txtADeptInfo = document.getElementById('txtADeptInfo');
let btnAdd = document.getElementById('btnAdd');
let preInfo = document.getElementById('preInfo');

btnAdd.addEventListener('click', () => {
  ajax.postJson(
    '/dept/add',
    {
      deptName: txtADeptName.value,
      deptInfo: txtADeptInfo.value,
    },
    (data) => {
      preInfo.innerHTML = JSON.stringify(data, null, 2);
    }
  );
});

//#endregion

//#region 删除演示，地址栏参数

let txtDeptId = document.getElementById('txtDeptId');
let btnDel = document.getElementById('btnDel');

btnDel.addEventListener('click', () => {
  ajax.delete(`/dept/delete/${txtDeptId.value}`, (data) => {
    preInfo.innerHTML = JSON.stringify(data, null, 2);
  });
});

//#endregion

// query()
