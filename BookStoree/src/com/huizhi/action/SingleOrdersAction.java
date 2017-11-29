package com.huizhi.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;
import dao.*;
import entity.*;
@SuppressWarnings("serial")
public class SingleOrdersAction extends ActionSupport{
	
	private OrdersManage ordersManage;
	private BookManage bookManage;
	
	public void setOrdersManage(OrdersManage ordersManage) {
		this.ordersManage = ordersManage;
	}

	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String ordersId = request.getParameter("ordersId");
		int ordersIdInt = Integer.parseInt(ordersId);
		Orders orders = new Orders();
		orders = ordersManage.findOrders(ordersIdInt);
		List<Ordersbook> allOrdersbookByOrders = new ArrayList<Ordersbook>();
		allOrdersbookByOrders = ordersManage.allOrdersbookByOrders(ordersIdInt);
		List<Book> bookList = new ArrayList<Book>();
		for(Ordersbook ordersbook : allOrdersbookByOrders){
			Book book = ordersbook.getBook();
			Bargain bargain = null;
			bargain = bookManage.isBargain(book.getBookId());
			if(bargain != null){
				book.setBookPrice(bargain.getBookNewPrice());
			}
			book.setBookAmount(ordersbook.getBookAmount());
			bookList.add(book);
		}
		request.setAttribute("bookList", bookList);
		request.setAttribute("orders", orders);
		return null;
	}

}
