/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.service.impl;

import org.springframework.stereotype.Component;

import tn.esprit.spring.service.interfaces.IClientInfoService;


/**
 * 
 * Cette classe permet de gérer les informations client via un web service REST.
 * 
 * NB : Pour des raisons de simplicité, cette classe ne fait pas un vrai appel a un web service REST, 
 * mais retourne des valeurs statiques.
 * 
 * @author Walid YAICH
 *
 */

@Component
public class ClientInfoRESTServiceImpl implements IClientInfoService{
	
	/**
	 * Récupérer le titre du projet en ayant l'id du client
	 * @param clientId l'identifiant du client
	 * @return le titre du projet 
	 */
	@Override
	public String getProjectsTitlesByClientId(Long clientId){
		//Appel a un webservice REST
		return "Gestion des produits <From REST>" ;
	}
	
	
	
	/**
	 * Récupérer le prénom du client en ayant son Id
	 * @param clientId l'identifiant du client
	 * @return le prénom du client
	 */
	@Override
	public String getFirstNameByClientId(Long clientId){
		//Appel a un webservice REST
		return "Walid <From REST>";
	}
	
	
	/**
	 * Récupérer le nom du client en ayant son Id
	 * @param clientId l'identifiant du client
	 * @return String le nom du client
	 */
	@Override
	public String getLastNameByClientId(Long clientId){
		//Appel a un webservice REST
		return "YAICH <From REST>";
	}
	
}
