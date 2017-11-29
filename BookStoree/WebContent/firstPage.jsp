<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>ª„÷«Õ¯…œ ÈµÍ</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  
<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="firstPage">
			<div id="left">
				<jsp:include page="left.jsp"></jsp:include>
			</div>	
			<div id="allBook">
				<jsp:include page="allBook.jsp"></jsp:include>
			</div>		
		</div>
		<jsp:include page="bottom.html"></jsp:include>
  	</center>
</body>
</html>
