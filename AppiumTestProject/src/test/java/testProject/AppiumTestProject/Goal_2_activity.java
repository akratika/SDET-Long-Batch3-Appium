package testProject.AppiumTestProject;

import org.testng.annotations.Test;

import businessLogic.TakeScreenshot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import io.appium.java_client.android.AndroidDriver;


public class Goal_2_activity {
	AndroidDriver<MobileElement> driver= null;
	DesiredCapabilities caps = null;
	WebDriverWait wait = null;
	TakeScreenshot scrshot = new TakeScreenshot();
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
		caps = new DesiredCapabilities();
		caps.setCapability("deviceID", "5cc7e4447d26");
		caps.setCapability("deviceName", "Xiaomi Redmi Go");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);
		
		driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 20);
	  }
	
  @Test
  public void addNewTask() throws Exception {
	  //task creation
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/new_note_button")));
	  driver.findElementById("com.google.android.keep:id/new_note_button").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
	  driver.findElementById("editable_title").sendKeys("Task for Google Keep");
	  driver.findElementById("edit_note_text").sendKeys("Task Note");
	  Reporter.log(scrshot.takeScreenshot(driver,"task_googleKeep"));
	  driver.findElementByAccessibilityId("Open navigation drawer").click();
	  
	  //Check task assertion
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/new_note_button")));
	  String tasktext = driver.findElementById("index_note_title").getText();
	  Assert.assertEquals(tasktext, "Task for Google Keep");
	 
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
