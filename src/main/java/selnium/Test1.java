package selnium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public  WebDriver driver;
	public void Open()
	{
		System.setProperty("webdriver.chromedriver", "C:/chromedriver/chromedriver-win64/chromedriver.exe");  
		driver=new ChromeDriver(); 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
}
