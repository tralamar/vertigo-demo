package io.vertigo.demo.dao.produit;

import javax.inject.Inject;

import io.vertigo.dynamo.impl.persistence.util.DAOBroker;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * ProduitDAO
 */
public final class ProduitDAO extends DAOBroker<io.vertigo.demo.domain.produit.Produit, java.lang.Long> {
	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public ProduitDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.produit.Produit.class, persistenceManager, taskManager);
	}
}
