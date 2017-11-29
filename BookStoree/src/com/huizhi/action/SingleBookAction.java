package com.huizhi.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.BookManage;
import entity.*;

@SuppressWarnings("serial")
public class SingleBookAction extends ActionSupport{

	private BookManage bookManage;

	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String bookId = request.getParameter("bookId");
		int bookIdInt = Integer.parseInt(bookId);
		Book book = new Book();
		book = bookManage.findBook(bookIdInt);
		Bargain bargain = null;
		bargain = bookManage.isBargain(bookIdInt);
		if(bargain == null){
			book.setBookNewPrice(book.getBookPrice());
		}else{
			book.setBookNewPrice(bargain.getBookNewPrice());
		}
		request.setAttribute("singleBook", book);
		return null;
	}
}
