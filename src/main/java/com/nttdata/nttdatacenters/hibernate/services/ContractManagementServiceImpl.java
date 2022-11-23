package com.nttdata.nttdatacenters.hibernate.services;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import com.nttdata.nttdatacenters.hibernate.persistence.Contract;
import com.nttdata.nttdatacenters.hibernate.persistence.ContractDaoI;
import com.nttdata.nttdatacenters.hibernate.persistence.ContractDaoImpl;

/**
 * Implementación del servicio de contrato.
 * 
 * @author manoli
 * 
 */
public class ContractManagementServiceImpl implements ContractManagementServiceI {

	/** DAO */
	private ContractDaoI contractDao;

	/**
	 * Método constructor.
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(Contract newContract) {

		// Verificación de nulidad y existencia.
		if (newContract != null && newContract.getContractId() == null) {

			// Inserción de un nuevo contrato.
			contractDao.insert(newContract);
		}
	}

	@Override
	public void updateContract(Contract updateContract) {

		// Verificación de nulidad y existencia.
		if (updateContract != null && updateContract.getContractId() != null) {

			// Actualización de un contrato
			contractDao.update(updateContract);
		}
	}

	@Override
	public void deleteContract(Contract deleteContract) {
		// Verificación de nulidad y existencia.
		if (deleteContract != null && deleteContract.getContractId() != null) {

			// Eliminación de un contrato
			contractDao.delete(deleteContract);
		}
	}

	@Override
	public Contract searchById(final Long ContractId) {
		Contract contract = null;

		// Verificación de nulidad.
		if (ContractId != null) {

			// Obtención de cliente por ID.
			contract = contractDao.searchById(ContractId);
		}

		return contract;
	}

	@Override
	public List<Contract> searchAll() {

		// Obtención de todos los clientes.
		return contractDao.seacrhAll();
	}

	@Override
	public List<Contract> searchByCustomerId(Long customer) {
		List<Contract> contractList = new ArrayList<>();

		// Verificación de nulidad.
		if (customer != null) {

			// Obtención del cliente por nombre y apellidos.
			contractList = contractDao.searchByCustomerId(customer);
		}

		return contractList;
	}
}
