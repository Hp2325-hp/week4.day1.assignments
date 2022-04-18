package week4.day1.assignments;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {


		//Webdriver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//frame1
		driver.switchTo().frame("frame1");
		
		//accessing topic
		driver.findElement(By.tagName("input")).sendKeys("Hari");
		
		//frame1->frame3
		driver.switchTo().frame("frame3");
		
		//checkbox click
		driver.findElement(By.id("a")).click();
		
		//come out both frame
		driver.switchTo().defaultContent();
		
		//frame2
		driver.switchTo().frame("frame2");
		
		//drop down
		WebElement findElement = driver.findElement(By.id("animals"));
		Select s=new Select(findElement);
		s.selectByIndex(1);
		
		
		

	}

}
