package testProject.AppiumTestProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
		
public class Activity_1 {
	AppiumDriver<MobileElement> driver = null;
	DesiredCapabilities caps = null;
	 @BeforeClass
	  public void setup() throws MalformedURLException {
		  caps = new DesiredCapabilities();
		  caps.setCapability("deviceId", "DRGID19032401420");
		  caps.setCapability("deviceName", "HMD Global Nokia 6.1 Plus");
		  caps.setCapability("platformName", "Android");
		  caps.setCapability("appPackage", "com.android.chrome");
		  caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		  caps.setCapability("noReset", true);
			
		  driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	  }
  @Test
  public void pageTitle() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.training-support.net/");
	  
	 // String pageTitle = 
	  
	  
  }
 

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
