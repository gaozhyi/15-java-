<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>汇智网上书店</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>	
		<div id="managePage">
			<div id="manageLeft">
				<jsp:include page="manageLeft.jsp"></jsp:include>	
			</div>
			<div id="manageWelcome">
				<div style="font-weight: bold;font-size: 16px;">欢迎您：
					<font style="color: green;font-size: 24px;"><s:property value="#session.managerLoginName"/></font>
				</div>
				<div style="margin-top: 100px;">
					汇智公司旗下网上书店
					<hr style="width: 200px;"/>
					一切为您着想&nbsp;&nbsp;&nbsp;&nbsp;为您着想一切
				</div>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>		
	</center>
</body>
</html>
