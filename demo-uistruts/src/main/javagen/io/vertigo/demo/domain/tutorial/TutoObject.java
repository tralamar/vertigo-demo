package io.vertigo.demo.domain.tutorial;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données TutoObject
 */
@DtDefinition
public final class TutoObject implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long objId;
	private String code;
	private String libelle;
	private String description;
	private java.math.BigDecimal prix;
	private Boolean siStock;
	private java.math.BigDecimal poids;
	private java.util.Date dateCreation;
	private java.util.Date dateModification;
	private Long typId;
	private Long etaId;
	private io.vertigo.demo.domain.tutorial.TutoObjectType type;
	private io.vertigo.demo.domain.tutorial.TutoObjectEtat etat;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'ID Objet'. 
	 * @return Long objId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "ID Objet")
	public Long getObjId() {
		return objId;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'ID Objet'.
	 * @param objId Long <b>Obligatoire</b>
	 */
	public void setObjId(final Long objId) {
		this.objId = objId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Code produit'. 
	 * @return String code <b>Obligatoire</b>
	 */
	@Field(domain = "DO_CODE", notNull = true, label = "Code produit")
	public String getCode() {
		return code;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Code produit'.
	 * @param code String <b>Obligatoire</b>
	 */
	public void setCode(final String code) {
		this.code = code;
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

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Description'. 
	 * @return String description 
	 */
	@Field(domain = "DO_TEXTE", label = "Description")
	public String getDescription() {
		return description;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Description'.
	 * @param description String 
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Prix unitaire'. 
	 * @return java.math.BigDecimal prix 
	 */
	@Field(domain = "DO_MONTANT", label = "Prix unitaire")
	public java.math.BigDecimal getPrix() {
		return prix;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Prix unitaire'.
	 * @param prix java.math.BigDecimal 
	 */
	public void setPrix(final java.math.BigDecimal prix) {
		this.prix = prix;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'En stock'. 
	 * @return Boolean siStock <b>Obligatoire</b>
	 */
	@Field(domain = "DO_OUI_NON", notNull = true, label = "En stock")
	public Boolean getSiStock() {
		return siStock;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'En stock'.
	 * @param siStock Boolean <b>Obligatoire</b>
	 */
	public void setSiStock(final Boolean siStock) {
		this.siStock = siStock;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Poids unitaire'. 
	 * @return java.math.BigDecimal poids <b>Obligatoire</b>
	 */
	@Field(domain = "DO_POIDS", notNull = true, label = "Poids unitaire")
	public java.math.BigDecimal getPoids() {
		return poids;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Poids unitaire'.
	 * @param poids java.math.BigDecimal <b>Obligatoire</b>
	 */
	public void setPoids(final java.math.BigDecimal poids) {
		this.poids = poids;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Date de crï¿½ation'. 
	 * @return java.util.Date dateCreation <b>Obligatoire</b>
	 */
	@Field(domain = "DO_DATE", notNull = true, label = "Date de crï¿½ation")
	public java.util.Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Date de crï¿½ation'.
	 * @param dateCreation java.util.Date <b>Obligatoire</b>
	 */
	public void setDateCreation(final java.util.Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Date de modification'. 
	 * @return java.util.Date dateModification 
	 */
	@Field(domain = "DO_DATE", label = "Date de modification")
	public java.util.Date getDateModification() {
		return dateModification;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Date de modification'.
	 * @param dateModification java.util.Date 
	 */
	public void setDateModification(final java.util.Date dateModification) {
		this.dateModification = dateModification;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'type'. 
	 * @return Long typId 
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", label = "type")
	public Long getTypId() {
		return typId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'type'.
	 * @param typId Long 
	 */
	public void setTypId(final Long typId) {
		this.typId = typId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'etat'. 
	 * @return Long etaId 
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", label = "etat")
	public Long getEtaId() {
		return etaId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'etat'.
	 * @param etaId Long 
	 */
	public void setEtaId(final Long etaId) {
		this.etaId = etaId;
	}

	/**
	 * Association : type.
	 * @return io.vertigo.demo.domain.tutorial.TutoObjectType
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_OBJ_TYP",
    	fkFieldName = "TYP_ID",
    	primaryDtDefinitionName = "DT_TUTO_OBJECT_TYPE",
    	primaryIsNavigable = true,
    	primaryRole = "type",
    	primaryLabel = "type",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_TUTO_OBJECT",
    	foreignIsNavigable = false,
    	foreignRole = "objet",
    	foreignLabel = "objet",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.demo.domain.tutorial.TutoObjectType getType() {
		final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.tutorial.TutoObjectType> fkURI = getTypeURI();
		if (fkURI == null) {
			return null;
		}
		//On est toujours dans un mode lazy. On s'assure cependant que l'objet associé n'a pas changé
		if (type != null) {
			// On s'assure que l'objet correspond à la bonne clé
			final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.tutorial.TutoObjectType> uri;
			uri = new io.vertigo.dynamo.domain.model.URI<>(io.vertigo.dynamo.domain.util.DtObjectUtil.findDtDefinition(type), io.vertigo.dynamo.domain.util.DtObjectUtil.getId(type));
			if (!fkURI.toURN().equals(uri.toURN())) {
				type = null;
			}
		}		
		if (type == null) {
			type = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().get(fkURI);
		}
		return type;
	}

	/**
	 * Retourne l'URI: type.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_OBJ_TYP",
    	fkFieldName = "TYP_ID",
    	primaryDtDefinitionName = "DT_TUTO_OBJECT_TYPE",
    	primaryIsNavigable = true,
    	primaryRole = "type",
    	primaryLabel = "type",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_TUTO_OBJECT",
    	foreignIsNavigable = false,
    	foreignRole = "objet",
    	foreignLabel = "objet",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.tutorial.TutoObjectType> getTypeURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_OBJ_TYP", io.vertigo.demo.domain.tutorial.TutoObjectType.class);
	}
	/**
	 * Association : etat.
	 * @return io.vertigo.demo.domain.tutorial.TutoObjectEtat
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_OBJ_ETA",
    	fkFieldName = "ETA_ID",
    	primaryDtDefinitionName = "DT_TUTO_OBJECT_ETAT",
    	primaryIsNavigable = true,
    	primaryRole = "etat",
    	primaryLabel = "etat",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_TUTO_OBJECT",
    	foreignIsNavigable = false,
    	foreignRole = "objet",
    	foreignLabel = "objet",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.demo.domain.tutorial.TutoObjectEtat getEtat() {
		final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.tutorial.TutoObjectEtat> fkURI = getEtatURI();
		if (fkURI == null) {
			return null;
		}
		//On est toujours dans un mode lazy. On s'assure cependant que l'objet associé n'a pas changé
		if (etat != null) {
			// On s'assure que l'objet correspond à la bonne clé
			final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.tutorial.TutoObjectEtat> uri;
			uri = new io.vertigo.dynamo.domain.model.URI<>(io.vertigo.dynamo.domain.util.DtObjectUtil.findDtDefinition(etat), io.vertigo.dynamo.domain.util.DtObjectUtil.getId(etat));
			if (!fkURI.toURN().equals(uri.toURN())) {
				etat = null;
			}
		}		
		if (etat == null) {
			etat = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().get(fkURI);
		}
		return etat;
	}

	/**
	 * Retourne l'URI: etat.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_OBJ_ETA",
    	fkFieldName = "ETA_ID",
    	primaryDtDefinitionName = "DT_TUTO_OBJECT_ETAT",
    	primaryIsNavigable = true,
    	primaryRole = "etat",
    	primaryLabel = "etat",
    	primaryMultiplicity = "0..1",
    	foreignDtDefinitionName = "DT_TUTO_OBJECT",
    	foreignIsNavigable = false,
    	foreignRole = "objet",
    	foreignLabel = "objet",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.tutorial.TutoObjectEtat> getEtatURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_OBJ_ETA", io.vertigo.demo.domain.tutorial.TutoObjectEtat.class);
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
