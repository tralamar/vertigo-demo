package io.vertigo.demo.boot.initializer;

import io.vertigo.core.spaces.component.ComponentInitializer;
import io.vertigo.demo.jobs.job.ReloadMdCacheJob;
import io.vertigo.tempo.job.JobManager;
import io.vertigo.tempo.job.metamodel.JobDefinition;

import java.util.Date;

/**
 * Initialisation du manager des jobs.
 * @author pchretien
 * @version $Id: JobManagerInitializer.java,v 1.7 2014/08/04 16:57:50 npiedeloup Exp $
 */
public final class JobManagerInitializer implements ComponentInitializer<JobManager> {

	/** {@inheritDoc} */
	@Override
	public void init(final JobManager jobManager) {
		final JobDefinition reloadMdJobDefinition = new JobDefinition("RELOAD_MD_CACHE", ReloadMdCacheJob.class);
		jobManager.scheduleAtDate(reloadMdJobDefinition, new Date(System.currentTimeMillis() + 15 * 1000));// tout de suite+30s
		jobManager.scheduleEverySecondInterval(reloadMdJobDefinition, 120);// ET toutes les 2 minutes
	}
}
