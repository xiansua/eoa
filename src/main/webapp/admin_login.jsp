<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.11.3.min.js"></script>
		<script>
		        // 判断是登录账号和密码是否为空
		        function check(){
		            var userName = $("#userName").val();
		            var userPass = $("#userPass").val();
		            if(userName==="" || userPass===""){
		                $("#message").text("账号或密码不能为空！");
		                return false;
		            }
		            return true;
		        }
		    </script>
</head>
<body>
	<center>
	<font color="red">
		                        <%-- 提示信息--%>
		                        <span id="message"></span>
		                    </font>
		<form action="role/checkAdmin" method="post" onsubmit="return check()">
		名称：<input id="userName" name="userName" type="text" /><br />
		密码：<input id="userPass" name="userPass" type="password" />
		<a href="admin.jsp">login</a>
		</center>
		<center><input type="submit" value="登录"/></center>
		</form>
</body>
</html>