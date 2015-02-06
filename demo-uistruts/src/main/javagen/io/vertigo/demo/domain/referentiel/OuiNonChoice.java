package io.vertigo.demo.domain.referentiel;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données OuiNonChoice
 */
@DtDefinition(persistent = false)
public final class OuiNonChoice implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Boolean key;
	private String libelle;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'Valeur'. 
	 * @return Boolean key <b>Obligatoire</b>
	 */
	@Field(domain = "DO_OUI_NON", type = "PRIMARY_KEY", notNull = true, persistent = false, label = "Valeur")
	public Boolean getKey() {
		return key;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'Valeur'.
	 * @param key Boolean <b>Obligatoire</b>
	 */
	public void setKey(final Boolean key) {
		this.key = key;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Libellï¿½'. 
	 * @return String libelle <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, persistent = false, label = "Libellï¿½")
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

	//Aucune Association déclarée

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
