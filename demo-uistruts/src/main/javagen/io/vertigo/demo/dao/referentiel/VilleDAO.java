package io.vertigo.demo.dao.referentiel;

import javax.inject.Inject;

import io.vertigo.dynamo.impl.persistence.util.DAOBroker;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * VilleDAO
 */
public final class VilleDAO extends DAOBroker<io.vertigo.demo.domain.referentiel.Ville, java.lang.Long> {
	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public VilleDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.referentiel.Ville.class, persistenceManager, taskManager);
	}
}
