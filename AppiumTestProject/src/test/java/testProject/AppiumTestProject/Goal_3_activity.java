package testProject.AppiumTestProject;

import org.testng.annotations.Test;

import businessLogic.TakeScreenshot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import io.appium.java_client.android.AndroidDriver;


public class Goal_3_activity {
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
	  driver.findElementById("editable_title").sendKeys("Reminder Task for Google Keep");
	  driver.findElementById("edit_note_text").sendKeys("Reminder Task Note");
	  Reporter.log(scrshot.takeScreenshot(driver,"remTask_note"));
	  driver.findElementByAccessibilityId("Reminder").click();
	  
	  //select reminder
	  List<MobileElement> timeRemElem = driver.findElementsById("com.google.android.keep:id/text");
	  timeRemElem.get(1).click();
	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.TextView")));
	  List<MobileElement> remTime = driver.findElementsByClassName("android.widget.TextView");
	  for(MobileElement rem: remTime) {
		  if(rem.getText().equals("Night")) {
			  rem.click();
			  break;
		  }
	  }
	  Reporter.log(scrshot.takeScreenshot(driver,"reminder_setupscreen"));
	  driver.findElementById("com.google.android.keep:id/save").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer")));
	  Reporter.log(scrshot.takeScreenshot(driver,"reminderTask"));
	  driver.findElementByAccessibilityId("Open navigation drawer").click();
	  
	  //Check reminder assertion
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/new_note_button")));
	  MobileElement remTask = driver.findElementById("com.google.android.keep:id/reminder_chip_text");
	  Assert.assertTrue(remTask.isDisplayed());
	  Reporter.log(scrshot.takeScreenshot(driver,"rem_taskcreated"));
	 
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
