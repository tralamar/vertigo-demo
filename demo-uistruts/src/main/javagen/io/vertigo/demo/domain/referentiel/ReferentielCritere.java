package io.vertigo.demo.domain.referentiel;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données ReferentielCritere
 */
@DtDefinition(persistent = false)
public final class ReferentielCritere implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String referentielName;

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Rï¿½fï¿½rentiel'. 
	 * @return String referentielName <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, persistent = false, label = "Rï¿½fï¿½rentiel")
	public String getReferentielName() {
		return referentielName;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Rï¿½fï¿½rentiel'.
	 * @param referentielName String <b>Obligatoire</b>
	 */
	public void setReferentielName(final String referentielName) {
		this.referentielName = referentielName;
	}

	//Aucune Association déclarée

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
