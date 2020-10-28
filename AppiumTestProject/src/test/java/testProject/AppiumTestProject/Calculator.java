package testProject.AppiumTestProject;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Calculator {
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void beforeTest() {
		
		//Set Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "DRGID19032401420");
		caps.setCapability("deviceName", "HMD Global Nokia 6.1 Plus");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.calculator");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		caps.setCapability("noReset", true);
		
		//Instantiate appium driver
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
			System.out.println("Calculator is open");
			
		}catch(MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void multiply() {
		driver.findElementById("digit_7").click();
		driver.findElementById("op_mul").click();
		driver.findElementById("digit_5").click();
		driver.findElementById("eq").click();
		
		//Display result
		String result = driver.findElementById("result_final").getText();
		System.out.println(result);
		Assert.assertEquals(result, "35");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
