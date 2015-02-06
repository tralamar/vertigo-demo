package io.vertigo.demo.domain.administration.utilisateur;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données Utilisateur
 */
@DtDefinition
public final class Utilisateur implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long utiId;
	private String nom;
	private String prenom;
	private String mail;
	private String telephone;
	private String fax;
	private Boolean siActif;
	private java.util.Date dateCreation;
	private java.util.Date dateDerniereModif;
	private String auteurDerniereModif;
	private io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Login> login;
	private io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Role> role;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'UTI_ID'. 
	 * @return Long utiId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "UTI_ID")
	public Long getUtiId() {
		return utiId;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'UTI_ID'.
	 * @param utiId Long <b>Obligatoire</b>
	 */
	public void setUtiId(final Long utiId) {
		this.utiId = utiId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Nom'. 
	 * @return String nom <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, label = "Nom")
	public String getNom() {
		return nom;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Nom'.
	 * @param nom String <b>Obligatoire</b>
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Prénom'. 
	 * @return String prenom <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, label = "Prénom")
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Prénom'.
	 * @param prenom String <b>Obligatoire</b>
	 */
	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Courriel'. 
	 * @return String mail <b>Obligatoire</b>
	 */
	@Field(domain = "DO_EMAIL", notNull = true, label = "Courriel")
	public String getMail() {
		return mail;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Courriel'.
	 * @param mail String <b>Obligatoire</b>
	 */
	public void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Téléphone'. 
	 * @return String telephone 
	 */
	@Field(domain = "DO_TELEPHONE", label = "Téléphone")
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Téléphone'.
	 * @param telephone String 
	 */
	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Fax'. 
	 * @return String fax 
	 */
	@Field(domain = "DO_TELEPHONE", label = "Fax")
	public String getFax() {
		return fax;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Fax'.
	 * @param fax String 
	 */
	public void setFax(final String fax) {
		this.fax = fax;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Si actif'. 
	 * @return Boolean siActif <b>Obligatoire</b>
	 */
	@Field(domain = "DO_ACTIF", notNull = true, label = "Si actif")
	public Boolean getSiActif() {
		return siActif;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Si actif'.
	 * @param siActif Boolean <b>Obligatoire</b>
	 */
	public void setSiActif(final Boolean siActif) {
		this.siActif = siActif;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Date de création'. 
	 * @return java.util.Date dateCreation <b>Obligatoire</b>
	 */
	@Field(domain = "DO_DATE", notNull = true, label = "Date de création")
	public java.util.Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Date de création'.
	 * @param dateCreation java.util.Date <b>Obligatoire</b>
	 */
	public void setDateCreation(final java.util.Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Date de dernière modification'. 
	 * @return java.util.Date dateDerniereModif 
	 */
	@Field(domain = "DO_DATE", label = "Date de dernière modification")
	public java.util.Date getDateDerniereModif() {
		return dateDerniereModif;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Date de dernière modification'.
	 * @param dateDerniereModif java.util.Date 
	 */
	public void setDateDerniereModif(final java.util.Date dateDerniereModif) {
		this.dateDerniereModif = dateDerniereModif;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Auteur de dernière modification'. 
	 * @return String auteurDerniereModif <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE_LONG", notNull = true, label = "Auteur de dernière modification")
	public String getAuteurDerniereModif() {
		return auteurDerniereModif;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Auteur de dernière modification'.
	 * @param auteurDerniereModif String <b>Obligatoire</b>
	 */
	public void setAuteurDerniereModif(final String auteurDerniereModif) {
		this.auteurDerniereModif = auteurDerniereModif;
	}

	/**
	 * Champ : COMPUTED.
	 * Récupère la valeur de la propriété calculée 'PrÃ©nom Nom'. 
	 * @return String prenomNom 
	 */
	@Field(domain = "DO_LIBELLE_LONG", type = "COMPUTED", persistent = false, label = "PrÃ©nom Nom")
	public String getPrenomNom() {
		final StringBuilder builder = new StringBuilder();
		if (getPrenom() != null) {
			builder.append(getPrenom());
			builder.append(' ');
		}
		builder.append(getNom());
		return builder.toString();
	}

	/**
	 * Association : Login.
	 * @return io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Login>
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_UTI_LOG",
    	fkFieldName = "UTI_ID",
    	primaryDtDefinitionName = "DT_UTILISATEUR",
    	primaryIsNavigable = false,
    	primaryRole = "Utilisateur",
    	primaryLabel = "Utilisateur",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_LOGIN",
    	foreignIsNavigable = true,
    	foreignRole = "Login",
    	foreignLabel = "Login",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Login> getLoginList() {
//		return this.<io.vertigo.demo.domain.administration.utilisateur.Login> getList(getLoginListURI());
		// On doit avoir une clé primaire renseignée. Si ce n'est pas le cas, on renvoie une liste vide
		if (io.vertigo.dynamo.domain.util.DtObjectUtil.getId(this) == null) {
			return new io.vertigo.dynamo.domain.model.DtList<>(io.vertigo.demo.domain.administration.utilisateur.Login.class);
		}
		final io.vertigo.dynamo.domain.metamodel.association.DtListURIForAssociation fkDtListURI = getLoginDtListURI();
		io.vertigo.lang.Assertion.checkNotNull(fkDtListURI);
		//---------------------------------------------------------------------
		//On est toujours dans un mode lazy.
		if (login == null) {
			login = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().getList(fkDtListURI);
		}
		return login;
	}

	/**
	 * Association URI: Login.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_UTI_LOG",
    	fkFieldName = "UTI_ID",
    	primaryDtDefinitionName = "DT_UTILISATEUR",
    	primaryIsNavigable = false,
    	primaryRole = "Utilisateur",
    	primaryLabel = "Utilisateur",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_LOGIN",
    	foreignIsNavigable = true,
    	foreignRole = "Login",
    	foreignLabel = "Login",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.metamodel.association.DtListURIForAssociation getLoginDtListURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createDtListURI(this, "A_UTI_LOG", "Login");
	}
	/**
	 * Association : Rôle.
	 * @return io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Role>
	 */
    @io.vertigo.dynamo.domain.stereotype.AssociationNN (
    	name = "A_UTI_ROL",
    	tableName = "UTI_ROL",
    	dtDefinitionA = "DT_UTILISATEUR",
    	dtDefinitionB = "DT_ROLE",
    	navigabilityA = false,
    	navigabilityB = true,
    	roleA = "Utilisateur",
    	roleB = "Role",
    	labelA = "Utilisateur",
    	labelB = "Rôle"
    )
	public io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.administration.utilisateur.Role> getRoleList() {
//		return this.<io.vertigo.demo.domain.administration.utilisateur.Role> getList(getRoleListURI());
		// On doit avoir une clé primaire renseignée. Si ce n'est pas le cas, on renvoie une liste vide
		if (io.vertigo.dynamo.domain.util.DtObjectUtil.getId(this) == null) {
			return new io.vertigo.dynamo.domain.model.DtList<>(io.vertigo.demo.domain.administration.utilisateur.Role.class);
		}
		final io.vertigo.dynamo.domain.metamodel.association.DtListURIForAssociation fkDtListURI = getRoleDtListURI();
		io.vertigo.lang.Assertion.checkNotNull(fkDtListURI);
		//---------------------------------------------------------------------
		//On est toujours dans un mode lazy.
		if (role == null) {
			role = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().getList(fkDtListURI);
		}
		return role;
	}

	/**
	 * Association URI: Rôle.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.AssociationNN (
    	name = "A_UTI_ROL",
    	tableName = "UTI_ROL",
    	dtDefinitionA = "DT_UTILISATEUR",
    	dtDefinitionB = "DT_ROLE",
    	navigabilityA = false,
    	navigabilityB = true,
    	roleA = "Utilisateur",
    	roleB = "Role",
    	labelA = "Utilisateur",
    	labelB = "Rôle"
    )
	public io.vertigo.dynamo.domain.metamodel.association.DtListURIForAssociation getRoleDtListURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createDtListURI(this, "A_UTI_ROL", "Role");
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
