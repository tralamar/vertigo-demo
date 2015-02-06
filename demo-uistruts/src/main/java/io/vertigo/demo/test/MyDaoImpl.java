package io.vertigo.demo.test;

import javax.inject.Named;

/**
 * @author prahmoune
 * @version $Id: MyDaoImpl.java,v 1.1 2013/07/18 17:36:33 npiedeloup Exp $
 *
 */
@Named("myDao")
public class MyDaoImpl implements MyDao {

	/** {@inheritDoc} */
	@Override
	public String hello() {
		return "hello from the persistence tier";
	}
}
