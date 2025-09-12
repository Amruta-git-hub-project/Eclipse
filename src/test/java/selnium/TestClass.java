package selnium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
public  WebDriver driver;
	
	@BeforeClass
	public void Setup1()
	{
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver-win64/chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("www.google.com");     
		driver.manage().window().maximize();
	}
	@Test
	public void GetURL()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.findElement(By.xpath("//a[contains(@href,'www.linkedin.com')]")).click();
			driver.findElement(By.xpath("//a[contains(@href,'www.youtube.com')]")).click();
			driver.findElement(By.xpath("//a[contains(@href,'www.facebook.com')]")).click();
			
			Set<String>handle= driver.getWindowHandles();
			SwitchtoRightWindow("linkedin",handle);
	}
	
	public void SwitchtoRightWindow(String windowtitle, Set<String>windowhandle)
	{
		
	}
	
}
