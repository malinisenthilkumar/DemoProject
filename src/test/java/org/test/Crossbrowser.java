package org.test;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Crossbrowser extends Baseclass{
	@Parameters({"Browser"})
	@Test
	private void test1(String browser){
		Date d=new Date();
		System.out.println(d);
		browserLaunch(browser);
		LaunchTheUrl("http://en-gb.facebook.com/");
	}
	

}
