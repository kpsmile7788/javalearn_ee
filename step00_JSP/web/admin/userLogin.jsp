<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String pwd = request.getParameter("pwd");

            if (username.indexOf(username)>0){
                out.print("登陆成功！");
            } else {
                out.print("登陆失败！");
            }

        %>
    </body>
</html>
