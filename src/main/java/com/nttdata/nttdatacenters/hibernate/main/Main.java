package com.nttdata.nttdatacenters.hibernate.main;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.nttdatacenters.hibernate.persistence.Contract;
import com.nttdata.nttdatacenters.hibernate.persistence.Customer;
import com.nttdata.nttdatacenters.hibernate.services.ContractManagementServiceI;
import com.nttdata.nttdatacenters.hibernate.services.ContractManagementServiceImpl;
import com.nttdata.nttdatacenters.hibernate.services.CustomerManagementServiceI;
import com.nttdata.nttdatacenters.hibernate.services.CustomerManagementServiceImpl;

/**
 * Clase principal
 * 
 * @author manoli
 *
 */
public class Main {
	
	/** LOGGER **/
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		LOG.info("TRAZA DE INICIO");
		
		// Apertura de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);

		// Auditoría.
		final String updateUser = "NTT_CUSTOMER_CONTRACT";
		final Date updateDate = new Date();

		LOG.info("Generación de clientes y contratos");

		// Generación de clientes.
		final Customer customer1 = new Customer();
		customer1.setName("Maria");
		customer1.setFirstSurname("Perez");
		customer1.setSecondSurname("Garcia");
		customer1.setDni("41567469H");
		customer1.setUpdatedDate(updateDate);
		customer1.setUpdatedUser(updateUser);

		final Customer customer2 = new Customer();
		customer2.setName("Pablo");
		customer2.setFirstSurname("Camacho");
		customer2.setSecondSurname("Delgado");
		customer2.setDni("85317614L");
		customer2.setUpdatedDate(updateDate);
		customer2.setUpdatedUser(updateUser);

		final Customer customer3 = new Customer();
		customer3.setName("Laura");
		customer3.setFirstSurname("Medero");
		customer3.setSecondSurname("Rodriguez");
		customer3.setDni("56841394S");
		customer3.setUpdatedDate(updateDate);
		customer3.setUpdatedUser(updateUser);

		final Customer customer4 = new Customer();
		customer4.setName("Pepe");
		customer4.setFirstSurname("Mejias");
		customer4.setSecondSurname("Roldan");
		customer4.setDni("20553274R");
		customer4.setUpdatedDate(updateDate);
		customer4.setUpdatedUser(updateUser);

		final Customer customer5 = new Customer();
		customer5.setName("Estrella");
		customer5.setFirstSurname("Lopez");
		customer5.setSecondSurname("Blanco");
		customer5.setDni("17349835F");
		customer5.setUpdatedDate(updateDate);
		customer5.setUpdatedUser(updateUser);

		final Contract contract1 = new Contract();
		contract1.setValidityDate(new Date());
		contract1.setExpirationDate(new Date());
		contract1.setMonthlyPrice(5.3);
		contract1.setCustomer(customer1);
		contract1.setUpdatedDate(updateDate);
		contract1.setUpdatedUser(updateUser);

		final Contract contract2 = new Contract();
		contract2.setValidityDate(new Date());
		contract2.setExpirationDate(new Date());
		contract2.setMonthlyPrice(85.9);
		contract2.setCustomer(customer2);
		contract2.setUpdatedDate(updateDate);
		contract2.setUpdatedUser(updateUser);

		final Contract contract3 = new Contract();
		contract3.setValidityDate(new Date());
		contract3.setExpirationDate(new Date());
		contract3.setMonthlyPrice(100);
		contract3.setCustomer(customer3);
		contract3.setUpdatedDate(updateDate);
		contract3.setUpdatedUser(updateUser);

		final Contract contract4 = new Contract();
		contract4.setValidityDate(new Date());
		contract4.setExpirationDate(new Date());
		contract4.setMonthlyPrice(26.7);
		contract4.setCustomer(customer4);
		contract4.setUpdatedDate(updateDate);
		contract4.setUpdatedUser(updateUser);

		final Contract contract5 = new Contract();
		contract5.setValidityDate(new Date());
		contract5.setExpirationDate(new Date());
		contract5.setMonthlyPrice(120);
		contract5.setCustomer(customer5);
		contract5.setUpdatedDate(updateDate);
		contract5.setUpdatedUser(updateUser);

		LOG.info("Fin generación de clientes y contratos");

		LOG.info("Inicio inserciones de clientes y contratos");

		// Inserciones de los clientes.
		customerService.insertNewCustomer(customer1);
		customerService.insertNewCustomer(customer2);
		customerService.insertNewCustomer(customer3);
		customerService.insertNewCustomer(customer4);
		customerService.insertNewCustomer(customer5);

		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);
		contractService.insertNewContract(contract3);
		contractService.insertNewContract(contract4);
		contractService.insertNewContract(contract5);

		LOG.info("Fin inserciones de clientes");

		LOG.info("Inicio de consultas y modificaciones de los clientes y contratos");

		// Consulta de todos los clientes.
		List<Customer> customersList = customerService.searchAll();
		System.out.println("Lista de todos los clientes: ");
		for (final Customer customers : customersList) {

			System.out.println(customers.getCustomerId()+ " " + customers.getDni() + " " + customers.getName() + " "
					+ customers.getFirstSurname() + " " + customers.getSecondSurname() + " "
					+ customers.getCustomerId());
			System.out.println("\n");
		}

		// Actualización del nombre del cliente 4.
		customer4.setName("José");
		customerService.updateCustomer(customer4);

		// Consulta por ID.
		Customer searchId = customerService.searchById((long) 4);
		System.out.println("Consulta por ID: ");
		System.out.println(searchId);
		System.out.println("\n");

		// Eliminación del contrato 5.
		contractService.deleteContract(contract5);


		// Consulta de un cliente por nombre y apellidos.
		List<Customer> searchNameAndSurnames = customerService.searchByNameAndSurnames("Maria", "Perez", "Garcia");
		System.out.println("Consulta de clientes por nombre y apellidos:");
		System.out.println(searchNameAndSurnames);
		
		
		// Consulta de un contrato por el ID del cliente.
		List<Contract> seacrhIdCustomer = contractService.searchByCustomerId(1L);
		System.out.println("Consulta de contrato por ID de cliente:");
		System.out.println(seacrhIdCustomer);
		
		LOG.info("Fin de consultas y modificaciones de los clientes y contratos");

		// Cierre de sesión.
		session.close();
		
		LOG.info("TRAZA DE FIN");
	}
}
