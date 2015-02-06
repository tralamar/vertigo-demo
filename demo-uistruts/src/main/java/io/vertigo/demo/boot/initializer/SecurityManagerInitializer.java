package io.vertigo.demo.boot.initializer;

import io.vertigo.core.spaces.component.ComponentInitializer;
import io.vertigo.demo.domain.produit.Produit;
import io.vertigo.persona.impl.security.BeanResourceNameFactory;
import io.vertigo.persona.security.KSecurityManager;

/**
 * Initialisation du manager de Securit�.
 * @author npiedeloup
 * @version $Id: SecurityManagerInitializer.java,v 1.4 2014/07/11 10:54:57 npiedeloup Exp $
 */
public final class SecurityManagerInitializer implements ComponentInitializer<KSecurityManager> {

	/** {@inheritDoc} */
	@Override
	public void init(final KSecurityManager securityManager) {
		securityManager.registerResourceNameFactory(Produit.class.getSimpleName(), new BeanResourceNameFactory("/DATA/Produit/${prdId}/${famId}"));
	}
}
