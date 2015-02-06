package io.vertigo.demo.boot.initializer;

import io.vertigo.demo.domain.DtDefinitions;
import io.vertigo.demo.domain.tutorial.Commune;
import io.vertigo.dynamo.domain.metamodel.DtDefinition;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtListURI;
import io.vertigo.dynamo.domain.model.DtListURIForCriteria;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.plugins.persistence.datastore.AbstractStaticDataStorePlugin;
import io.vertigo.lang.Assertion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Loader of Commune masterdata file.
 * @author npiedeloup (6 févr. 2015 10:38:17)
 */
public final class CommuneStorePlugin extends AbstractStaticDataStorePlugin {

	/** {@inheritDoc} */
	@Override
	public <D extends DtObject> D load(final DtDefinition dtDefinition, final URI uri) {
		throw new UnsupportedOperationException();
	}

	/** {@inheritDoc} */
	@Override
	public <D extends DtObject> DtList<D> loadList(final DtDefinition dtDefinition, final DtListURI uri) {
		Assertion.checkNotNull(dtDefinition);
		Assertion.checkNotNull(uri);
		Assertion.checkArgument(DtDefinitions.Definitions.Commune.name().equals(dtDefinition.getClassSimpleName()), "This store should be use for Commune only, not {0}", dtDefinition.getClassSimpleName());
		Assertion.checkArgument(uri instanceof DtListURIForCriteria, "This store should be use with DtListURIForCriteria only, not {0}", uri.getClass().getSimpleName());
		Assertion.checkArgument(((DtListURIForCriteria) uri).getCriteria() == null, "This store could only load all data, not {0}", ((DtListURIForCriteria) uri).getCriteria());
		//----
		return (DtList<D>) loadList();
	}

	private DtList<Commune> loadList() {
		final String fileName = "/data/insee.csv";
		try (final InputStream inputStream = getClass().getResourceAsStream(fileName)) {
			Assertion.checkNotNull(inputStream, "fichier non trouvé : {0}", fileName);
			try (final BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream))) {
				final DtList<Commune> dtc = new DtList<>(Commune.class);
				String line;
				while ((line = rd.readLine()) != null) {
					dtc.add(readCommune(line));
					if (dtc.size() > 100) {
						break;
					}
				}
				return dtc;
			}
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Commune readCommune(final String line) {
		final Commune commune = new Commune();
		final String[] params = line.split(";");
		// System.out.println(params[0]);
		// On complete le code commune à 5 caractères quand il existe (exception : Lajoux)
		commune.setCommune(params[0]);
		if (params[1].length() > 0) {
			if (params[1].length() == 4) {
				params[1] = "0" + params[1];
			}

			commune.setCodePostal(params[1]);
		}
		commune.setDepartement(params[2]);
		commune.setIdInsee(Long.valueOf(params[3]));
		return commune;
	}
}
