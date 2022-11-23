package com.nttdata.nttdatacenters.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad de tabla Contract
 * 
 * @author manoli
 *
 */
@Entity
@Table(name = "CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial version. */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractId;

	/** Fecha de vigencia. */
	private Date validityDate;

	/** Fecha de caducidad. */
	private Date expirationDate;

	/** Precio mensual. */
	private double monthlyPrice;

	/** Cliente asociado (FK) */
	private Customer customer;

	/**
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the validityDate
	 */
	@Column(name = "VALIDITY_DATE")
	public Date getValidityDate() {
		return validityDate;
	}

	/**
	 * @param validityDate the validityDate to set
	 */
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	/**
	 * @return the expirationDate
	 */
	@Column(name = "EXPITARION_DATE")
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the monthlyPrice
	 */
	@Column(name = "MONTHLY_PRICE")
	public double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * @param monthlyPrice the monthlyPrice to set
	 */
	public void setMonthlyPrice(double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * @return the customer
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", validityDate=" + validityDate + ", expirationDate="
				+ expirationDate + ", monthlyPrice=" + monthlyPrice + ", customer=" + customer + "]";
	}

	@Override
	@Transient
	public Long getId() {
		return this.contractId;
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}
}
