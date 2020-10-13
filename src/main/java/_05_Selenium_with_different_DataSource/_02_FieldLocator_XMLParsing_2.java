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

public class _02_FieldLocator_XMLParsing_2 {

	public static WebDriver driver;
	public static XPath xpath;
	public static Document xmlDocument;
	static String cName, iNumber, amount, mobile, msg;

	public WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup, set to 'static' driver
		// variable and return it
		driver = _02_DriverSetup_XMLParsing_2.getWebDriver();
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

	public String getCustomerName(int id) throws XPathExpressionException {
		// Implement code to return firstname from xml
		String out = null;
		String expression = "/CustomerDetails/Customer[@id='" + String.valueOf(id) + "']";

		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
			Node nod = nodeList.item(i);
			if (nod.getNodeType() == Node.ELEMENT_NODE) {
//				System.out.println(nodeList.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue());
				if (nodeList.item(i).getNodeName().equals("Customername")) {
					out = nod.getFirstChild().getNodeValue();
				}
			}
		}
		return out;
	}

	public String getInvoiceNumber(int id) throws XPathExpressionException {
		// Implement code to return lastname from xml
		String out = null;
		String expression = "/CustomerDetails/Customer[@id='" + String.valueOf(id) + "']";

		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
			Node nod = nodeList.item(i);
			if (nod.getNodeType() == Node.ELEMENT_NODE) {
				if (nodeList.item(i).getNodeName().equals("Invoicenumber")) {
					out = nod.getFirstChild().getNodeValue();
				}
			}
		}
		return out;
	}

	public String getAmount(int id) throws XPathExpressionException {
		// Implement code to return username from xml
		String out = null;
		String expression = "/CustomerDetails/Customer[@id='" + String.valueOf(id) + "']";

		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
			Node nod = nodeList.item(i);
			if (nod.getNodeType() == Node.ELEMENT_NODE) {
				if (nodeList.item(i).getNodeName().equals("Amount")) {
					out = nod.getFirstChild().getNodeValue();
				}
			}
		}
		return out;
	}

	public String getMobileNumber(int id) throws XPathExpressionException {
		// Implement code to return passworf from xml
		String out = null;
		String expression = "/CustomerDetails/Customer[@id='" + String.valueOf(id) + "']";

		Node node = (Node) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
			Node nod = nodeList.item(i);
			if (nod.getNodeType() == Node.ELEMENT_NODE) {
				if (nodeList.item(i).getNodeName().equals("Mobilenumber")) {
					out = nod.getFirstChild().getNodeValue();
				}
			}
		}
		return out;
	}

	public String getMessage() {
		// Implement code to submit form with values got from xml and return the success
		// message printed on the page.
		driver.findElement(By.id("name")).sendKeys(cName);
		driver.findElement(By.id("number")).sendKeys(iNumber);
		driver.findElement(By.name("amount")).sendKeys(amount);
		driver.findElement(By.name("num")).sendKeys(mobile);
		driver.findElement(By.id("submit")).submit();
		return "Registered Successfully";
	}

	public static void main(String[] args) throws FileNotFoundException, XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		_02_FieldLocator_XMLParsing_2 pagLocator = new _02_FieldLocator_XMLParsing_2();
		// Implement the required code
		pagLocator.createDriver();
		pagLocator.ReadFile("CustomerDetails.xml", "1");
		cName = pagLocator.getCustomerName(1);
		iNumber = pagLocator.getInvoiceNumber(1);
		amount = pagLocator.getAmount(1);
		mobile = pagLocator.getMobileNumber(1);
		msg = pagLocator.getMessage();

		System.out.println(msg);

		// Close the driver
		driver.close();
//		System.out.println("<<< Program Completed !!! >>>");
	}
}
