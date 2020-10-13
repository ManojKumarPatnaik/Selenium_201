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

public class _04_NameLocator_JSONParsing_2
{
	JSONArray address;
	public static WebDriver driver;
	static String fName, lName, uName, password, pNumber, eMail;

	public void createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup and set to 'static' driver
		// variable
		driver = _04_DriverSetup_JSONParsing_2.getWebDriver();
	}

	public JSONArray ReadFile(String fileName) throws IOException, ParseException {
		// Implement code to read and return agents as JSON array
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + File.separator + fileName);
		Object obj = jsonParser.parse(reader);

		JSONObject jsonObject = (JSONObject) obj;

		address = (JSONArray) jsonObject.get("Agents");

//		for (Object o : address) {
//			System.out.println(o);
//		}

		return address;
	}

	public String getFirstName(int id) {
		// Implement code to return firstname from agent
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("FirstName");
				break;
			}
		}
//		System.out.println("FirstName : " + out);
		return out;
	}

	public String getLastName(int id) {
		// Implement code to return lastname from agent
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("LastName");
				break;
			}
		}
		return out;
	}

	public String getUserName(int id) {
		// Implement code to return username from agent
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("UserName");
				break;
			}
		}
		return out;
	}

	public String getPhoneNumber(int id) {
		// Implement code to return phonenumber from agent
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("PhoneNumber");
				break;
			}
		}
		return out;
	}

	public String getPassword(int id) {
		// Implement code to return password from agent
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("Password");
				break;
			}
		}
		return out;
	}

	public String getEmail(int id) {
		// Implement code to return email from agent
		String out = null;
		for (Object o : address) {
			JSONObject jsonObj = (JSONObject) o;
			Map<String, String> map = new HashMap<String, String>(jsonObj.size());
			for (Object jsonEntry : jsonObj.entrySet()) {
				Entry<?, ?> entry = (Map.Entry<?, ?>) jsonEntry;
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			if (map.containsValue(String.valueOf(id))) {
				out = map.get("Email");
				break;
			}
		}
		return out;
	}

	public String getMessage() {
		// Implement code to submit form with values got from json and return the
		// success message printed on the page.
		driver.findElement(By.name("firstname")).sendKeys(fName);
		driver.findElement(By.name("lastname")).sendKeys(lName);
		driver.findElement(By.name("username")).sendKeys(uName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("phonenumber")).sendKeys(pNumber);
		driver.findElement(By.name("email")).sendKeys(eMail);
		driver.findElement(By.id("submit")).submit();

		return "Registered Successfully";
	}

	public static void main(String[] args) throws IOException, ParseException {
		_04_NameLocator_JSONParsing_2 nameLocator = new _04_NameLocator_JSONParsing_2();
		// Implement the required code
		nameLocator.createDriver();
		nameLocator.ReadFile("AgentDetail.json");
		fName = nameLocator.getFirstName(1);
		lName = nameLocator.getLastName(1);
		uName = nameLocator.getUserName(1);
		password = nameLocator.getPassword(1);
		pNumber = nameLocator.getPhoneNumber(1);
		eMail = nameLocator.getEmail(1);
		String msg = nameLocator.getMessage();

		// Close the driver
		driver.close();
		System.out.println(msg);
	}

}
