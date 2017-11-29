package entity;

import java.sql.*;

@SuppressWarnings("serial")
public class Orders implements java.io.Serializable {

	private Integer ordersId;
	private String ordersNumber;
	private User user;
	private Timestamp ordersTime;
	private String isDeal;
	private Double totalMoney;

	public Orders() {
	}

	public Orders(String ordersNumber,User user, Timestamp ordersTime,String isDeal,Double totalMoney) {
		this.ordersNumber = ordersNumber;
		this.user = user;
		this.ordersTime = ordersTime;
		this.isDeal = isDeal;
		this.totalMoney = totalMoney;
	}

	public Integer getOrdersId() {
		return this.ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	public String getOrdersNumber() {
		return ordersNumber;
	}

	public void setOrdersNumber(String ordersNumber) {
		this.ordersNumber = ordersNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getOrdersTime() {
		return this.ordersTime;
	}

	public void setOrdersTime(Timestamp ordersTime) {
		this.ordersTime = ordersTime;
	}

	public String getIsDeal() {
		return isDeal;
	}

	public void setIsDeal(String isDeal) {
		this.isDeal = isDeal;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

}