<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
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
				<h1>添加新书</h1><br/>
				<s:form action="bookAction" method="post" enctype="multipart/form-data">
					<s:textfield label="名称" name="bookName"></s:textfield>
					<s:textfield label="作者" name="bookAuthor"></s:textfield>
					<s:textfield label="出版社" name="bookPress"></s:textfield>
					<s:file label="图片" name="doc"></s:file>
					<s:select label="类别" name="typeId" list="#{'1':'文学','2':'历史','3':'天文','4':'地理','5':'其他'}"></s:select>
					<s:textfield label="价格" name="bookPrice"></s:textfield>
					<s:textfield label="数量" name="bookAmount"></s:textfield>
					<s:textarea label="简介" name="bookRemark"></s:textarea>
					<s:submit value="添加"></s:submit>
				</s:form>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>		
	</center>
</body>
</html>
