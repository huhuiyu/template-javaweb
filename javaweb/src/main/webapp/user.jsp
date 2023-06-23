<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ page language="java" import="java.util.*" %>
    <%@ page language="java" import="top.huhuiyu.servlet.entity.*" %>
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
        用户信息管理
        <hr>
        <% 
          List<TbUser> list = (List<TbUser>)request.getAttribute("users");
          for(TbUser user : list){
            out.println(String.format("%s<br>%n",user));
          }
        %>
        <hr>

        <form action="<%=request.getContextPath()%>/user.action" method="post">
          <input type="hidden" name="action" value="add">
          <input type="text" name="username" placeholder="登录名">
          <input type="password" name="password" placeholder="密码">
          <input type="text" name="nickname" placeholder="用户名">
          <button id="btnAdd">注册</button>
        </form>

        <script type="module" src="<%=request.getContextPath()%>/js/user.js"></script>

      </body>

      </html>