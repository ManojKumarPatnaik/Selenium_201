package _01_Automation_Concepts__Selenium_configuration__WebDriver_Basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class _04_NameLocator_PageNavigation {
	static String page1, page2, page3, page4, page5, baseUrl;
	static WebDriver driver;

	public WebDriver setupDriver() {
		/* Replace this comment by the code statement to get the driver */
		driver = _04_DriverSetup_PageNavigation.getWebDriver();
		return driver;
	}

	public void navigate1() {
		/* Replace this comment by the code statement to navigate to baseUrl */
		baseUrl = "https://www.selenium.dev/";
		driver.navigate().to(baseUrl);
	}

	public void getPageTitle1() {
		/*
		 * Replace this comment by the code statement to get page title of
		 * "https://selenium.dev/"
		 */
		/* Assign the page title to variable 'page1' */
		page1 = driver.getTitle();
	}

	public void navigate2() {
		/*
		 * Replace this comment by the code statement to navigate to
		 * https://www.google.co.in/
		 */
		baseUrl = "https://www.google.co.in/";
		driver.navigate().to(baseUrl);
	}

	public void getPageTitle2() {
		/*
		 * Replace this comment by the code statement to get page title of
		 * https://www.google.co.in/
		 */
		/* Assign the page title to variable 'page2' */
		page2 = driver.getTitle();
	}

	public void navigateBack() {
		/* Replace this comment by the code statement to navigate back */
		driver.navigate().back();
	}

	public void getPageTitle3() {
		/*
		 * Replace this comment by the code statement to get page title of backed page
		 */
		/* Assign the page title to variable 'page3' */
		page3 = driver.getTitle();
	}

	public void navigateForward() {
		/* Replace this comment by the code statement to navigate forward */
		driver.navigate().forward();
	}

	public void getPageTitle4() {
		/*
		 * Replace this comment by the code statement to get page title of the forwarded
		 * page
		 */
		/* Assign the page title to variable 'page4' */
		page4 = driver.getTitle();
	}

	public void refreshPage() {
		/* Replace this comment by the code statement to refresh the page */
		driver.navigate().refresh();
	}

	public void getPageTitle5() {
		/*
		 * Replace this comment by the code statement to get page title of refreshed
		 * page
		 */
		/* Assign the page title to variable 'page5' */
		page5 = driver.getTitle();
	}

	public static void main(String[] args) {
		_04_NameLocator_PageNavigation namLocator = new _04_NameLocator_PageNavigation();
		// Implement code here
		driver = namLocator.setupDriver();
		namLocator.navigate1();
		namLocator.getPageTitle1();
		namLocator.navigate2();
		namLocator.getPageTitle2();
		namLocator.navigateBack();
		namLocator.getPageTitle3();
		namLocator.navigateForward();
		namLocator.getPageTitle4();
		namLocator.refreshPage();
		namLocator.getPageTitle5();

		System.out.println("Page Title 1 : " + page1);
		System.out.println("Page Title 2 : " + page2);
		System.out.println("Page Title 3 : " + page3);
		System.out.println("Page Title 4 : " + page4);
		System.out.println("Page Title 5 : " + page5);

		driver.close();

	}
}
