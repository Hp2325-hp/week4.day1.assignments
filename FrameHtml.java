package week4.day1.assignments;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHtml {

	public static void main(String[] args) throws IOException {
		
		//Webdriver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//url and maximize
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
		//Screenshot
		//click the "click me" in 1st frame
		driver.switchTo().frame(0);
		driver.findElement(By.tagName("button")).click();
		//take screenshot and store
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f, new File("C:\\Users\\PC\\Pictures\\screenshot01.png"));
	    System.out.println("Screenshot is taken");
	    //moving back to main window
	    driver.switchTo().defaultContent();
		
		//Find the number of frames
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The Total Frames is : "+findElements.size());

	}

}
