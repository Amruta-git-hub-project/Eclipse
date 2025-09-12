package selnium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final  WebDriver driver;

		
			System.setProperty("webdriver.chromedriver", "C:/chromedriver/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("www.google.com");
			driver.manage().window().maximize();
	
	}

}
