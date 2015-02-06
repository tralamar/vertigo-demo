package io.vertigo.demo.dao.commande;

import javax.inject.Inject;

import io.vertigo.dynamo.impl.persistence.util.DAOBroker;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * LigneCommandeDAO
 */
public final class LigneCommandeDAO extends DAOBroker<io.vertigo.demo.domain.commande.LigneCommande, java.lang.Long> {
	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public LigneCommandeDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.commande.LigneCommande.class, persistenceManager, taskManager);
	}
}
