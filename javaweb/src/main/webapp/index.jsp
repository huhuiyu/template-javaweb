<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="zh-cmn-Hans">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>程序猿学习-胡辉煜</title>
    <meta name="author" content="胡辉煜">
    <meta name="keywords" content="胡辉煜">
    <meta name="description" content="胡辉煜-程序猿学习">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="shortcut icon" href="https://media.huhuiyu.top/huhuiyu.top/hu-logo.jpg" type="image/jpeg">

  </head>

  <body>
    <h1>javaweb应用 <%= new java.util.Date() %>
    </h1>
    <hr>
    <form action="demo.do" method="GET">
      <input name="name">
      <input type="submit">
    </form>
    <hr>
    <form action="demo.do" method="POST">
      <input name="name">
      <input type="submit">
    </form>
    <hr />
    <a href="json.action">json数据</a>
    <hr />
    <a href="user.action">用户信息</a>
    <hr />

  </body>

  </html>