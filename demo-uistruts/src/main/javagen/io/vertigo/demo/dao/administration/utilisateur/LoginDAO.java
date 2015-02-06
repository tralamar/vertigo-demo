package io.vertigo.demo.dao.administration.utilisateur;

import javax.inject.Inject;

import io.vertigo.dynamo.impl.persistence.util.DAOBroker;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * LoginDAO
 */
public final class LoginDAO extends DAOBroker<io.vertigo.demo.domain.administration.utilisateur.Login, java.lang.Long> {
	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public LoginDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.administration.utilisateur.Login.class, persistenceManager, taskManager);
	}
}
