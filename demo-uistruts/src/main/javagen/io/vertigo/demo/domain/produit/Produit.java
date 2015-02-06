package io.vertigo.demo.domain.produit;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données Produit
 */
@DtDefinition
public final class Produit implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long prdId;
	private String code;
	private String libelle;
	private String description;
	private java.math.BigDecimal prix;
	private Boolean siStock;
	private java.math.BigDecimal poids;
	private String commentaire;
	private Long famId;
	private io.vertigo.demo.domain.referentiel.Famille famille;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'identifiant'. 
	 * @return Long prdId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "identifiant")
	public Long getPrdId() {
		return prdId;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'identifiant'.
	 * @param prdId Long <b>Obligatoire</b>
	 */
	public void setPrdId(final Long prdId) {
		this.prdId = prdId;
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
	 * Récupère la valeur de la propriété 'libellé'. 
	 * @return String libelle 
	 */
	@Field(domain = "DO_LIBELLE_COURT", label = "libellé")
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'libellé'.
	 * @param libelle String 
	 */
	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'description'. 
	 * @return String description 
	 */
	@Field(domain = "DO_TEXTE", label = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'description'.
	 * @param description String 
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'prix unitaire'. 
	 * @return java.math.BigDecimal prix 
	 */
	@Field(domain = "DO_MONTANT", label = "prix unitaire")
	public java.math.BigDecimal getPrix() {
		return prix;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'prix unitaire'.
	 * @param prix java.math.BigDecimal 
	 */
	public void setPrix(final java.math.BigDecimal prix) {
		this.prix = prix;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'en stock'. 
	 * @return Boolean siStock 
	 */
	@Field(domain = "DO_OUI_NON", label = "en stock")
	public Boolean getSiStock() {
		return siStock;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'en stock'.
	 * @param siStock Boolean 
	 */
	public void setSiStock(final Boolean siStock) {
		this.siStock = siStock;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'poids unitaire'. 
	 * @return java.math.BigDecimal poids 
	 */
	@Field(domain = "DO_POIDS", label = "poids unitaire")
	public java.math.BigDecimal getPoids() {
		return poids;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'poids unitaire'.
	 * @param poids java.math.BigDecimal 
	 */
	public void setPoids(final java.math.BigDecimal poids) {
		this.poids = poids;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'commentaire'. 
	 * @return String commentaire 
	 */
	@Field(domain = "DO_TEXTE", label = "commentaire")
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'commentaire'.
	 * @param commentaire String 
	 */
	public void setCommentaire(final String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Famille'. 
	 * @return Long famId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", notNull = true, label = "Famille")
	public Long getFamId() {
		return famId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Famille'.
	 * @param famId Long <b>Obligatoire</b>
	 */
	public void setFamId(final Long famId) {
		this.famId = famId;
	}


	// Association : LigneCommande non navigable
	/**
	 * Association : Famille.
	 * @return io.vertigo.demo.domain.referentiel.Famille
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_PRD_FAM",
    	fkFieldName = "FAM_ID",
    	primaryDtDefinitionName = "DT_FAMILLE",
    	primaryIsNavigable = true,
    	primaryRole = "Famille",
    	primaryLabel = "Famille",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_PRODUIT",
    	foreignIsNavigable = false,
    	foreignRole = "Produit",
    	foreignLabel = "Produit",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.demo.domain.referentiel.Famille getFamille() {
		final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Famille> fkURI = getFamilleURI();
		if (fkURI == null) {
			return null;
		}
		//On est toujours dans un mode lazy. On s'assure cependant que l'objet associé n'a pas changé
		if (famille != null) {
			// On s'assure que l'objet correspond à la bonne clé
			final io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Famille> uri;
			uri = new io.vertigo.dynamo.domain.model.URI<>(io.vertigo.dynamo.domain.util.DtObjectUtil.findDtDefinition(famille), io.vertigo.dynamo.domain.util.DtObjectUtil.getId(famille));
			if (!fkURI.toURN().equals(uri.toURN())) {
				famille = null;
			}
		}		
		if (famille == null) {
			famille = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().get(fkURI);
		}
		return famille;
	}

	/**
	 * Retourne l'URI: Famille.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_PRD_FAM",
    	fkFieldName = "FAM_ID",
    	primaryDtDefinitionName = "DT_FAMILLE",
    	primaryIsNavigable = true,
    	primaryRole = "Famille",
    	primaryLabel = "Famille",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_PRODUIT",
    	foreignIsNavigable = false,
    	foreignRole = "Produit",
    	foreignLabel = "Produit",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.Famille> getFamilleURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_PRD_FAM", io.vertigo.demo.domain.referentiel.Famille.class);
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
