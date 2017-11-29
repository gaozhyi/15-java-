<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
 
<html> 
	<head>
		<title>用户注册</title>
	</head>
	<body>
		<center>
			<jsp:include page="top.jsp"></jsp:include>
			<div id="enroll">
				<h1>用户注册</h1><br/>
				<s:form action="enrollAction">
					<s:textfield label="用户名" name="userName"></s:textfield>
					<s:password label="密码" name="userPassword"></s:password>
					<s:password label="重复密码" name="userRePassword"></s:password>
					<s:textfield label="邮箱" name="userEmail"></s:textfield>
					<s:submit value="注册"></s:submit>					
				</s:form>
			</div>
			<jsp:include page="bottom.html"></jsp:include>
		</center>
	</body>
</html>

