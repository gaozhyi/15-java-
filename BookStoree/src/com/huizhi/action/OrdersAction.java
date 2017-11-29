package com.huizhi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.*;
import entity.*;
import java.util.*;

@SuppressWarnings("serial")
public class OrdersAction extends ActionSupport{

	private OrdersManage ordersManage;

	public void setOrdersManage(OrdersManage ordersManage) {
		this.ordersManage = ordersManage;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		List<Orders> allOrdersByUser = new ArrayList<Orders>();
		String searchType = request.getParameter("searchType");
		if(searchType == null || "".equals(searchType.trim())){
			searchType = "all";
		}
		if("all".equals(searchType)){
			allOrdersByUser = ordersManage.allOrdersByUser(user.getUserId(), 1, 5);
		}
		if("isDeal".equals(searchType)){
			allOrdersByUser = ordersManage.allOrdersByUserDeal(user.getUserId(), "1", 1, 5);
		}
		if("isNotDeal".equals(searchType)){
			allOrdersByUser = ordersManage.allOrdersByUserDeal(user.getUserId(), "0", 1, 5);
		}
		request.setAttribute("allOrdersByUser", allOrdersByUser);
		int sequence = (1-1)*5;
		request.setAttribute("sequence", sequence);
		return null;
	}
}
