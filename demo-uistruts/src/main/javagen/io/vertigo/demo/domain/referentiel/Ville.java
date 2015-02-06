package io.vertigo.demo.domain.referentiel;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données Ville
 */
@DtDefinition
public final class Ville implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long vilId;
	private String libelle;
	private Long depId;
	private io.vertigo.demo.domain.referentiel.Departement departement;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'VIL_ID'. 
	 * @return Long vilId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "VIL_ID")
	public Long getVilId() {
		return vilId;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'VIL_ID'.
	 * @param vilId Long <b>Obligatoire</b>
	 */
	public void setVilId(final Long vilId) {
		this.vilId = vilId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'LIBELLE'. 
	 * @return String libelle <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, label = "LIBELLE")
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'LIBELLE'.
	 * @param libelle String <b>Obligatoire</b>
	 */
	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Departement'. 
	 * @return Long depId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", notNull = true, label = "Departement")
	public Long getDepId() {
		return depId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Departement'.
	 * @param depId Long <b>Obligatoire</b>
	 */
	public void setDepId(final Long depId) {
		this.depId = depId;
	}

	/**
	 * Association : Departement.
	 * @return io.vertigo.demo.domain.referentiel.Departement
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_DEP_VIL",
    	fkFieldName = "DEP_ID",
    	primaryDtDefinitionName = "DT_DEPARTEMENT",
    	primaryIsNavigable = true,
    	primaryRole = "Departement",
    	primaryLabel = "Departement",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_VILLE",
    	foreignIsNavigable = true,
    	foreignRole = "Ville",
    	foreignLabel = "Ville",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.demo.domain.referentiel.Departement getDepartement() {
		final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Departement> fkURI = getDepartementURI();
		if (fkURI == null) {
			return null;
		}
		//On est toujours dans un mode lazy. On s'assure cependant que l'objet associé n'a pas changé
		if (departement != null) {
			// On s'assure que l'objet correspond à la bonne clé
			final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Departement> uri;
			uri = new io.vertigo.dynamo.domain.model.URI<>(io.vertigo.dynamo.domain.util.DtObjectUtil.findDtDefinition(departement), io.vertigo.dynamo.domain.util.DtObjectUtil.getId(departement));
			if (!fkURI.toURN().equals(uri.toURN())) {
				departement = null;
			}
		}		
		if (departement == null) {
			departement = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().get(fkURI);
		}
		return departement;
	}

	/**
	 * Retourne l'URI: Departement.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_DEP_VIL",
    	fkFieldName = "DEP_ID",
    	primaryDtDefinitionName = "DT_DEPARTEMENT",
    	primaryIsNavigable = true,
    	primaryRole = "Departement",
    	primaryLabel = "Departement",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_VILLE",
    	foreignIsNavigable = true,
    	foreignRole = "Ville",
    	foreignLabel = "Ville",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Departement> getDepartementURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_DEP_VIL", io.vertigo.demo.domain.referentiel.Departement.class);
	}

	// Association : CodePostal non navigable

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
