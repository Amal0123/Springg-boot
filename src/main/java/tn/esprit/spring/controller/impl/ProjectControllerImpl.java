/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import tn.esprit.spring.controller.interfaces.IprojectController;
import tn.esprit.spring.entity.Project;
import tn.esprit.spring.service.interfaces.IClientInfoService;


/**
 * 
 * Cette classe sert a implémenter les méthodes qui permettent de gérer un projet.
 * Cette classe représente une implémentation de l'interface <code>IidentityController</code>
 * 
 * @author Walid YAICH
 *
 */
@Component
public class ProjectControllerImpl implements IprojectController  {

	@Autowired
	@Qualifier("clientInfoMySQLServiceImpl")
	private IClientInfoService clientInfoService;
	
	
	/**
	 * Récupérer le titre et les détails du projet en ayant l'id du client
	 * @param clientId l'identifiant du client
	 * @return le titre et les détails du projet
	 */
	@Override
	public String getProjectsTitlesByClientId(Long clientId){
		return clientInfoService.getProjectsTitlesByClientId(clientId);
	}

	
	@Override
	public void addProject(Project project) {
		clientInfoService.addProject(project);
	}


	@Override
	public String getProjectTitle(Long projectid) {
		return clientInfoService.getProjectTitle(projectid);
	} 
	
	@Override
	public void deleteAllProjects() {
		clientInfoService.deleteAllProjects();
	}
	
}
