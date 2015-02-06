package io.vertigo.demo.test;

import javax.inject.Inject;

/**
 * @author prahmoune
 * @version $Id: HomeViewController.java,v 1.1 2013/07/18 17:36:33 npiedeloup Exp $ 
 *
 */
public class HomeViewController {

	@Inject
	private MyService myService;

	public String getHello() {
		return myService.hello();
	}

	public MyService getMyService() {
		return myService;
	}

	public void setMyService(final MyService myService) {
		this.myService = myService;
	}
}
