<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>我的订单</title>
    
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
		<div id="orders">
			<div id="left">
				<jsp:include page="left.jsp"></jsp:include>
			</div>
			<div id="ordersInfor"  style="padding-top: 20px;padding-left: 8px;">
				<ul class="singleOrders"  style="background-color: teal;">
					<li style="width: 700px;padding-top: 5px;padding-left: 10px;text-align: left;">
						<a class="aboutOrders" href="allOrders.jsp?searchType=all">所有订单</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="aboutOrders" href="allOrders.jsp?searchType=isDeal">已处理订单</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="aboutOrders" href="allOrders.jsp?searchType=isNotDeal">未处理订单</a>
					</li>
				</ul>
				<ul class="singleOrders" style="background-color: yellow;">
					<li class="sequence">序列</li>			
					<li class="ordersNumber">订单编号</li>			
					<li class="ordersTime">订单日期</li>			
					<li class="isDeal">处理状态</li>			
					<li class="deleteOrders" style="padding-top: 5px;">删除订单</li>			
				</ul>
				<s:action name="ordersAction" executeResult="false"></s:action>
				<s:iterator value="#request.allOrdersByUser" status="st">
					<ul class="singleOrders">
						<li class="sequence"><s:property value="#st.getIndex()+#request.sequence+1"/></li>			
						<li class="ordersNumber">
							<a class="aboutBook" href="singleOrders.jsp?ordersId=<s:property value="ordersId"/>"><s:property value="ordersNumber"/></a>
						</li>			
						<li class="ordersTime"><s:date name="ordersTime" format="yyyy-MM-dd HH:mm:ss"/></li>			
						<li class="isDeal">
							<s:if test='%{isDeal =="0"}'>
								<font style="color: green;">未处理</font>
							</s:if>
							<s:else>
								<font style="color: red;">已处理</font>
							</s:else>
						</li>
						<li class="deleteOrders">
							<input type="button" value="删除" onclick="deleteOrders('<s:property value="ordersId"/>')" />
						</li>			
					</ul>
				</s:iterator>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
<SCRIPT type="text/javascript">
<!--
	function deleteOrders(ordersId){
		if(confirm("确定要订单吗？")){
			location.href="com.huizhi.action/ordersManageAction.action?updateType=delete&ordersId="+ordersId;
		}
	}
//-->
</SCRIPT>
</html>
