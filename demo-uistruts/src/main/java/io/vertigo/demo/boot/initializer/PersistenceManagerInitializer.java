package io.vertigo.demo.boot.initializer;

import io.vertigo.core.spaces.component.ComponentInitializer;
import io.vertigo.demo.domain.referentiel.Famille;
import io.vertigo.demo.domain.tutorial.Commune;
import io.vertigo.demo.domain.tutorial.TutoObjectEtat;
import io.vertigo.demo.domain.tutorial.TutoObjectType;
import io.vertigo.demo.services.util.TutoMasterDataStoreStatic;
import io.vertigo.dynamo.domain.metamodel.DtDefinition;
import io.vertigo.dynamo.domain.model.DtListURIForMasterData;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;
import io.vertigo.dynamo.impl.persistence.datastore.DataStorePlugin;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.util.StringUtil;

import java.io.Serializable;

/**
 * Initialisation du manager des masterdatas.
 * @author pchretien
 * @version $Id: PersistenceManagerInitializer.java,v 1.6 2014/08/04 16:57:50 npiedeloup Exp $
 */
public final class PersistenceManagerInitializer implements ComponentInitializer<PersistenceManager> {
	private static final String TOUS = null; // Code pour TOUS = null

	/** {@inheritDoc} */
	@Override
	public void init(final PersistenceManager persistenceManager) {
		registerMasterData(persistenceManager, Famille.class);
		//Liste de r�f�rence des communes-CP
		registerMasterData(persistenceManager, Commune.class, TOUS, null, null, new CommuneStorePlugin(), false);

		// Enregistrement des listes de r�f�rence
		registerMasterData(persistenceManager, TutoObjectType.class, TOUS, null, null, new TutoMasterDataStoreStatic("Ref1"), true);
		registerMasterData(persistenceManager, TutoObjectEtat.class, TOUS, null, null, new TutoMasterDataStoreStatic("Ref2"), true);
	}

	//	private static DtListURIForMasterData createDtListURI(final PersistenceManager persistenceManager, final Class<? extends DtObject> dtObjectClass, final String code) {
	//		return new DtListURIForMasterData(DtObjectUtil.findDtDefinition(dtObjectClass), code);
	//	}

	private static void registerMasterData(final PersistenceManager persistenceManager, final Class<? extends DtObject> dtObjectClass) {
		registerMasterData(persistenceManager, dtObjectClass, TOUS, null, null, null, true);
	}

	//	private static void registerMasterData(final PersistenceManager persistenceManager, final Class<? extends DtObject> dtObjectClass, final String code, final String fieldName, final Serializable value) {
	//		Assertion.checkNotNull(code, "Le code de la MasterDataList doit �tre non null");
	//		Assertion.checkArgNotEmpty(fieldName, "Le nom du champsde la MasterDataList � filtrer doit �tre non null");
	//		//---------------------------------------------------------------------
	//		registerMasterData(persistenceManager, dtObjectClass, code, fieldName, value, null, true);
	//	}

	private static void registerMasterData(final PersistenceManager persistenceManager, final Class<? extends DtObject> dtObjectClass, final String code, final String fieldName, final Serializable value, final DataStorePlugin specificStore, final boolean isReloadedByList) {
		final DtDefinition dtDefinition = DtObjectUtil.findDtDefinition(dtObjectClass);
		persistenceManager.getBrokerConfiguration().registerCacheable(dtDefinition, 3600, isReloadedByList);
		final DtListURIForMasterData uri = new DtListURIForMasterData(dtDefinition, code);
		if (StringUtil.isEmpty(fieldName)) {
			persistenceManager.getMasterDataConfiguration().register(uri);
		} else {
			persistenceManager.getMasterDataConfiguration().register(uri, StringUtil.camelToConstCase(fieldName), value);
		}
		if (specificStore != null) {
			persistenceManager.getBrokerConfiguration().register(dtDefinition, specificStore);
		}
	}

}
