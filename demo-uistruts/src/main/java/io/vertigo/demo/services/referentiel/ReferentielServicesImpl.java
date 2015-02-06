package io.vertigo.demo.services.referentiel;

import io.vertigo.demo.domain.referentiel.Famille;
import io.vertigo.demo.domain.referentiel.OuiNonChoice;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListURIForMasterData;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.domain.util.DtObjectUtil;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.transaction.Transactional;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * services associés à la gestion des produits.
 *
 * @author cgodard
 * @version $Id: ReferentielServicesImpl.java,v 1.5 2014/06/27 12:21:39 pchretien Exp $
 */
@Named("referentielServices")
@Transactional
public class ReferentielServicesImpl implements ReferentielServices {

	private List<OuiNonChoice> ouiNonList;

	@Inject
	private PersistenceManager persistenceManager;

	/**
	 * Initialisation liste de ref statiques.
	 */
	@PostConstruct
	public void init() {
		initOuiNonList();
	}

	/** {@inheritDoc} */
	@Override
	public DtList<Famille> loadFamille() {
		final DtListURIForMasterData mdlUri = persistenceManager.getMasterDataConfiguration().getDtListURIForMasterData(DtObjectUtil.findDtDefinition(Famille.class));
		return persistenceManager.getBroker().getList(mdlUri);
	}

	/** {@inheritDoc} */
	@Override
	public Famille getFamille(final Long famId) {
		final URI<Famille> uri = new URI<>(DtObjectUtil.findDtDefinition(Famille.class), famId);
		return persistenceManager.getBroker().<Famille> get(uri);
	}

	/** {@inheritDoc} */
	@Override
	public List<OuiNonChoice> getOuiNonList() {
		return ouiNonList;
	}

	private void initOuiNonList() {
		ouiNonList = new DtList<>(OuiNonChoice.class);
		ouiNonList.add(createOuiNonChoice(Boolean.TRUE, "Oui"));
		ouiNonList.add(createOuiNonChoice(Boolean.FALSE, "Non"));
	}

	private OuiNonChoice createOuiNonChoice(final Boolean key, final String libelle) {
		final OuiNonChoice dto = new OuiNonChoice();
		dto.setKey(key);
		dto.setLibelle(libelle);
		return dto;
	}

}
