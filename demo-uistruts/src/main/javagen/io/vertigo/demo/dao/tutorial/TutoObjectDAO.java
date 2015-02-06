package io.vertigo.demo.dao.tutorial;

import javax.inject.Inject;

import io.vertigo.dynamo.impl.persistence.util.DAOBroker;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * TutoObjectDAO
 */
public final class TutoObjectDAO extends DAOBroker<io.vertigo.demo.domain.tutorial.TutoObject, java.lang.Long> {
	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public TutoObjectDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.tutorial.TutoObject.class, persistenceManager, taskManager);
	}
}
