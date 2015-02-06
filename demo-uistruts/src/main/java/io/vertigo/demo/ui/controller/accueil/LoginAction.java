package io.vertigo.demo.ui.controller.accueil;

import io.vertigo.core.Home;
import io.vertigo.demo.domain.administration.utilisateur.Role;
import io.vertigo.demo.domain.administration.utilisateur.Utilisateur;
import io.vertigo.demo.domain.administration.utilisateur.UtilisateurLogin;
import io.vertigo.demo.services.DemoUserSession;
import io.vertigo.demo.services.administration.utilisateur.UtilisateurServices;
import io.vertigo.demo.ui.controller.AbstractDemoActionSupport;
import io.vertigo.persona.security.KSecurityManager;
import io.vertigo.struts2.core.ContextForm;
import io.vertigo.struts2.core.UiRequestUtil;

import javax.inject.Inject;

/**
 * @author npiedeloup
 * @version $Id: LoginAction.java,v 1.6 2014/08/04 16:57:50 npiedeloup Exp $
 */
public final class LoginAction extends AbstractDemoActionSupport {
	private static final long serialVersionUID = 3517185648660870776L;

	@Inject
	private KSecurityManager securityManager;

	@Inject
	private UtilisateurServices utilisateurServices;

	private final ContextForm<UtilisateurLogin> utilisateurLoginRef = new ContextForm<>("utilisateur", this);

	/** {@inheritDoc} */
	@Override
	public void initContext() {
		final UtilisateurLogin utilisateurLogin = new UtilisateurLogin();
		utilisateurLogin.setLogin("test");
		utilisateurLoginRef.publish(utilisateurLogin);
		toModeEdit();
	}

	/**
	 * Connexion.
	 * @return outcome du login
	 */
	public String doLogin() {
		final UtilisateurLogin utilisateurLogin = utilisateurLoginRef.readDto();
		final Utilisateur utilisateur = utilisateurServices.connecterUtilisateur(utilisateurLogin);

		final DemoUserSession session = securityManager.<DemoUserSession> getCurrentUserSession().get();
		session.setUtilisateur(utilisateur);

		for (final Role role : utilisateur.getRoleList()) {
			session.addRole(Home.getDefinitionSpace().resolve(role.getRolCode(), io.vertigo.persona.security.metamodel.Role.class));
		}
		session.authenticate();

		return SUCCESS; //success va sur accueil
	}

	/**
	 * D�connexion.
	 * @return outcome du logout
	 */
	public String doLogout() {
		UiRequestUtil.invalidateHttpSession();
		return "reload"; // reload la page
	}

	/** {@inheritDoc} */
	@Override
	public String getPageName() {
		return "Page de connexion";
	}
}
