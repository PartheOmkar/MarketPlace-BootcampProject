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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProductsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column(unique = true)
	private String productName;
	private int productPrice;
	private int productQuantity;
	
	@ManyToOne
	private CatalogsModel catalog;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "product_join_suborders",
			joinColumns = @JoinColumn(name = "productId"),
			inverseJoinColumns = @JoinColumn(name = "subOrderId")
			)
	private Collection<SubOrdersModel> subOrders = new ArrayList<SubOrdersModel>();

	public ProductsModel() {
		super();
	}

	public ProductsModel(String productName, int productPrice, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public ProductsModel(String productName, int productPrice, int productQuantity, CatalogsModel catalog) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.catalog = catalog;
	}

	public void updateProductQuantity(int newQuantity) {
		this.productQuantity = productQuantity+newQuantity;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public CatalogsModel getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogsModel catalog) {
		this.catalog = catalog;
	}

	public Collection<SubOrdersModel> getSubOrders() {
		return subOrders;
	}

	public void setSubOrders(Collection<SubOrdersModel> subOrders) {
		this.subOrders = subOrders;
	}
	
}
