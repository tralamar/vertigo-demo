package io.vertigo.demo.dao.referentiel;

import javax.inject.Inject;

import io.vertigo.dynamo.impl.persistence.util.DAOBroker;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * ReferentielChoiceDAO
 */
public final class ReferentielChoiceDAO extends DAOBroker<io.vertigo.demo.domain.referentiel.ReferentielChoice, java.lang.String> {
	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public ReferentielChoiceDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.referentiel.ReferentielChoice.class, persistenceManager, taskManager);
	}
}
