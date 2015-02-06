package io.vertigo.demo.dao.administration.utilisateur;

import javax.inject.Inject;

import io.vertigo.core.Home;
import io.vertigo.lang.Option;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.task.TaskManager;
import io.vertigo.dynamo.task.metamodel.TaskDefinition;
import io.vertigo.dynamo.task.model.Task;
import io.vertigo.dynamo.task.model.TaskBuilder;
import io.vertigo.dynamo.task.model.TaskResult;
import io.vertigo.dynamo.impl.persistence.util.DAOBroker;

/**
 * DAO : Accès à un object (DTO, DTC). 
 * UtilisateurDAO
 */
public final class UtilisateurDAO extends DAOBroker<io.vertigo.demo.domain.administration.utilisateur.Utilisateur, java.lang.Long> {
	/** Liste des taches. */
	private static enum Tasks {
		/** Tache TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN */
		TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN,
		/** Tache TK_LIST_UTILISATEUR_BY_CRITERE */
		TK_LIST_UTILISATEUR_BY_CRITERE,
		/** Tache TK_LIST_UTILISATEUR_BY_ROLE */
		TK_LIST_UTILISATEUR_BY_ROLE,
	}

	/** Constante de paramètre de la tache LOGIN. */
	private static final String ATTR_IN_TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN_LOGIN = "LOGIN";

	/** Constante de paramètre de la tache DTO_UTILISATEUR. */
	private static final String ATTR_OUT_TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN_DTO_UTILISATEUR = "DTO_UTILISATEUR";

	/** Constante de paramètre de la tache CRYPTED_PASSWORD. */
	private static final String ATTR_IN_TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN_CRYPTED_PASSWORD = "CRYPTED_PASSWORD";

	/** Constante de paramètre de la tache DTO_UTILISATEUR_CRITERE. */
	private static final String ATTR_IN_TK_LIST_UTILISATEUR_BY_CRITERE_DTO_UTILISATEUR_CRITERE = "DTO_UTILISATEUR_CRITERE";

	/** Constante de paramètre de la tache DTC_UTILISATEUR. */
	private static final String ATTR_OUT_TK_LIST_UTILISATEUR_BY_CRITERE_DTC_UTILISATEUR = "DTC_UTILISATEUR";

	/** Constante de paramètre de la tache ROL_CODE. */
	private static final String ATTR_IN_TK_LIST_UTILISATEUR_BY_ROLE_ROL_CODE = "ROL_CODE";

	/** Constante de paramètre de la tache DTC_UTILISATEUR. */
	private static final String ATTR_OUT_TK_LIST_UTILISATEUR_BY_ROLE_DTC_UTILISATEUR = "DTC_UTILISATEUR";

	 
	/**
	 * Contructeur.
	 * @param persistenceManager Manager de persistance
	 * @param taskManager Manager de Task
	 */
	@Inject
	public UtilisateurDAO(final PersistenceManager persistenceManager, final TaskManager taskManager) {
		super(io.vertigo.demo.domain.administration.utilisateur.Utilisateur.class, persistenceManager, taskManager);
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
	 * Execute la tache TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN.
	 * @param login String 
	 * @param cryptedPassword String 
	 * @return Option de io.vertigo.demo.domain.administration.utilisateur.Utilisateur dtoUtilisateur
	*/
	public Option<io.vertigo.demo.domain.administration.utilisateur.Utilisateur> loadUtilisateurActifByLogin(final String login, final String cryptedPassword) {
		final Task task = createTaskBuilder(Tasks.TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN)
				.withValue(ATTR_IN_TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN_LOGIN, login)
				.withValue(ATTR_IN_TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN_CRYPTED_PASSWORD, cryptedPassword)
				.build();
		final TaskResult taskResult = getTaskManager().execute(task);
		return Option.option(taskResult.<io.vertigo.demo.domain.administration.utilisateur.Utilisateur> getValue(ATTR_OUT_TK_LOAD_UTILISATEUR_ACTIF_BY_LOGIN_DTO_UTILISATEUR));
	}

	/**
	 * Execute la tache TK_LIST_UTILISATEUR_BY_CRITERE.
	 * @param dtoUtilisateurCritere io.vertigo.demo.domain.administration.utilisateur.UtilisateurCritere 
	 * @return io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Utilisateur> dtcUtilisateur
	*/
	public io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Utilisateur> listUtilisateurByCritere(final io.vertigo.demo.domain.administration.utilisateur.UtilisateurCritere dtoUtilisateurCritere) {
		final Task task = createTaskBuilder(Tasks.TK_LIST_UTILISATEUR_BY_CRITERE)
				.withValue(ATTR_IN_TK_LIST_UTILISATEUR_BY_CRITERE_DTO_UTILISATEUR_CRITERE, dtoUtilisateurCritere)
				.build();
		final TaskResult taskResult = getTaskManager().execute(task);
		return taskResult.getValue(ATTR_OUT_TK_LIST_UTILISATEUR_BY_CRITERE_DTC_UTILISATEUR);
	}

	/**
	 * Execute la tache TK_LIST_UTILISATEUR_BY_ROLE.
	 * @param rolCode String 
	 * @return io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Utilisateur> dtcUtilisateur
	*/
	public io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Utilisateur> listUtilisateurByRole(final String rolCode) {
		final Task task = createTaskBuilder(Tasks.TK_LIST_UTILISATEUR_BY_ROLE)
				.withValue(ATTR_IN_TK_LIST_UTILISATEUR_BY_ROLE_ROL_CODE, rolCode)
				.build();
		final TaskResult taskResult = getTaskManager().execute(task);
		return taskResult.getValue(ATTR_OUT_TK_LIST_UTILISATEUR_BY_ROLE_DTC_UTILISATEUR);
	}

}
