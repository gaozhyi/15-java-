package com.huizhi.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;
import entity.*;
import dao.*;
@SuppressWarnings("serial")
public class ShoppingCartAction extends ActionSupport{
	private BookManage bookManage;
	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	@SuppressWarnings("unchecked")
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String bookId = request.getParameter("bookId");
		List<Book> shoppingBook = new ArrayList<Book>();
		if(session.getAttribute("shoppingBook") == null){
			session.setAttribute("shoppingBook", shoppingBook);
		}
		else{
			shoppingBook = (List<Book>) session.getAttribute("shoppingBook");
		}
		int i = 0;
		for(Book book : shoppingBook){
			if(bookId.equals(book.getBookId()+"")){
				i++;
			}
		}
		if(i == 0){
			Book book = bookManage.findBook(Integer.parseInt(bookId));
			book.setBookAmount(1);
			Bargain bargain = null;
			bargain = bookManage.isBargain(Integer.parseInt(bookId));
			if(bargain != null){
				book.setBookPrice(bargain.getBookNewPrice());
			}
			shoppingBook.add(book);
			double totalMoney = 0;
			if(session.getAttribute("totalMoney") == null){
				session.setAttribute("totalMoney", book.getBookPrice());
			}else{
				totalMoney = (Double) session.getAttribute("totalMoney");
				totalMoney += book.getBookPrice();
				session.removeAttribute("totalMoney");
				session.setAttribute("totalMoney", totalMoney);
			}
			session.removeAttribute("shoppingBook");
			session.setAttribute("shoppingBook", shoppingBook);
		}
		try {
			response.sendRedirect("../singleBook.jsp?bookId="+bookId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
