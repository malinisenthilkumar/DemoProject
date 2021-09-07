package org.testrerun;

import org.junit.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class DemoRerun implements IRetryAnalyzer {

	
@Test
private void test1() {
	System.out.println("test1");
}

@Test(retryAnalyzer=DemoRerun.class)
private void test2() {
	System.out.println("test2");
	Assert.fail();
}

@Test
private void test3() {
	System.out.println("test3");
}

	int min=0;
	int max=3;

	public boolean retry(ITestResult result) {

     if(min<max) {
    	 min ++;
    	 return true;
     
	}
	return false;
}
}
