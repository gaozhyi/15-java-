<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>

<body background="../image/body.gif">
	<center>
		<div id="top">
			<div id="logo">
				<a href="http://www.itzcn.com"><img src="../image/logo.gif"/></a>
			</div>
			<div id="logoLink">
				您好，请
				<a href="http://school.itzcn.com/register.html" target="_top">注册</a> | <a href="http://school.itzcn.com/login.php" target="_top">登录</a> | <a href="http://school.itzcn.com/help.html" target="_blank">帮助中心</a>
				| <a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.itzcn.com');" href="#">设为首页</a> | <a href="javascript:window.external.AddFavorite('http://www.itzcn.com')">加入收藏</a>
			</div>
			<div id="welcome">
				<font style="color:green;font-weight: bold">
					 <s:property value="#session.managerLoginName"/>
				</font>
				您好！欢迎光临汇智书店 <a href="../com.huizhi.action/userExitAction.action?userType=manager">安全退出</a>
			</div>
			<hr/>
		</div>
	</center>
</body>
