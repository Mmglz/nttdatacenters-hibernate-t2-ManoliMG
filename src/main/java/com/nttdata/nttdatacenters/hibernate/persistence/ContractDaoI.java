package com.nttdata.nttdatacenters.hibernate.persistence;

import java.util.List;

/**
 * Interfaz del DAO de Contract
 * 
 * @author manoli
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract>{

	/**
	 * Búsqueda por indentificador de ciente.
	 * 
	 * @param customerId
	 * @return List<Contract>
	 */
	public List<Contract> searchByCustomerId(Long customer);
}
