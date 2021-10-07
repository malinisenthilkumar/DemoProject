package org.testdataprovider;

import org.basic.Baseclass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataprovider extends Baseclass {
	@Test(dataProvider = "login")
	public void Login(String user, String pwd) {
		browserLaunch("Chrome");
		LaunchTheUrl("http://en-gb.facebook.com/");
		Pom p = new Pom();
		fillTextBox(p.getTxtUserName(), user);
		fillTextBox(p.getTxtPassword(), pwd);
	}

	// Object[][]
	@DataProvider(name = "login")
	public Object[][] getData() {
		Object[][] data = { { "Malini", "9876" }, { "Sharmila", "6976" }, { "Saravanan", "5432" } };
		return data;
	}

	@DataProvider(name = "Home")
	public Object[][] getData1() {
		Object[][] Data1 = { { "Senthil", "3487" }, { "Kumar", "3298" } };
		return Data1;

	}
}