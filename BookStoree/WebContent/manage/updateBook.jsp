<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改图书</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="managePage">
			<div id="manageLeft">
				<jsp:include page="manageLeft.jsp"></jsp:include>
			</div>	
			<div id="addBook">
			<s:action name="singleBookAction" executeResult="false"></s:action>
				<h1>修改图书</h1><br/>
				<s:form action="updateBookAction" method="post" enctype="multipart/form-data">
					<s:hidden name="bookId" value="%{#request.singleBook.bookId}"></s:hidden>
					<s:textfield label="名称" name="bookName" value="%{#request.singleBook.bookName}"></s:textfield>
					<s:textfield label="作者" name="bookAuthor" value="%{#request.singleBook.bookAuthor}"></s:textfield>
					<s:textfield label="出版社" name="bookPress" value="%{#request.singleBook.bookPress}"></s:textfield>
					<s:file label="图片" name="doc"></s:file>
					<s:select label="类别" name="typeId" value="%{#request.singleBook..type.typeId}" list="#{'1':'文学','2':'历史','3':'天文','4':'地理','5':'其他'}"></s:select>
					<s:textfield label="价格" name="bookPrice" value="%{#request.singleBook.bookPrice}"></s:textfield>
					<s:textfield label="数量" name="bookAmount" value="%{#request.singleBook.bookAmount}"></s:textfield>
					<s:textarea label="简介" name="bookRemark" value="%{#request.singleBook.bookRemark}"></s:textarea>
					<s:submit value="修改"></s:submit>
				</s:form>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>		
	</center>
</body>
</html>
