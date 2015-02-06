package io.vertigo.demo.services.dynaobject;

import io.vertigo.dynamo.domain.metamodel.DtDefinition;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListURI;
import io.vertigo.dynamo.domain.model.DtListURIForCriteria;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.persistence.PersistenceManager;
import io.vertigo.dynamo.transaction.Transactional;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Service g�n�rique pour la gestion de la persistance des DtObjects.
 *
 * @author prahmoune
 * @version $Id: DynaObjectServiceImpl.java,v 1.5 2014/06/27 12:21:39 pchretien Exp $
 *
 */
@Named("dynaObjectService")
@Transactional
public final class DynaObjectServiceImpl implements DynaObjectService {

	@Inject
	private PersistenceManager persistenceManager;

	/** {@inheritDoc} */
	@Override
	public DtObject load(final DtDefinition dtDefinition, final Serializable id) {
		final URI<DtObject> uri = new URI<>(dtDefinition, id);
		return persistenceManager.getBroker().get(uri);
	}

	/** {@inheritDoc} */
	@Override
	public DtList<? extends DtObject> getList(final DtDefinition dtDefinition) {
		final DtListURI collectionURI = new DtListURIForCriteria<>(dtDefinition, null, null);
		return persistenceManager.getBroker().getList(collectionURI);
	}

	/** {@inheritDoc} */
	@Override
	public void save(final DtObject dtObject) {
		persistenceManager.getBroker().save(dtObject);
	}

	/** {@inheritDoc} */
	@Override
	public void delete(final DtDefinition dtDefinition, final Serializable id) {
		final URI<DtObject> uri = new URI<>(dtDefinition, id);
		persistenceManager.getBroker().delete(uri);
	}

}
