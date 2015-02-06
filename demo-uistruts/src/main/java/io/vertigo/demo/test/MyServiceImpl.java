package io.vertigo.demo.test;

import io.vertigo.commons.locale.LocaleManager;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author prahmoune
 * @version $Id: MyServiceImpl.java,v 1.2 2013/11/18 10:26:13 npiedeloup Exp $
 *
 */
@Named("myService")
public class MyServiceImpl implements MyService {

	@Inject
	private MyDao myDao;

	@Inject
	private LocaleManager localeManager;

	/** {@inheritDoc} */
	@Override
	public String hello() {
		System.out.println("MyDao says>" + myDao.hello());
		System.out.println("LocaleManager>" + localeManager);
		return "hello from the service tier";
	}
}
