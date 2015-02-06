package io.vertigo.demo.domain.tutorial;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données Commune
 */
@DtDefinition
public final class Commune implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long idInsee;
	private String codePostal;
	private String commune;
	private String departement;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'ID INSEE'. 
	 * @return Long idInsee <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "ID INSEE")
	public Long getIdInsee() {
		return idInsee;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'ID INSEE'.
	 * @param idInsee Long <b>Obligatoire</b>
	 */
	public void setIdInsee(final Long idInsee) {
		this.idInsee = idInsee;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Code postal'. 
	 * @return String codePostal <b>Obligatoire</b>
	 */
	@Field(domain = "DO_CODE_POSTAL", notNull = true, label = "Code postal")
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Code postal'.
	 * @param codePostal String <b>Obligatoire</b>
	 */
	public void setCodePostal(final String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Commune'. 
	 * @return String commune <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, label = "Commune")
	public String getCommune() {
		return commune;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Commune'.
	 * @param commune String <b>Obligatoire</b>
	 */
	public void setCommune(final String commune) {
		this.commune = commune;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Dï¿½partement'. 
	 * @return String departement <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, label = "Dï¿½partement")
	public String getDepartement() {
		return departement;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Dï¿½partement'.
	 * @param departement String <b>Obligatoire</b>
	 */
	public void setDepartement(final String departement) {
		this.departement = departement;
	}

	//Aucune Association déclarée

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
