package io.vertigo.demo.domain.client;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données AdresseSelection
 */
@DtDefinition(persistent = false)
public final class AdresseSelection implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long regId;
	private Long depId;
	private Long cpoId;
	private io.vertigo.demo.domain.referentiel.Region region;
	private io.vertigo.demo.domain.referentiel.Departement departement;
	private io.vertigo.demo.domain.referentiel.CodePostal codePostal;

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Region'. 
	 * @return Long regId 
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", persistent = false, label = "Region")
	public Long getRegId() {
		return regId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Region'.
	 * @param regId Long 
	 */
	public void setRegId(final Long regId) {
		this.regId = regId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Dï¿½partement'. 
	 * @return Long depId 
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", persistent = false, label = "Dï¿½partement")
	public Long getDepId() {
		return depId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Dï¿½partement'.
	 * @param depId Long 
	 */
	public void setDepId(final Long depId) {
		this.depId = depId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Code postal'. 
	 * @return Long cpoId 
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", persistent = false, label = "Code postal")
	public Long getCpoId() {
		return cpoId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Code postal'.
	 * @param cpoId Long 
	 */
	public void setCpoId(final Long cpoId) {
		this.cpoId = cpoId;
	}

	/**
	 * Association : Region.
	 * @return io.vertigo.demo.domain.referentiel.Region
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_REG_ADR",
    	fkFieldName = "REG_ID",
    	primaryDtDefinitionName = "DT_REGION",
    	primaryIsNavigable = true,
    	primaryRole = "Region",
    	primaryLabel = "Region",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_ADRESSE_SELECTION",
    	foreignIsNavigable = false,
    	foreignRole = "Region",
    	foreignLabel = "Region",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.demo.domain.referentiel.Region getRegion() {
		final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Region> fkURI = getRegionURI();
		if (fkURI == null) {
			return null;
		}
		//On est toujours dans un mode lazy. On s'assure cependant que l'objet associé n'a pas changé
		if (region != null) {
			// On s'assure que l'objet correspond à la bonne clé
			final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Region> uri;
			uri = new io.vertigo.dynamo.domain.model.URI<>(io.vertigo.dynamo.domain.util.DtObjectUtil.findDtDefinition(region), io.vertigo.dynamo.domain.util.DtObjectUtil.getId(region));
			if (!fkURI.toURN().equals(uri.toURN())) {
				region = null;
			}
		}		
		if (region == null) {
			region = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().get(fkURI);
		}
		return region;
	}

	/**
	 * Retourne l'URI: Region.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_REG_ADR",
    	fkFieldName = "REG_ID",
    	primaryDtDefinitionName = "DT_REGION",
    	primaryIsNavigable = true,
    	primaryRole = "Region",
    	primaryLabel = "Region",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_ADRESSE_SELECTION",
    	foreignIsNavigable = false,
    	foreignRole = "Region",
    	foreignLabel = "Region",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Region> getRegionURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_REG_ADR", io.vertigo.demo.domain.referentiel.Region.class);
	}
	/**
	 * Association : Dï¿½partement.
	 * @return io.vertigo.demo.domain.referentiel.Departement
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_DEP_ADR",
    	fkFieldName = "DEP_ID",
    	primaryDtDefinitionName = "DT_DEPARTEMENT",
    	primaryIsNavigable = true,
    	primaryRole = "Departement",
    	primaryLabel = "Dï¿½partement",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_ADRESSE_SELECTION",
    	foreignIsNavigable = false,
    	foreignRole = "Departement",
    	foreignLabel = "Dï¿½partement",
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
	 * Retourne l'URI: Dï¿½partement.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_DEP_ADR",
    	fkFieldName = "DEP_ID",
    	primaryDtDefinitionName = "DT_DEPARTEMENT",
    	primaryIsNavigable = true,
    	primaryRole = "Departement",
    	primaryLabel = "Dï¿½partement",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_ADRESSE_SELECTION",
    	foreignIsNavigable = false,
    	foreignRole = "Departement",
    	foreignLabel = "Dï¿½partement",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Departement> getDepartementURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_DEP_ADR", io.vertigo.demo.domain.referentiel.Departement.class);
	}
	/**
	 * Association : Code postal.
	 * @return io.vertigo.demo.domain.referentiel.CodePostal
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_CPO_ADR",
    	fkFieldName = "CPO_ID",
    	primaryDtDefinitionName = "DT_CODE_POSTAL",
    	primaryIsNavigable = true,
    	primaryRole = "CodePostal",
    	primaryLabel = "Code postal",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_ADRESSE_SELECTION",
    	foreignIsNavigable = false,
    	foreignRole = "CodePostal",
    	foreignLabel = "Code postal",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.demo.domain.referentiel.CodePostal getCodePostal() {
		final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.CodePostal> fkURI = getCodePostalURI();
		if (fkURI == null) {
			return null;
		}
		//On est toujours dans un mode lazy. On s'assure cependant que l'objet associé n'a pas changé
		if (codePostal != null) {
			// On s'assure que l'objet correspond à la bonne clé
			final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.CodePostal> uri;
			uri = new io.vertigo.dynamo.domain.model.URI<>(io.vertigo.dynamo.domain.util.DtObjectUtil.findDtDefinition(codePostal), io.vertigo.dynamo.domain.util.DtObjectUtil.getId(codePostal));
			if (!fkURI.toURN().equals(uri.toURN())) {
				codePostal = null;
			}
		}		
		if (codePostal == null) {
			codePostal = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().get(fkURI);
		}
		return codePostal;
	}

	/**
	 * Retourne l'URI: Code postal.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_CPO_ADR",
    	fkFieldName = "CPO_ID",
    	primaryDtDefinitionName = "DT_CODE_POSTAL",
    	primaryIsNavigable = true,
    	primaryRole = "CodePostal",
    	primaryLabel = "Code postal",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_ADRESSE_SELECTION",
    	foreignIsNavigable = false,
    	foreignRole = "CodePostal",
    	foreignLabel = "Code postal",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.CodePostal> getCodePostalURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_CPO_ADR", io.vertigo.demo.domain.referentiel.CodePostal.class);
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
