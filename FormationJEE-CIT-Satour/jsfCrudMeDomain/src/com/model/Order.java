package com.model;

// Generated 10 nov. 2013 16:41:30 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.persistence.internal.localization.ToStringLocalization;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name = "order", catalog = "crudjsf")
public class Order implements java.io.Serializable {

	private Integer orderNo;
	private Category category;
	private String productName;
	private int price;
	private int qty;

	public Order() {
	}

	public Order(Category category, String productName, int price, int qty) {
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderNo", unique = true, nullable = false)
	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategory", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "productName", nullable = false)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "price", nullable = false)
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "qty", nullable = false)
	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	


}