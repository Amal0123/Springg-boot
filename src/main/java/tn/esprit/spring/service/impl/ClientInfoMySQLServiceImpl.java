/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Project;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.ProjectRepository;
import tn.esprit.spring.service.interfaces.IClientInfoService;

/**
 * 
 * Cette classe permet de gérer les informations client.
 * 
 * @author Walid YAICH
 *
 */
@Component
public class ClientInfoMySQLServiceImpl implements IClientInfoService{
	
	private Logger logger = LoggerFactory.getLogger(ClientInfoMySQLServiceImpl.class);
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	/**
	 * Récupérer les titres des projets en ayant l'id du client
	 * @param clientId l'identifiant du client
	 * @return les titres des projets 
	 * 
	 */
	@Override
	public String getProjectsTitlesByClientId(Long clientId){
		StringBuilder projectsTitles = new StringBuilder();
		List<Project> projects = projectRepository.findByClient(new Client(clientId));
		for(Project project : projects){
			projectsTitles.append(project.getTitle());
			projectsTitles.append(" , ");
		}
		return projectsTitles.toString();
	}
	
	
	/**
	 * Récupérer le prénom du client en ayant son Id
	 * @param clientId l'identifiant du client
	 * @return le prénom du client
	 */
	@Override
	public String getFirstNameByClientId(Long clientId){
		Client client = clientRepository.findById(clientId);
		return client.getFirstName();
	}
	
	
	/**
	 * Récupérer le nom du client en ayant son Id
	 * @param clientId l'identifiant du client
	 * @return String le nom du client
	 */
	@Override
	public String getLastNameByClientId(Long clientId){
		return clientRepository.findLastNameById(clientId);
	}
	
	
	@Override
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}
	
	
	@Override
	public void addProject(Project project) {
		projectRepository.save(project);
	}
	
	@Override
	public String getProjectTitle(Long projectid) {
		return projectRepository.findOne(projectid).getTitle();
	}
	
	
	@Override
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public long countClients() {
		return clientRepository.count();
	}
	
	@Override
	public long countClientsByName(String lastName) {
		return clientRepository.countClientsByName(lastName);
	}
	
	@Override
	public void deleteAllProjects() {
		projectRepository.deleteAll();
	}
	
	@Override
	public Long findIdByFirstNameAndLastName(String firstName, String lastName) {
		return clientRepository.findByFirstNameAndLastName(firstName, lastName).getId();
	}
	
}
