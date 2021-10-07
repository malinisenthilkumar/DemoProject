package org.test;

import org.basic.Baseclass;
import org.testng.annotations.Test;

public class Testparallel extends Baseclass{
	@Test
	private void test1(String browser) {
		if(browser.equals("Chrome")) {
			browserLaunch(browser);
		}
	}

}
