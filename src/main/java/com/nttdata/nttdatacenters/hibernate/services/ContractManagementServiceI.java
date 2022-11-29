package com.nttdata.nttdatacenters.hibernate.services;

import java.util.List;
import com.nttdata.nttdatacenters.hibernate.persistence.Contract;

/**
 * Interfaz del servicio de contrato.
 * 
 * @author manoli
 *
 */
public interface ContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updateContract
	 */
	public void updateContract(final Contract updateContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deleteContract
	 */
	public void deleteContract(final Contract deleteContract);

	/**
	 * Obtiene un contrato por su id.
	 * 
	 * @param ContractId
	 * @return Contract
	 */
	public Contract searchById(final Long ContractId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();
	
	/**
	 * Obtiene un contrato por el ID del cliente.
	 * 
	 * @param customer
	 * @return List<Contract>
	 */
	public List<Contract> searchByCustomerId(Long customer);
}
