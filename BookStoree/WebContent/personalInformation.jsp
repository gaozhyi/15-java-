<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  
<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="personalInformation">
		<s:if test="%{#session.loginUser != null}">
			<h1>个人信息</h1><br/>
			<s:form action="userInforAction" method="post">
				<s:label label="用户名" name="userName" value="%{#session.loginUser.userName}"></s:label>
				<s:textfield label="昵称" name="userNickname" value="%{#session.loginUser.userNickname}"></s:textfield>
				<s:select label="性别" name="sexId" list="#{'1':'男','2':'女','3':'未知'}" value="%{#session.loginUser.sexId}"></s:select>
				<s:textfield label="邮箱" name="userEmail" value="%{#session.loginUser.userEmail}"></s:textfield>
				<s:textfield label="电话" name="userPhone" value="%{#session.loginUser.userPhone}"></s:textfield>
				<s:textfield label="地址" name="userAddress" value="%{#session.loginUser.userAddress}"></s:textfield>
				<s:textarea label="备注" name="userRemark" value="%{#session.loginUser.userRemark}"></s:textarea>
				<s:submit value="修改"></s:submit>
			</s:form>
			<a href="updatePassword.jsp">修改密码</a>
		</s:if>
		<s:else>
			<jsp:forward page="firstPage.jsp"></jsp:forward>
		</s:else>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
</html>
