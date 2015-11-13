package com.liyi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TCustomer entity. @author MyEclipse Persistence Tools
 */
@Entity(name="tCustomer")
@Table(name = "t_customer", catalog = "test")
public class TCustomer implements java.io.Serializable {

	// Fields

	private Integer customerId;
	private String customerName;
	private String customerPass;
	private Integer customerSex;

	// Constructors

	/** default constructor */
	public TCustomer() {
	}

	/** full constructor */
	public TCustomer(String customerName, String customerPass,
			Integer customerSex) {
		this.customerName = customerName;
		this.customerPass = customerPass;
		this.customerSex = customerSex;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "customerId", unique = true, nullable = false)
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "customerName", nullable = false)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "customerPass", nullable = false)
	public String getCustomerPass() {
		return this.customerPass;
	}

	public void setCustomerPass(String customerPass) {
		this.customerPass = customerPass;
	}

	@Column(name = "customerSex", nullable = false)
	public Integer getCustomerSex() {
		return this.customerSex;
	}

	public void setCustomerSex(Integer customerSex) {
		this.customerSex = customerSex;
	}

}