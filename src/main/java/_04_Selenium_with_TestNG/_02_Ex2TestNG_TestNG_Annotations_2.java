package _04_Selenium_with_TestNG;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import _04_Selenium_with_TestNG._01_Ex1TestNG_TestNG_Annotations_1;

//@Listeners(FeatureTest.class) // DO NOT remove or alter this line. REQUIRED FOR TESTING
public class _02_Ex2TestNG_TestNG_Annotations_2 { // DO NOT Change the class Name

	public static WebDriver driver;
	String name;
	String password;

	@BeforeSuite
	public void createDriver() { // DO NOT change the method signature
		// Create driver and assign it to 'static' driver variable
		driver = _02_DriverSetup_TestNG_Annotations_2.getWebDriver();
		driver.get("http://webapps.tekstac.com/Shopify/");
	}

	@BeforeMethod
	public void resetName() { // DO NOT change the method signature
		// NO implementation required. ONLY proper annotation is required.
		System.out.println("<<< Executed before every Test >>>");
	}

	@Test(dependsOnGroups = { "initializeName", "initializePassword" })
	public void signin() { // DO NOT change the method signature
		System.out.println("signin");
	}

	@Test(priority = 1, groups = { "initializeName" })
	public void initializeName() { // DO NOT change the method signature
		name = "Tom";
	}

	@Test(priority = 0, groups = { "initializePassword" })
	public void initializePassword() { // DO NOT change the method signature
		password = "Tom";
	}

	@AfterSuite
	public void closeBrowser() { // DO NOT change the method signature
		// close the driver
		driver.close();
	}

	public void invokeTest() { // DO NOT change the method signature
		// Implement code to invoke test using TestNG
		TestNG testSuite = new TestNG();

		testSuite.setUseDefaultListeners(false);
		List<String> suites = Lists.newArrayList();
		String fPath = System.getProperty("user.dir") + "/testing.xml";
		suites.add(fPath);

		testSuite.setTestSuites(suites);
		testSuite.setTestClasses(new Class[] { _02_Ex2TestNG_TestNG_Annotations_2.class });
		testSuite.run();
	}

	public static void main(String[] args) {
		_02_Ex2TestNG_TestNG_Annotations_2 ex2 = new _02_Ex2TestNG_TestNG_Annotations_2();
		// Implement any required code.
		ex2.invokeTest();
	}
}
