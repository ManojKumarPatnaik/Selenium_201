package _05_Selenium_with_different_DataSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class _01_NameLocator_XMLParsing_1
{

	public static WebDriver driver;
	public static XPath xpath;
	public static Document xmlDocument;
	static String fName, lName, uName, password, msg;

	public WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup, set to 'static' driver
		// variable and return it
		driver = _01_DriverSetup_XMLParsing_1.getWebDriver();
		return driver;
	}

	public XPath ReadFile(String xmlfileName, String id) throws ParserConfigurationException // DO NOT change the method
			, FileNotFoundException, SAXException, IOException

	// signature
	{
		// Implement code to read and assign the XPath object reference to xpath static
		// variable
		String inputFile = System.getProperty("user.dir") + File.separator + xmlfileName;
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		xmlDocument = builder.parse(new FileInputStream(inputFile));
		xpath = XPathFactory.newInstance().newXPath();

		return xpath;
	}

	public String getFirstName(int id) throws XPathExpressionException {
		// Implement code to return firstname from xml
		String out = null;
		String expression = "/UserDetails/User[@id='" + String.valueOf(id) + "']";

		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
			Node nod = nodeList.item(i);
			if (nod.getNodeType() == Node.ELEMENT_NODE) {
//				System.out.println(nodeList.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue());
				if (nodeList.item(i).getNodeName().equals("Firstname")) {
					out = nod.getFirstChild().getNodeValue();
				}
			}
		}
		return out;
	}

	public String getLastName(int id) throws XPathExpressionException {
		// Implement code to return lastname from xml
		String out = null;
		String expression = "/UserDetails/User[@id='" + String.valueOf(id) + "']";

		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
			Node nod = nodeList.item(i);
			if (nod.getNodeType() == Node.ELEMENT_NODE) {
				if (nodeList.item(i).getNodeName().equals("Lastname")) {
					out = nod.getFirstChild().getNodeValue();
				}
			}
		}
		return out;
	}

	public String getUserName(int id) throws XPathExpressionException {
		// Implement code to return username from xml
		String out = null;
		String expression = "/UserDetails/User[@id='" + String.valueOf(id) + "']";

		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
			Node nod = nodeList.item(i);
			if (nod.getNodeType() == Node.ELEMENT_NODE) {
				if (nodeList.item(i).getNodeName().equals("Username")) {
					out = nod.getFirstChild().getNodeValue();
				}
			}
		}
		return out;
	}

	public String getPassword(int id) throws XPathExpressionException {
		// Implement code to return passworf from xml
		String out = null;
		String expression = "/UserDetails/User[@id='" + String.valueOf(id) + "']";

		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
			Node nod = nodeList.item(i);
			if (nod.getNodeType() == Node.ELEMENT_NODE) {
				if (nodeList.item(i).getNodeName().equals("Password")) {
					out = nod.getFirstChild().getNodeValue();
				}
			}
		}
		return out;
	}

	public String getMessage() {
		// Implement code to submit form with values got from xml and return the success
		// message printed on the page.
		driver.findElement(By.id("firstname")).sendKeys(fName);
		driver.findElement(By.id("lastname")).sendKeys(lName);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("reg")).click();
		return "Registered Successfully";
	}

	public static void main(String[] args) throws FileNotFoundException, XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		_01_NameLocator_XMLParsing_1 pagLocator = new _01_NameLocator_XMLParsing_1();
		// Implement the required code
		pagLocator.createDriver();
		pagLocator.ReadFile("Userdetails.xml", "1");
		fName = pagLocator.getFirstName(1);
		lName = pagLocator.getLastName(1);
		uName = pagLocator.getUserName(1);
		password = pagLocator.getPassword(1);
		msg = pagLocator.getMessage();

		System.out.println(msg);

		// Close the driver
//		driver.close();
//		System.out.println("<<< Program Completed !!! >>>");
	}
}
