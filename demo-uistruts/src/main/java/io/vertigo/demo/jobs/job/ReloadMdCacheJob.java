package io.vertigo.demo.jobs.job;

import io.vertigo.demo.domain.DtDefinitions;
import io.vertigo.dynamo.collections.CollectionsManager;
import io.vertigo.dynamo.collections.DtListFunction;
import io.vertigo.dynamo.domain.metamodel.DtDefinition;
import io.vertigo.dynamo.domain.metamodel.DtField;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListURIForMasterData;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.transaction.KTransactionManager;
import io.vertigo.dynamo.transaction.KTransactionWritable;
import io.vertigo.lang.Option;

import java.util.Collections;

import javax.inject.Inject;

import org.apache.log4j.Logger;

/**
 * Job de rechargement du cache des MasterDataList.
 * @author npiedeloup
 * @version $Id: ReloadMdCacheJob.java,v 1.3 2014/02/07 16:48:27 npiedeloup Exp $
 */
public class ReloadMdCacheJob implements Runnable {
	private final Logger logger = Logger.getLogger(getClass());
	@Inject
	private PersistenceManager persistenceManager;
	@Inject
	private KTransactionManager transactionManager;
	@Inject
	private CollectionsManager collectionsManager;

	/** {@inheritDoc} */
	@Override
	public void run() {
		for (final Class<?> dtDefinitionClazz : new DtDefinitions()) {
			final DtDefinition dtDefinition = DtObjectUtil.findDtDefinition((Class<? extends DtObject>) dtDefinitionClazz);
			if (persistenceManager.getMasterDataConfiguration().containsMasterData(dtDefinition)) {
				ensureInCache(dtDefinition);
			}
		}

	}

	private void ensureInCache(final DtDefinition dtDefinition) {
		final DtListURIForMasterData dtListURI = persistenceManager.getMasterDataConfiguration().getDtListURIForMasterData(dtDefinition);
		try (final KTransactionWritable transaction = transactionManager.createCurrentTransaction()) {
			final Option<DtField> displayField = dtDefinition.getDisplayField();
			if (displayField.isDefined()) {
				final DtList<DtObject> dtList = persistenceManager.getBroker().getList(dtListURI); //On charge la liste
				final DtListFunction<DtObject> function = collectionsManager.createIndexDtListFunctionBuilder()
						.filter("test", 1, Collections.singletonList(displayField.get()))
						.build();
				function.apply(dtList); //On charge l'index
			} else {
				logger.warn("La liste de référence " + dtDefinition.getLocalName() + " ne possède pas de champs Display (à ajouter dans les KSP).");
			}
		}
	}
}
