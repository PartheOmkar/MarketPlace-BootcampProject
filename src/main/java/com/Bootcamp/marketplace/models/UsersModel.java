package com.Bootcamp.marketplace.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class UsersModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@Column(unique = true)
	private String userEmail;
	private String userPassword;
	private String userRole;
	private int userBalance;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_join_orders",
			joinColumns = @JoinColumn(name="userId"),
			inverseJoinColumns = @JoinColumn(name = "orderId")
			)
	private Collection<OrdersModel> orders = new ArrayList<OrdersModel>();

	public UsersModel() {
		super();
	}

	public UsersModel(String userName, String userEmail, String userPassword) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public UsersModel(String userName, String userEmail, String userPassword, String userRole, int userBalance) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userBalance = userBalance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public int getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}

	public Collection<OrdersModel> getOrders() {
		return orders;
	}

	public void setOrders(Collection<OrdersModel> orders) {
		this.orders = orders;
	}
	
}
