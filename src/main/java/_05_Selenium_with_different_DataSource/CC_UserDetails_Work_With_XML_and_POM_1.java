package _05_Selenium_with_different_DataSource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class CC_UserDetails_Work_With_XML_and_POM_1 { // Do not change the class name

	// use this variable declaration
	public static WebDriver driver;
	public static XPath xpath;
	public static Document xmlDocument;

	public static WebDriver createDriver() { // Do not change the method signature

		/* Create a driver. Assign it to static variable 'driver' and return it */
		/*
		 * navigate to
		 * 'http://webapps.tekstac.com/FormRegistration/UserRegistration.html'
		 */
		driver = CC_DriverSetup_Work_With_XML_and_POM_1.getWebDriver();
		driver.get("http://webapps.tekstac.com/FormRegistration/UserRegistration.html");
		return driver;
	}

	public XPath ReadFile(String fileName, String id) { // Do not change the
														// method signature
		// Retrieve the xml file name passed as 'fileName' parameter. Parse the xml and
		// return the xPath
		// Parameter 'id' is the id in the Userdetails.xml
		String inputFile = System.getProperty("user.dir") + File.separator + fileName;
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			xmlDocument = builder.parse(new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xpath = XPathFactory.newInstance().newXPath();
		return xpath;
	}

	public Node getName(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'Name' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/Name/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public Node getEmail(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'Email' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/Email/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public Node getPhone(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'Phone' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/Phone/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public Node getAge(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'Age' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/Age/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public Node getPassword(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'Password' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/Password/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public Node getHobbies(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'Hobbies' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/Hobbies/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public Node getGender(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'Gender' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/Gender/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public Node getCity(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'City' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/City/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public Node getAddress(int id) throws XPathExpressionException { // Do not change the method signature
		// Parse the xml to get 'Address' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml

		String expression = "/Userdetails/User[@id='" + String.valueOf(id) + "']/Address/text()";
		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		return node;
	}

	public String getMessage() { // Do not change the method
									// signature

		// Find the web elements in the page. Assign the respective values from xml to
		// the form.
		// Submit the form
		// Locate the 'Registered Successfully' message and return it
		String out = null;
		try {
			driver.findElement(By.id("uname")).sendKeys(getAddress(1).getNodeValue());
			driver.findElement(By.id("uemail")).sendKeys(getEmail(1).getNodeValue());
			driver.findElement(By.id("phone")).sendKeys(getPhone(1).getNodeValue());
			driver.findElement(By.id("age")).sendKeys(getAge(1).getNodeValue());
			driver.findElement(By.id("pass")).sendKeys(getPassword(1).getNodeValue());
			driver.findElement(By.id("pass")).sendKeys(getPassword(1).getNodeValue());

			String hobbie = null;
			if (getHobbies(1).getNodeValue().equals("Cricket")) {
				hobbie = "option1";
			} else {
				hobbie = "option2";
			}
			WebElement chkBox = driver.findElement(By.id(hobbie));
			chkBox.click();

			String radio = null;
			if (getGender(1).getNodeValue().equals("Male")) {
				radio = "male";
			} else {
				radio = "female";
			}
			WebElement radioButton = driver.findElement(By.id(radio));
			radioButton.click();

			Select ddl = new Select(driver.findElement(By.id("city")));
			ddl.selectByVisibleText(getCity(1).getNodeValue());

			driver.findElement(By.name("address")).sendKeys(getAddress(1).getNodeValue());
			driver.findElement(By.id("submit")).submit();
			Thread.sleep(1000);
			out = driver.findElement(By.xpath("/html/body/h2")).getText();

		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	public static void main(String[] args) {
		CC_UserDetails_Work_With_XML_and_POM_1 pagLocator = new CC_UserDetails_Work_With_XML_and_POM_1();
		// Add required code here
		pagLocator.createDriver();
		pagLocator.ReadFile("Userdetails.xml", "1");
		String msg = pagLocator.getMessage();
		System.out.println(msg);
		driver.close();
	}
}
