package io.vertigo.demo.ui.controller.produit;

import io.vertigo.demo.domain.produit.Produit;
import io.vertigo.demo.domain.referentiel.Famille;
import io.vertigo.demo.services.produit.ProduitServices;
import io.vertigo.demo.ui.controller.AbstractDemoActionSupport;
import io.vertigo.lang.Option;
import io.vertigo.struts2.core.ContextForm;
import io.vertigo.struts2.core.ContextMdl;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author npiedeloup
 * @version $Id: ProduitDetailAction.java,v 1.4 2014/06/27 12:21:39 pchretien Exp $
 */
public final class ProduitDetailAction extends AbstractDemoActionSupport {

	private static final long serialVersionUID = -4230604077944183713L;

	@Inject
	private ProduitServices produitServices;

	private final ContextForm<Produit> produit = new ContextForm<>("produit", this);
	private final ContextMdl<Famille> familles = new ContextMdl<>("familles", this);

	/**
	 * @param prdId Id de l'élément a afficher.
	 */
	public void initContext(@Named("prdId") final Option<Long> prdId) {
		if (prdId.isDefined()) {
			produit.publish(produitServices.loadProduit(prdId.get()));
		} else {
			produit.publish(new Produit());
			toModeCreate();
		}
		familles.publish(Famille.class, null);
	}

	public String doEdit() {
		toModeEdit();
		return NONE;
	}

	public String doSave() {
		produitServices.saveProduit(produit.readDto());
		return SUCCESS;
	}

	public String doDelete(@Named("prdId") final Long prdId) {
		produitServices.deleteProduit(prdId);
		return "success_delete";
	}

	/** {@inheritDoc} */
	@Override
	public String getPageName() {
		return "Detail produit";
	}
}
