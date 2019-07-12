<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/11
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript">
        function checkUsername() {
            document.getElementById("nameError").innerHTML = "";
            var username = document.getElementById("username").value;
            if (username == ""){
                document.getElementById("nameError").innerHTML = "用户名不能为空！";
                return false;
            }
            return true;
        }
        function checkPwd() {
            document.getElementById("pwdError").innerHTML = "";
            var pwd = document.getElementById("pwd").value;
            if (pwd.length <= 6) {
                document.getElementById("pwdError").innerHTML = "密码长度需要大于6位！";
                return false;
            }
            return true;
        }
        function checkForm() {
            var flag1 = checkUsername();
            var flag2 = checkPwd();
            return flag1 && flag2;
        }
    </script>
</head>
<body>
<h3>用户登录：</h3>
<form method="get" action="/2/DispatcherAndRedirect" onsubmit="return checkForm()">
    用户名：<input type="text" name="username" id="username" onblur="checkUsername()">
    <span id="nameError">
        <%
            String userError = (String) request.getAttribute("usererror");
            if (userError != null){
                System.out.println(userError);
                out.print(userError);
            }
        %>
    </span>
    <br/>
    密码：<input type="password" id="pwd" name="pwd" onblur="checkPwd()">
    <span id="pwdError">
        <%
            String pwdError = (String) request.getAttribute("pwderror");
            if (pwdError != null){
                System.out.println(pwdError);
                out.print(pwdError);
            }
        %>
    </span>
    <br/>
    <input type="submit" value="登陆" onclick="checkForm()">
</form>
</body>
</html>
