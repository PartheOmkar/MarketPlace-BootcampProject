package com.Bootcamp.marketplace.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubOrdersModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subOrderId;
	@ManyToOne
	private ProductsModel product;
	private int subOrderCost;
	private int productQuantity;
	private String subOrderStatus;
	
	public SubOrdersModel() {
		super();
	}

	public SubOrdersModel(ProductsModel product, int subOrderCost, int productQuantity, String subOrderStatus) {
		super();
		this.product = product;
		this.subOrderCost = subOrderCost;
		this.productQuantity = productQuantity;
		this.subOrderStatus = subOrderStatus;
	}

	public int getSubOrderId() {
		return subOrderId;
	}

	public void setSubOrderId(int subOrderId) {
		this.subOrderId = subOrderId;
	}

	public ProductsModel getProduct() {
		return product;
	}

	public void setProduct(ProductsModel product) {
		this.product = product;
	}

	public int getSubOrderCost() {
		return subOrderCost;
	}

	public void setSubOrderCost(int subOrderCost) {
		this.subOrderCost = subOrderCost;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getSubOrderStatus() {
		return subOrderStatus;
	}

	public void setSubOrderStatus(String subOrderStatus) {
		this.subOrderStatus = subOrderStatus;
	}
}
