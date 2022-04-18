package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames {

	public static void main(String[] args) throws InterruptedException {

		// Webdriver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// url
		driver.get("https://dev121343.service-now.com/");
		driver.manage().window().maximize();

		// username and password
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("India@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);

		// Search “incident “ Filter Navigator
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		Thread.sleep(2000);
		
		// Click “All”
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		
		// Click New button
		driver.findElement(By.id("sysverb_new")).click();
		Thread.sleep(2000);

		// Select a value for Caller and Enter value for short_description
		String incident = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys("Haley Rocheford");
		Thread.sleep(2000);
		driver.findElement(By.id("incident.short_description")).sendKeys("Hi This is Hp ticket");
		Thread.sleep(2000);
		
		// Incident Ticket
		System.out.println(incident);
		
		// Click on Submit button
		driver.findElement(By.id("sysverb_insert")).click();
		Thread.sleep(2000);

		// Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(incident);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(Keys.ENTER);

		// Verify the incident is created successful.
		String confimIncident = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]/a")).getText();
		Thread.sleep(1000);
		if (incident.equals(confimIncident))
			System.out.println("The Incident is Created");
		else
			System.out.println("The Incident is not created");

		Thread.sleep(3000);
		driver.close();

	}

}
