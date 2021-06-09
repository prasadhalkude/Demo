package stepDefinitions;

import Cucumber.Automation.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks extends Base{
//	@Before("@smokeTest")
//	public void beforeValidation() {
//		System.out.println("in Before Hook");
//	}
//
	@After()
	public void afterValidation() {
		System.out.println("after hook");
		driver.close();
	}
}
