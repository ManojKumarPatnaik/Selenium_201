package _05_Selenium_with_different_DataSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class _03_FieldLocator_JSONParsing_1
{
	JSONArray address;
	public static WebDriver driver;
	static String nickName, contactName, city, type;

	public void createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup and set to 'static' driver
		// variable
		driver = _03_DriverSetup_JSONParsing_1.getWebDriver();
	}

	public JSONArray ReadFile(String fileName) throws IOException, ParseException {
		// Implement code to read and return addresses as JSON array

		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + File.separator + fileName);
		Object obj = jsonParser.parse(reader);

		JSONObject jsonObject = (JSONObject) obj;
//		System.out.println(jsonObject.get("Addresses"));

		address = (JSONArray) jsonObject.get("Addresses");

		return address;
	}

	public String getNickName(int id) {
		// Implement code to return nickname from address
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("NickName");
				break;
			}
		}
		return out;
	}

	public String getContactName(int id) {
		// Implement code to return contactname from address
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("ContactName");
				break;
			}
		}
		return out;
	}

	public String getCity(int id) {
		// Implement code to return city from address
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("City");
				break;
			}
		}
		return out;
	}

	public String getType(int id) {
		// Implement code to return type from address
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("Type");
				break;
			}
		}
		return out;
	}

	public String getMessage() {
		// Implement code to submit form with values got from json and return the
		// success message printed on the page.

		driver.findElement(By.id("nickname")).sendKeys(nickName);
		driver.findElement(By.id("contact")).sendKeys(contactName);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("type")).sendKeys(type);

		driver.findElement(By.id("add")).click();

		return null;
	}

	public static void main(String[] args) throws IOException, ParseException {
		_03_FieldLocator_JSONParsing_1 pagLocator = new _03_FieldLocator_JSONParsing_1();
		// Implement the required code
		pagLocator.createDriver();
		pagLocator.ReadFile("AddressBook.json");
		nickName = pagLocator.getNickName(1);
		contactName = pagLocator.getContactName(1);
		city = pagLocator.getCity(1);
		type = pagLocator.getType(1);

		pagLocator.getMessage();

		// Close the driver
		driver.close();
		System.out.println("<<< Program Completed !!! >>>");
	}
}
