package com.huizhi.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import dao.BookManage;
import entity.*;

@SuppressWarnings("serial")
public class AllBookAction extends ActionSupport{
	
	private BookManage bookManage;
	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public String execute(){
		//推荐书
		List<Recommended> allRecommended = bookManage.allRecommended(1, 6);
		List<Book> recommendedBook = new ArrayList<Book>();
		for(Recommended recommended : allRecommended){
			Book book = new Book();
			book = recommended.getBook();
			recommendedBook.add(book);
		}
		//特价书
		List<Bargain> allBargain = bookManage.allBargain(1, 6);
		List<Book> bargainBook = new ArrayList<Book>();
		for(Bargain bargain : allBargain){
			Book book = new Book();
			book = bargain.getBook();
			bargainBook.add(book);
		}
		//新书
		List<Book> latestBook = bookManage.latestBook(1, 6);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("recommendedBook", recommendedBook);
		request.setAttribute("bargainBook", bargainBook);
		request.setAttribute("latestBook", latestBook);
		
		return null;
	}

}
