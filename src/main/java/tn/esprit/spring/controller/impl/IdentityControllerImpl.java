/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.controller.interfaces.IidentityController;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.interfaces.IClientInfoService;

/**
 * 
 * Cette classe représente une implémentation de l'interface <code>IidentityController</code> .
 * Cette classe implémente les méthodes qui permettent de gérer l'identité d'un client.
 * 
 * @author Walid YAICH
 *
 */

@Controller
public class IdentityControllerImpl implements IidentityController {
	
	@Autowired
	@Qualifier("clientInfoMySQLServiceImpl")
	private IClientInfoService clientInfoService;
	
	private Logger logger = LoggerFactory.getLogger(IdentityControllerImpl.class);
	
	/**
	 * Récupérer le nom et prénom d'un client en ayant son Id
	 * @param clientId  l'identifiant du client
	 * @return prénom et nom du client
	 */
	@Override
	public String getFullNameByClientId(Long clientId){
		//Appeler le webservice SOAP
		return  clientInfoService.getFirstNameByClientId(clientId) + " " +
				clientInfoService.getLastNameByClientId(clientId);
	}


	@Override
	public Client addClient(Client client) {
		return clientInfoService.addClient(client);
	}


	@Override
	public void deleteClient(Client client) {
		clientInfoService.deleteClient(client);
	}


	@Override
	public long countClients() {
		return clientInfoService.countClients();
	}


	@Override
	public long countClientsByName(String lastName) {
		return clientInfoService.countClientsByName(lastName);
	}
	
	
	@Override
	public Long findIdByFirstNameAndLastName(String firstName, String lastName) {
		return clientInfoService.findIdByFirstNameAndLastName(firstName, lastName);
	}

}
