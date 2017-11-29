package com.huizhi.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import dao.BookManage;
import entity.*;

@SuppressWarnings("serial")
public class LeftAction extends ActionSupport{
	private BookManage bookManage;
	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	public String execute(){
		//œ˙¡ø≈≈––∞Ò
		List<Book>	bestSellingBook = bookManage.bestSellingBook(1, 10);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bestSellingBook", bestSellingBook);
		return null;
	}
}
