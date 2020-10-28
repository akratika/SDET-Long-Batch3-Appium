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


public class Goal_1_activity {
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
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);
		
		driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 20);
	  }
	
  @Test
  public void addNewTask() throws Exception {
	  //task 1
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
	  driver.findElementById("tasks_fab").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
	  driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
	  Reporter.log(scrshot.takeScreenshot(driver,"act_GoogleTask"));
	  driver.findElementById("add_task_done").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("task_item_layout")));
	  MobileElement act1 = driver.findElementByAccessibilityId("Complete Activity with Google Tasks");
	  Assert.assertTrue(act1.isDisplayed());
	  		  
	//task 2		  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
	  driver.findElementById("tasks_fab").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
	  driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
	  Reporter.log(scrshot.takeScreenshot(driver,"act_googleKeep"));
	  driver.findElementById("add_task_done").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Complete Activity with Google Keep")));
	  MobileElement act2 = driver.findElementByAccessibilityId("Complete Activity with Google Keep");
	  Assert.assertTrue(act2.isDisplayed());
	  
	 //task 3 
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
	  driver.findElementById("tasks_fab").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
	  driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
	  Reporter.log(scrshot.takeScreenshot(driver,"act_sec_googleKeep"));
	  driver.findElementById("add_task_done").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Complete the second Activity Google Keep")));
	  MobileElement act3 = driver.findElementByAccessibilityId("Complete the second Activity Google Keep");
	  Assert.assertTrue(act3.isDisplayed());
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
