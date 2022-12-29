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
public class CatalogsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catalogId;
	@Column(unique = true)
	private String catalogName;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "catalog_join_products",
			joinColumns = @JoinColumn(name = "catalogId"),
			inverseJoinColumns = @JoinColumn(name ="productId")
			)
	private Collection<ProductsModel> products = new ArrayList<ProductsModel>();

	public CatalogsModel() {
		super();
	}

	public CatalogsModel(String catalogName) {
		super();
		this.catalogName = catalogName;
	}

	public CatalogsModel(String catalogName, Collection<ProductsModel> products) {
		super();
		this.catalogName = catalogName;
		this.products = products;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public Collection<ProductsModel> getProducts() {
		return products;
	}

	public void setProducts(Collection<ProductsModel> products) {
		this.products = products;
	}
	
}
