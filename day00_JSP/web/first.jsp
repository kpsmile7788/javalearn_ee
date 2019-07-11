<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>我的第一个JSP程序</title>
        <script type="text/javascript">
            function show() {
                var now = new Date();
                document.getElementById("time").innerHTML="客户端时间是---->"+now.toLocaleString();
            }
        </script>
    </head>

    <body onload="show()">
        <%
          Date date = new Date();
          System.out.println("服务器时间是----->"+date.toLocaleString());
          out.println("服务器时间是-------------------->"+date.toLocaleString()+"<br/>");
        %>
        <div id="time"></div>
    </body>
</html>
