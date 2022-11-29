package com.nttdata.nttdatacenters.hibernate.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad de tabla Customer
 * 
 * @author manoli
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer extends AbstractEntity implements Serializable {

	/** Serial Version. */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) **/
	private Long customerId;

	/** Nombre del cliente. **/
	private String name;

	/** Primer apellido. **/
	private String firstSurname;

	/** Segundo apellido. **/
	private String secondSurname;

	/** Número de documendo de identidad. **/
	private String dni;
	
	/** Lista de contratos relacionados */
	private List<Contract> contractList;

	/**
	 * @return the customerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstSurname
	 */
	@Column(name = "FIRST_SURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * @param firstSurname the firstSurname to set
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * @return the secondSurname
	 */
	@Column(name = "SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param secondSurname the secondSurname to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "DNI", unique = true, nullable = false, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * @return the contractList
	 */
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Contract> getContractList() {
		return contractList;
	}

	/**
	 * @param contractList the contractList to set
	 */
	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + ", dni=" + dni + "]";
	}

	@Override
	@Transient
	public Long getId() {
		return this.customerId;
	}
	
	@Transient
	public Class<?> getClase() {
		return Customer.class;
	}

}
