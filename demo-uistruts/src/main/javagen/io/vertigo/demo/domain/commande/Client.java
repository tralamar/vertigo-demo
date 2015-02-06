package io.vertigo.demo.domain.commande;

import io.vertigo.dynamo.domain.stereotype.DtDefinition;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données Client
 */
@DtDefinition
public final class Client implements DtObject {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long cliId;
	private String nom;
	private String prenom;
	private String address;
	private Long cpoId;
	private io.vertigo.demo.domain.referentiel.CodePostal codePostal;
	private io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.commande.Commande> commande;

	/**
	 * Champ : PRIMARY_KEY.
	 * Récupère la valeur de la propriété 'CLI ID'. 
	 * @return Long cliId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "PRIMARY_KEY", notNull = true, label = "CLI ID")
	public Long getCliId() {
		return cliId;
	}

	/**
	 * Champ : PRIMARY_KEY.
	 * Définit la valeur de la propriété 'CLI ID'.
	 * @param cliId Long <b>Obligatoire</b>
	 */
	public void setCliId(final Long cliId) {
		this.cliId = cliId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'NOM'. 
	 * @return String nom <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, label = "NOM")
	public String getNom() {
		return nom;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'NOM'.
	 * @param nom String <b>Obligatoire</b>
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'PRENOM'. 
	 * @return String prenom <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", notNull = true, label = "PRENOM")
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'PRENOM'.
	 * @param prenom String <b>Obligatoire</b>
	 */
	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'ADDRESS'. 
	 * @return String address <b>Obligatoire</b>
	 */
	@Field(domain = "DO_TEXTE", notNull = true, label = "ADDRESS")
	public String getAddress() {
		return address;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'ADDRESS'.
	 * @param address String <b>Obligatoire</b>
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'CodePostal'. 
	 * @return Long cpoId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "FOREIGN_KEY", notNull = true, label = "CodePostal")
	public Long getCpoId() {
		return cpoId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'CodePostal'.
	 * @param cpoId Long <b>Obligatoire</b>
	 */
	public void setCpoId(final Long cpoId) {
		this.cpoId = cpoId;
	}

	/**
	 * Association : CodePostal.
	 * @return io.vertigo.demo.domain.referentiel.CodePostal
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_CLI_CPO",
    	fkFieldName = "CPO_ID",
    	primaryDtDefinitionName = "DT_CODE_POSTAL",
    	primaryIsNavigable = true,
    	primaryRole = "CodePostal",
    	primaryLabel = "CodePostal",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_CLIENT",
    	foreignIsNavigable = false,
    	foreignRole = "Client",
    	foreignLabel = "Client",
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
	 * Retourne l'URI: CodePostal.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_CLI_CPO",
    	fkFieldName = "CPO_ID",
    	primaryDtDefinitionName = "DT_CODE_POSTAL",
    	primaryIsNavigable = true,
    	primaryRole = "CodePostal",
    	primaryLabel = "CodePostal",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_CLIENT",
    	foreignIsNavigable = false,
    	foreignRole = "Client",
    	foreignLabel = "Client",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.URI<io.vertigo.demo.domain.referentiel.CodePostal> getCodePostalURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createURI(this, "A_CLI_CPO", io.vertigo.demo.domain.referentiel.CodePostal.class);
	}
	/**
	 * Association : Commande.
	 * @return io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.commande.Commande>
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_CLI_COM",
    	fkFieldName = "CLI_ID",
    	primaryDtDefinitionName = "DT_CLIENT",
    	primaryIsNavigable = false,
    	primaryRole = "Client",
    	primaryLabel = "Client",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_COMMANDE",
    	foreignIsNavigable = true,
    	foreignRole = "Commande",
    	foreignLabel = "Commande",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.commande.Commande> getCommandeList() {
//		return this.<io.vertigo.demo.domain.commande.Commande> getList(getCommandeListURI());
		// On doit avoir une clé primaire renseignée. Si ce n'est pas le cas, on renvoie une liste vide
		if (io.vertigo.dynamo.domain.util.DtObjectUtil.getId(this) == null) {
			return new io.vertigo.dynamo.domain.model.DtList<>(io.vertigo.demo.domain.commande.Commande.class);
		}
		final io.vertigo.dynamo.domain.metamodel.association.DtListURIForAssociation fkDtListURI = getCommandeDtListURI();
		io.vertigo.lang.Assertion.checkNotNull(fkDtListURI);
		//---------------------------------------------------------------------
		//On est toujours dans un mode lazy.
		if (commande == null) {
			commande = io.vertigo.core.Home.getComponentSpace().resolve(io.vertigo.dynamo.persistence.PersistenceManager.class).getBroker().getList(fkDtListURI);
		}
		return commande;
	}

	/**
	 * Association URI: Commande.
	 * @return URI de l'association
	 */
    @io.vertigo.dynamo.domain.stereotype.Association (
    	name = "A_CLI_COM",
    	fkFieldName = "CLI_ID",
    	primaryDtDefinitionName = "DT_CLIENT",
    	primaryIsNavigable = false,
    	primaryRole = "Client",
    	primaryLabel = "Client",
    	primaryMultiplicity = "1..1",
    	foreignDtDefinitionName = "DT_COMMANDE",
    	foreignIsNavigable = true,
    	foreignRole = "Commande",
    	foreignLabel = "Commande",
    	foreignMultiplicity = "0..*"
    )
	public io.vertigo.dynamo.domain.metamodel.association.DtListURIForAssociation getCommandeDtListURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createDtListURI(this, "A_CLI_COM", "Commande");
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
