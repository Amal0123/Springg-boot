/*
 * Copyright 2017 by Walid YAICH <walid.yaich@esprit.tn>
 * This is an Open Source Software
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3
 */

package tn.esprit.spring.service.interfaces;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Project;

/**
 * Cette interface permet de lister les méthodes qui permettent de gérer les informations d'un client.
 * @author Walid YAICH
 *
 */
public interface IClientInfoService {
	public String getProjectsTitlesByClientId(Long clientId);
	public String getFirstNameByClientId(Long clientId);
	public String getLastNameByClientId(Long clientId);
	public default Client addClient(Client client){ throw new UnsupportedOperationException("Il ne faut pas appeler cette methode");}
	public default void addProject(Project project){ throw new UnsupportedOperationException("Il ne faut pas appeler cette methode");}
	public default String getProjectTitle(Long projectid){throw new UnsupportedOperationException("Il ne faut pas appeler cette methode");}
	public default void deleteClient(Client client){throw new UnsupportedOperationException("Il ne faut pas appeler cette methode");}
	public default long countClients(){throw new UnsupportedOperationException("Il ne faut pas appeler cette methode");}
	public default long countClientsByName(String lastName){throw new UnsupportedOperationException("Il ne faut pas appeler cette methode");}
	public default void deleteAllProjects(){throw new UnsupportedOperationException("Il ne faut pas appeler cette methode");}
	public default Long findIdByFirstNameAndLastName(String firstName, String lastName){throw new UnsupportedOperationException("Il ne faut pas appeler cette methode");}
}