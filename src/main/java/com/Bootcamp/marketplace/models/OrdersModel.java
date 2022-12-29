package com.Bootcamp.marketplace.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrdersModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private int orderCost;
	private LocalDateTime orderDate;
	
	@OneToMany
	@JoinTable(
			name="orders_join_suborder",
			joinColumns = @JoinColumn(name="orderId"),
			inverseJoinColumns = @JoinColumn(name="subOrderId")
			)
	private Collection<SubOrdersModel> subOrdersModel = new ArrayList<SubOrdersModel>();
	
	@ManyToOne
	private UsersModel user;

	
	public OrdersModel() {
		super();
	}

	public OrdersModel(int orderCost, LocalDateTime orderDate, Collection<SubOrdersModel> subOrdersModel,
			UsersModel user) {
		super();
		this.orderCost = orderCost;
		this.orderDate = orderDate;
		this.subOrdersModel = subOrdersModel;
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Collection<SubOrdersModel> getSubOrdersModel() {
		return subOrdersModel;
	}

	public void setSubOrdersModel(Collection<SubOrdersModel> subOrdersModel) {
		this.subOrdersModel = subOrdersModel;
	}

	public UsersModel getUser() {
		return user;
	}

	public void setUser(UsersModel user) {
		this.user = user;
	}
}
