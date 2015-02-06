package io.vertigo.demo.domain.administration.utilisateur;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données UtilisateurCritere
 */
@DtDefinition(persistent = false)
public final class UtilisateurCritere implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String nom;
	private String login;
	private String role;
	private Boolean isActif;

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Nom'. 
	 * @return String nom 
	 */
	@Field(domain = "DO_LIBELLE", persistent = false, label = "Nom")
	public String getNom() {
		return nom;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Nom'.
	 * @param nom String 
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Indentifiant'. 
	 * @return String login 
	 */
	@Field(domain = "DO_LOGIN", persistent = false, label = "Indentifiant")
	public String getLogin() {
		return login;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Indentifiant'.
	 * @param login String 
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'RÃ´le'. 
	 * @return String role 
	 */
	@Field(domain = "DO_LIBELLE", persistent = false, label = "RÃ´le")
	public String getRole() {
		return role;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'RÃ´le'.
	 * @param role String 
	 */
	public void setRole(final String role) {
		this.role = role;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Seulement les utilisateurs actifs'. 
	 * @return Boolean isActif 
	 */
	@Field(domain = "DO_ACTIF", persistent = false, label = "Seulement les utilisateurs actifs")
	public Boolean getIsActif() {
		return isActif;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Seulement les utilisateurs actifs'.
	 * @param isActif Boolean 
	 */
	public void setIsActif(final Boolean isActif) {
		this.isActif = isActif;
	}

	//Aucune Association déclarée

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
