<%@ page language="java" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>

<body background="image/body.gif">
	<center>
		<div id="top">
			<div id="logo">
				<a href="http://www.itzcn.com"><img src="image/logo.gif"/></a>
			</div>
			<div id="logoLink">
				您好，请
				<a href="http://school.itzcn.com/register.html" target="_top">注册</a> | <a href="http://school.itzcn.com/login.php" target="_top">登录</a> | <a href="http://school.itzcn.com/help.html" target="_blank">帮助中心</a>
				| <a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.itzcn.com');" href="#">设为首页</a> | <a href="javascript:window.external.AddFavorite('http://www.itzcn.com')">加入收藏</a>
			</div>
			<div id="searchBook">
				<a href="firstPage.jsp">首页</a>
				<s:if test="%{#session.loginUser == null}">
					<font style="color:red;font-weight: bold">游客</font> 
					您好！欢迎光临汇智书店 <a href="enroll.jsp">注册</a> <a href="login.jsp">登录</a>
				</s:if>
				<s:else>
					<font style="color:green;font-weight: bold">
						 <s:property value="#session.loginUser.userName"/>
					</font>
					您好！欢迎光临汇智书店
					<a href="personalInformation.jsp">个人信息</a> <a href="shoppingCart.jsp">我的购物车</a> <a href="allOrders.jsp">我的订单</a> <a href="com.huizhi.action/userExitAction.action?userType=ordinaryUser">安全退出</a>
				</s:else>
					&nbsp;&nbsp;&nbsp;&nbsp;按
					<input type="radio" name="searchType" value="bookName" checked="checked"/>名称
					<input type="radio" name="searchType" value="bookAuthor"/>作者
					<input type="radio" name="searchType" value="bookPress"/>出版社
					<input type="text" name="searchDescribe" id="searchDescribeID" />
					<input type="button" value="搜索图书" onclick="searchBook()"/>
			</div>
			<hr/>
		</div>
	</center>
</body>
<SCRIPT type="text/javascript">
<!--
	function searchBook(){
		var searchType = "";
		for (i=0;i<document.all.searchType.length;i++){
		    if (document.all.searchType[i].checked){
		    	searchType = document.all.searchType[i].value;
		    }
	    }
		var searchDescribe = document.getElementById("searchDescribeID").value;
		location.href="oneType.jsp?searchType="+searchType+"&searchDescribe="+searchDescribe;
	}
//-->
</SCRIPT>
</html>