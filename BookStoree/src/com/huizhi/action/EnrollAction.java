package com.huizhi.action;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

import dao.PersonManage;
import entity.*;

@SuppressWarnings("serial")
public class EnrollAction extends ActionSupport{
		
	private String userName;
	private String userPassword;
	private String userRePassword;
	private String userEmail;
	private PersonManage personManage;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRePassword() {
		return userRePassword;
	}
	public void setUserRePassword(String userRePassword) {
		this.userRePassword = userRePassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setPersonManage(PersonManage personManage) {
		this.personManage = personManage;
	}
	
	public String execute(){
		User newUser = new User();
		newUser.setUserName(userName);
		newUser.setUserPassword(userPassword);
		newUser.setUserEmail(userEmail);
		Sex sex = personManage.findSex(3);
		newUser.setSex(sex);
		personManage.addUser(newUser);
		return "success";
	}
	public void validate(){
		if(!Pattern.matches("[a-zA-Z][a-zA-Z0-9]{5,15}", userName)){
			addFieldError("userName", "用户名请使用6-16位英文字母或数字，且以字母开头！");
		}
		if(!Pattern.matches("[a-zA-Z0-9]{6,12}", userPassword)){
			addFieldError("userPassword", "密码请使用6-12位英文字母或数字！");
		}
		if(!userRePassword.equals(userPassword)){
			addFieldError("userRePassword", "两次密码不一致！");
		}
		if("".equals(userEmail.trim())){
			addFieldError("userEmail", "邮箱不能为空！");
		}
		boolean flag = true; 
		flag = personManage.isUserNameExist(userName);
		if(flag){
			addFieldError("userName", "用户名已经存在！");
		}
	}
}
