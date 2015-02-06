package io.vertigo.demo.domain.referentiel;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données Departement
 */
@DtDefinition
public final class Departement implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long depId;
	private String libelle;
	private Long regId;
	private io.vertigo.demo.domain.referentiel.Region region;
	private io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.referentiel.Ville> ville;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'DEP_ID'. 
	 * @return Long depId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "DEP_ID")
	public Long getDepId() {
		return depId;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'DEP_ID'.
	 * @param depId Long <b>Obligatoire</b>
	 */
	public void setDepId(final Long depId) {
		this.depId = depId;
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
	 * Récupère la valeur de la propriété 'Region'. 
	 * @return Long regId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", notNull = true, label = "Region")
	public Long getRegId() {
		return regId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Region'.
	 * @param regId Long <b>Obligatoire</b>
	 */
	public void setRegId(final Long regId) {
		this.regId = regId;
	}

	/**
	 * Association : Region.
	 * @return io.vertigo.demo.domain.referentiel.Region
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_REG_DEP",
    	fkFieldName = "REG_ID",
    	primaryDtDefinitionName = "DT_REGION",
    	primaryIsNavigable = true,
    	primaryRole = "Region",
    	primaryLabel = "Region",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_DEPARTEMENT",
    	foreignIsNavigable = true,
    	foreignRole = "Departement",
    	foreignLabel = "Departement",
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
    	name = "A_REG_DEP",
    	fkFieldName = "REG_ID",
    	primaryDtDefinitionName = "DT_REGION",
    	primaryIsNavigable = true,
    	primaryRole = "Region",
    	primaryLabel = "Region",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_DEPARTEMENT",
    	foreignIsNavigable = true,
    	foreignRole = "Departement",
    	foreignLabel = "Departement",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Region> getRegionURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_REG_DEP", io.vertigo.demo.domain.referentiel.Region.class);
	}
	/**
	 * Association : Ville.
	 * @return io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.referentiel.Ville>
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
	public io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.referentiel.Ville> getVilleList() {
//		return this.<io.vertigo.demo.domain.referentiel.Ville> getList(getVilleListURI());
		// On doit avoir une clé primaire renseignée. Si ce n'est pas le cas, on renvoie une liste vide
		if (io.vertigo.dynamo.domain.util.DtObjectUtil.getId(this) == null) {
			return new io.vertigo.dynamo.domain.model.DtList<>(io.vertigo.demo.domain.referentiel.Ville.class);
		}
		final io.vertigo.dynamo.domain.metamodel.association.DtListURIForAssociation fkDtListURI = getVilleDtListURI();
		io.vertigo.lang.Assertion.checkNotNull(fkDtListURI);
		//---------------------------------------------------------------------
		//On est toujours dans un mode lazy.
		if (ville == null) {
			ville = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().getList(fkDtListURI);
		}
		return ville;
	}

	/**
	 * Association URI: Ville.
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
	public io.vertigo.dynamo.domain.metamodel.association.DtListURIForAssociation getVilleDtListURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createDtListURI(this, "A_DEP_VIL", "Ville");
	}

	// Association : Dï¿½partement non navigable

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
