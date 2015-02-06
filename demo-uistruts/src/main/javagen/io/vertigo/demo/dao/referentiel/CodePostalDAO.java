package io.vertigo.demo.dao.referentiel;

import javax.inject.Inject;

import io.vertigo.core.Home;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;
import io.vertigo.dynamo.task.metamodel.TaskDefinition;
import io.vertigo.dynamo.task.model.Task;
import io.vertigo.dynamo.task.model.TaskBuilder;
import io.vertigo.dynamo.task.model.TaskResult;
import io.vertigo.dynamo.impl.persistence.util.DAOBroker;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * CodePostalDAO
 */
public final class CodePostalDAO extends DAOBroker<io.vertigo.demo.domain.referentiel.CodePostal, java.lang.Long> {
	/** Liste des taches. */
	private static enum Tasks {
		/** Tache TK_LOAD_CODE_POSTAL_BY_DEP_ID */
		TK_LOAD_CODE_POSTAL_BY_DEP_ID,
	}

	/** Constante de paramètre de la tache DEP_ID. */
	private static final String ATTR_IN_TK_LOAD_CODE_POSTAL_BY_DEP_ID_DEP_ID = "DEP_ID";

	/** Constante de paramètre de la tache DTC_CODE_POSTAL. */
	private static final String ATTR_OUT_TK_LOAD_CODE_POSTAL_BY_DEP_ID_DTC_CODE_POSTAL = "DTC_CODE_POSTAL";

	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public CodePostalDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.referentiel.CodePostal.class, persistenceManager, taskManager);
	}

	/**
	 * Création d'une tache.
	 * @param task Type de la tache
	 * @return Builder de la tache
	 */
	private TaskBuilder createTaskBuilder(final Tasks task) {
		final TaskDefinition taskDefinition = Home.getDefinitionSpace().resolve(task.toString(), TaskDefinition.class);
		return new TaskBuilder(taskDefinition);
	}

	/**
	 * Execute la tache TK_LOAD_CODE_POSTAL_BY_DEP_ID.
	 * @param depId Long 
	 * @return io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.referentiel.CodePostal> dtcCodePostal
	*/
	public io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.referentiel.CodePostal> loadCodePostalByDepId(final Long depId) {
		final Task task = createTaskBuilder(Tasks.TK_LOAD_CODE_POSTAL_BY_DEP_ID)
				.withValue(ATTR_IN_TK_LOAD_CODE_POSTAL_BY_DEP_ID_DEP_ID, depId)
				.build();
		final TaskResult taskResult = getTaskManager().execute(task);
		return taskResult.getValue(ATTR_OUT_TK_LOAD_CODE_POSTAL_BY_DEP_ID_DTC_CODE_POSTAL);
	}

}
