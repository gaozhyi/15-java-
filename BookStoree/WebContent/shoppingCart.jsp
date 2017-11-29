<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>购物车</title>
    
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
		<div id="shoppingCart">
			<div id="left">
				<jsp:include page="left.jsp"></jsp:include>
			</div>
			<div id="shoppingBook" style="padding-top: 20px;padding-left: 8px;">
				<ul class="shoppingBookUl">
					<li class="shoppingBookHead">我的购物车</li>
				</ul>
				<ul class="shoppingBookUl" style="background-color: yellow;">
					<li class="sequence">序列</li>
					<li class="bookName">图书名称</li>
					<li class="bookPrice">图书价格</li>
					<li class="bookAmount" style="padding-top: 5px;">购买数量</li>
					<li class="delete" style="padding-top: 5px;">删除图书</li>
				</ul>
				<s:if test="%{#session.shoppingBook != null}">
					<s:iterator value="#session.shoppingBook" status="st">
						<ul class="shoppingBookUl">
							<li class="sequence">
								<s:property value="#st.getIndex()+1"/>
							</li>
							<li class="bookName"><a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookId" />"><s:property value="bookName"/></a></li>
							<li class="bookPrice"><s:property value="bookPrice"/> 元</li>
							<li class="bookAmount">
								<input type="text" id="bookAmount<s:property value="bookId"/>" value='<s:property value="bookAmount"/>'/>
								<input type="button" value="修改" onclick="updateBookAmount('<s:property value="bookId"/>')">
							</li>
							<li class="delete">
								<input type="button" value="删除" onclick="deleteBook('<s:property value="bookId"/>')">
							</li>
						</ul>
					</s:iterator>
					<ul class="shoppingBookUl">
						<li class="shoppingBookHead">
						<s:if test="%{#session.shoppingBook.size() > 0}">
							<input type="button" value="确定购买" onclick="addOrders()">
						</s:if>
							总计金额：<s:property value="#session.totalMoney"/> 元
						</li>
					</ul>
				</s:if>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
<SCRIPT type="text/javascript">
<!--
	function updateBookAmount(bookId){
		var pattern = /^[1-9][0-9]{0,}$/;
		var bookAmount = document.getElementById("bookAmount"+bookId).value;
		if(pattern.test(bookAmount)){
			location.href = "com.huizhi.action/updateCartAction.action?updateType=update&bookId="+bookId+"&bookAmount="+bookAmount;
		}
	}
	function deleteBook(bookId){
		if(confirm("确定要删除吗？")){
			location.href = "com.huizhi.action/updateCartAction.action?updateType=delete&bookId="+bookId;
		}
	}
	function addOrders(){
		if(confirm("确定要购买吗？")){
			location.href = "com.huizhi.action/ordersManageAction.action?updateType=add";
		}
	}
//-->
</SCRIPT>
</html>
