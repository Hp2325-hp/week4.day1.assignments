package week4.day1.assignments;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
		//Webdriver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//url
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//login
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[text()='Merge Contacts']")).click();
		
		//parent
		String parentwindow=driver.getWindowHandle();
		System.out.println(parentwindow);

		//Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@name='ComboBox_partyIdFrom']/following-sibling::a")).click();
		
		//new window control
		String newwindow=driver.getWindowHandle();
		driver.switchTo().window(newwindow);
		System.out.println(newwindow);
		//Set<String> firstwindow=driver.getWindowHandles();
		//List<String> fw=new ArrayList<String>(firstwindow);
		//driver.switchTo().window(fw.get(1));
		
		System.out.println(driver.getTitle());
		
		//Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner')]/a)[1]")).click();
		
		//back control to parent
		driver.switchTo().window(parentwindow);
		
		System.out.println(driver.getTitle());
		
		
		//Click on Widget of To Contact
		driver.findElement(By.xpath("(//td[@class='titleCell']/following-sibling::td/a)[2]")).click();
		
		//second new window handle
		Set<String> secwindow=driver.getWindowHandles();
		List<String> sw=new ArrayList<String>(secwindow);
		driver.switchTo().window(sw.get(1));
		
		//Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a)[2]")).click();
		
		//back control to parent
		driver.switchTo().window(parentwindow);
		
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//td/a[text()='Merge']")).click();
		
		//alert
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		//title
		System.out.println(driver.getTitle());
		
		
		
		
	}

}
