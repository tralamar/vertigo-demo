package io.vertigo.demo.dao.commande;

import javax.inject.Inject;

import io.vertigo.dynamo.impl.persistence.util.DAOBroker;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * CommandeDAO
 */
public final class CommandeDAO extends DAOBroker<io.vertigo.demo.domain.commande.Commande, java.lang.Long> {
	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public CommandeDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.commande.Commande.class, persistenceManager, taskManager);
	}
}
