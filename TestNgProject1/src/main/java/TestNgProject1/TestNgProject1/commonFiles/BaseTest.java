package TestNgProject1.TestNgProject1.commonFiles;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest 
{
	public static WebDriver driver=null;

	public void selectBrowser(String browsername, String baseurl)
	{
		browsername=browsername.toLowerCase();
		System.out.println(browsername + " browser is going to launch");
		Reporter.log(browsername + " browser is going to launch");
		if(browsername.equals("chrome"))
		{
			//Create a map to store  preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();

			//add key and value to map as follow to switch off browser notification
			//Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 1);

			//Create an instance of ChromeOptions 
			ChromeOptions options = new ChromeOptions();

			// set ExperimentalOption - prefs 
			options.setExperimentalOption("prefs", prefs);				

			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver(options);
		}

		if(browsername.equals("chrome_incog"))
		{
			//Create an instance of ChromeOptions 
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--incognito");		

			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver(options);
		}

		if(browsername.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}	

		if (browsername.equals("andriodBrowser"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.android();
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
			//capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "my phone");
			capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");
			capabilities.setCapability("udid", "");
			URL mobile_url=null;
			try {
				mobile_url = new URL("http://127.0.0.1:4723/wd/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//capabilities.setCapability("orientation","LANDSCAPE");
			// Create object of AndroidDriver class and pass the url and capability that we
			// created
			driver = new AndroidDriver(mobile_url, capabilities);
		}		
		Reporter.log("successfully browser opened");
		System.out.println("successfully browser opened");
		driver.get(baseurl);
		System.out.println("successfully url passed");
		Reporter.log("successfully url passed");
		driver.manage().window().maximize();
	}

	public void closebrowser()
	{
		driver.close();
		System.out.println("successfully browser closed");
		Reporter.log("successfully browser closed");
	}
}
