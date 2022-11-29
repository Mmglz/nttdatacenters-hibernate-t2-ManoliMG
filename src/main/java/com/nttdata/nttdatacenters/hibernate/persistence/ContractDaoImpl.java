package com.nttdata.nttdatacenters.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Implementación del DAO de Contract
 * 
 * @author manoli
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Sesión de conexión a la BBDD. */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByCustomerId(Long customer) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Busca los clientes por nombre y apellidos.
		return session.createQuery("FROM Contract WHERE CUSTOMER_ID='" + customer + "'").list();
	}
}
