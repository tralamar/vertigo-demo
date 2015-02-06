package io.vertigo.demo.domain.tutorial;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données TutoObjectEtat
 */
@DtDefinition
public final class TutoObjectEtat implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long etaId;
	private String etat;
	private String libelle;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'ID etat'. 
	 * @return Long etaId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "ID etat")
	public Long getEtaId() {
		return etaId;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'ID etat'.
	 * @param etaId Long <b>Obligatoire</b>
	 */
	public void setEtaId(final Long etaId) {
		this.etaId = etaId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Code Etat'. 
	 * @return String etat <b>Obligatoire</b>
	 */
	@Field(domain = "DO_CODE", notNull = true, label = "Code Etat")
	public String getEtat() {
		return etat;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Code Etat'.
	 * @param etat String <b>Obligatoire</b>
	 */
	public void setEtat(final String etat) {
		this.etat = etat;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Libellï¿½'. 
	 * @return String libelle <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, label = "Libellï¿½")
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Libellï¿½'.
	 * @param libelle String <b>Obligatoire</b>
	 */
	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}


	// Association : objet non navigable

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
