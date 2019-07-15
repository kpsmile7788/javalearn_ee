<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>

    <body>

    <%@include file="header.jsp"%>

    <%!
        int count2 = 0;
    %>


    <div style="height: 400px">
        <%
            int count1 = 0;
            count1++;
            count2++;
            out.print("1.当前访问人数为--->"+count1+"<br/>");
            out.print("2.当前访问人数为-------->"+count2+"<br/>");
        %>
    </div>

    <%--<%@include file="tail.jsp"%>--%>
    <jsp:include page="tail.jsp"></jsp:include>
    </body>
</html>
