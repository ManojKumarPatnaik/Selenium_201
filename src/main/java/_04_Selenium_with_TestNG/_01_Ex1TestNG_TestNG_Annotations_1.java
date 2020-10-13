package _04_Selenium_with_TestNG;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

//ADD the required TestNG annotations on respective methods

public class _01_Ex1TestNG_TestNG_Annotations_1 { // DO NOT Change the class Name

	// Do NOT change these below declarations.
	public static WebDriver driver;
	String name;
	String password;

	@BeforeSuite
	public void createDriver() { // DO NOT change the method signature
		// Implement code to create Driver from DriverSetup and assign it to 'static'
		// driver variable
		driver = _01_DriverSetup_TestNG_Annotations_1.getWebDriver();
	}

	@Test(groups = { "initializeName" })
	public void initializeName() { // DO NOT change the method signature
		name = "Tom";
	}

	@Test(groups = { "initializePassword" })
	public void initializePassword() { // DO NOT change the method signature
		password = "Tom";
	}

	@Test(dependsOnGroups = { "initializeName", "initializePassword" })
	public void signin() { // DO NOT change the method signature
		System.out.println("signin");
	}

	@AfterSuite
	public void closeBrowser() { // DO NOT change the method signature
		driver.close();
	}

	public static void main(String[] args) { // DO NOT change the method signature
		_01_Ex1TestNG_TestNG_Annotations_1 page = new _01_Ex1TestNG_TestNG_Annotations_1();
		// Implement the required code
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { _01_Ex1TestNG_TestNG_Annotations_1.class });
		testSuite.run();
	}
}
