package _02_Selenium_Automation_Techniques__Dynamic_XPath;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver.Window;

public class CC_MultipleWindows_Work_With_Multiple_Windows_Part_2 { // Do not change the class name

	// Use these declarations to store respective values
	static String parentWinHandle;
	static String childWinHandle;
	static WebDriver driver;

	public WebDriver createDriver() // Do not change the method signature
	{
		/*
		 * Replace this comment by the code statement to create driver, assign it to
		 * 'static' variable and return the driver
		 */
		/* Use the URL, 'http://webapps.tekstac.com/FormRegistration/indexemi.html' */
		driver = CC_DriverSetup_Work_With_Multiple_Windows_Part_2.getWebDriver();
		return driver;
	}

	public String getParentWindow() throws Exception { // Do not change the method signature
		// Get Parent Window Handle as string and return it
		parentWinHandle = driver.getWindowHandle();
		return parentWinHandle;
	}

	public String getChildWindow() throws Exception { // Do not change the method signature
		// Click the href link. Find the child window's handle and return it.
		// Hint: WAIT for child page to load and find the child window handle.
		driver.findElement(By.linkText("Click to calculate EMI")).click();
		Thread.sleep(5000);

		Set<String> set = driver.getWindowHandles();
		for (String handle : set) {
			if (!handle.equals(parentWinHandle)) {
				childWinHandle = handle;
				driver.switchTo().window(childWinHandle);
				break;
			}
		}
		return childWinHandle;
	}

	public WebDriver getBackParent(String parentWinHandle) throws Exception { // Do not change the method signature
		// Switch back to parent window and return its webdriver
		WebDriver Pardriver = driver.switchTo().window(parentWinHandle);
		return Pardriver;
	}

	public String getChildWindowTitle() throws Exception {
		// Get Child Window's title and return it
		return driver.switchTo().window(childWinHandle).getTitle();
	}

	public void minimizeWindow() throws Exception { // Do not change the method signature
		// Minimize the current window
		driver.manage().window().setPosition(new Point(0, 3000));
	}

	public void maximizeWindow() throws Exception { // Do not change the method signature
		// Maximize the current window. Use BUILT-IN method.
		driver.manage().window().maximize();
	}

	public void resizeWindow() { // Do not change the method signature
		// Resize the current window to width=1200, height=800
		driver.manage().window().setSize(new Dimension(1200, 800));
	}

	public static void main(String[] args) throws Exception {
		CC_MultipleWindows_Work_With_Multiple_Windows_Part_2 win = new CC_MultipleWindows_Work_With_Multiple_Windows_Part_2();
		// Implement code here
		driver = win.createDriver();
		parentWinHandle = win.getParentWindow();
		childWinHandle = win.getChildWindow();

		String childTitle = win.getChildWindowTitle();
		
		win.minimizeWindow();
		win.maximizeWindow();
		win.resizeWindow();
		driver = win.getBackParent(parentWinHandle);
		System.out.println("Child Window Title : " + childTitle);
		driver.quit();
	}
}