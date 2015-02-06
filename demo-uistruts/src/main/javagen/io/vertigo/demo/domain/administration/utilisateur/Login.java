package io.vertigo.demo.domain.administration.utilisateur;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données Login
 */
@DtDefinition
public final class Login implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long logId;
	private String login;
	private String password;
	private Long utiId;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'LOG ID'. 
	 * @return Long logId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "LOG ID")
	public Long getLogId() {
		return logId;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'LOG ID'.
	 * @param logId Long <b>Obligatoire</b>
	 */
	public void setLogId(final Long logId) {
		this.logId = logId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Login'. 
	 * @return String login <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LOGIN", notNull = true, label = "Login")
	public String getLogin() {
		return login;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Login'.
	 * @param login String <b>Obligatoire</b>
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Mot de passe'. 
	 * @return String password <b>Obligatoire</b>
	 */
	@Field(domain = "DO_PASSWORD", notNull = true, label = "Mot de passe")
	public String getPassword() {
		return password;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Mot de passe'.
	 * @param password String <b>Obligatoire</b>
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Utilisateur'. 
	 * @return Long utiId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", notNull = true, label = "Utilisateur")
	public Long getUtiId() {
		return utiId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Utilisateur'.
	 * @param utiId Long <b>Obligatoire</b>
	 */
	public void setUtiId(final Long utiId) {
		this.utiId = utiId;
	}


	// Association : Utilisateur non navigable

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
