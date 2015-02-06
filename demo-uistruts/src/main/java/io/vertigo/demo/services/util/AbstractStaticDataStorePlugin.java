package io.vertigo.demo.services.util;

import io.vertigo.dynamo.domain.metamodel.DtDefinition;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListURI;
import io.vertigo.dynamo.domain.model.DtListURIForCriteria;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.impl.persistence.datastore.DataStorePlugin;
import io.vertigo.lang.Assertion;
import io.vertigo.util.ClassUtil;

import java.lang.reflect.Method;

/**
 * Impl�mentation du MasterDataStore qui permet l'impl�mentation manuel des m�thodes de chargement.
 * Ce Store appel un getteur dynamique pour les listes et les objets.
 * Les m�thodes doivent etre sur le prototype suivant :
 * public Famille getFamilleMDObject(final Object key) throws KSystemException;
 * public DtList<Famille> getFamilleMDList(final DtListURIForMasterData uri) throws KSystemException;
 *
 * @author npiedeloup
 * @version $Id: AbstractStaticDataStorePlugin.java,v 1.7 2014/08/04 16:57:50 npiedeloup Exp $
 */
public class AbstractStaticDataStorePlugin implements DataStorePlugin {

	/** {@inheritDoc} */
	@Override
	public int count(final DtDefinition dtDefinition) {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <D extends DtObject> D load(final DtDefinition dtDefinition, final URI uri) {
		Assertion.checkNotNull(dtDefinition);
		Assertion.checkNotNull(uri);
		//-----
		final String methodName = "get" + dtDefinition.getClassSimpleName() + "MDObject";
		return (D) invokeMethod(methodName, uri.getKey());
	}

	/** {@inheritDoc} */
	@Override
	public <D extends DtObject> DtList<D> loadList(final DtDefinition dtDefinition, final DtListURI uri) {
		Assertion.checkNotNull(dtDefinition);
		Assertion.checkNotNull(uri);
		Assertion.checkArgument(uri instanceof DtListURIForCriteria, "This store should be use with DtListURIForCriteria only, not {0}", uri.getClass().getSimpleName());
		Assertion.checkArgument(((DtListURIForCriteria) uri).getCriteria() == null, "This store could only load all data, not {0}", ((DtListURIForCriteria) uri).getCriteria());
		//-----
		final String methodName = "get" + uri.getDtDefinition().getClassSimpleName() + "MDList";
		final DtList<D> dtList = (DtList<D>) invokeMethod(methodName, null);
		dtList.setURI(uri);
		return dtList;
	}

	/** {@inheritDoc} */
	@Override
	public void create(final DtDefinition dtDefinition, final DtObject dto) {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public void update(final DtDefinition dtDefinition, final DtObject dto) {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public void merge(final DtDefinition dtDefinition, final DtObject dto) {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public void delete(final DtDefinition dtDefinition, final URI uri) {
		throw new UnsupportedOperationException();
	}

	private Object invokeMethod(final String methodName, final Object uri) {
		final Class<?>[] parameterTypes = uri == null ? new Class[0] : new Class[] { uri.getClass() };
		final Method method = ClassUtil.findMethod(this.getClass(), methodName, parameterTypes);

		//2. On "invoke" dynamiquement la méthode
		try {
			if (uri == null) {
				return ClassUtil.invoke(this, method);
			}
			return ClassUtil.invoke(this, method, uri);
		} catch (final Exception e) {
			throw new RuntimeException(this.getClass().getSimpleName(), e);
		}
	}
}
