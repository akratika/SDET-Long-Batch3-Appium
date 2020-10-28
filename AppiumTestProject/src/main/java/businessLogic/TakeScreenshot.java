package businessLogic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	public String takeScreenshot(WebDriver driver, String screenshotName) throws Exception{
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File screenShotName;
		
		//Take Screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//screenshot location
		screenShotName = new File("src/test/resources/"+screenshotName+"_"+timestamp.toString()+".jpg");
		
		FileUtils.copyFile(srcFile, screenShotName);
		
		String filepath = screenShotName.toString();
		
		String path = "<img src='"+ filepath +"'/>";
		
		return path;
	}
}
