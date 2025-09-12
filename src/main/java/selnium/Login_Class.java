package selnium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Class extends BaseClass1{

	public  WebDriver driver;

	
	 public Login_Class(WebDriver driver)
	 { 
		 this.driver=driver; 
	}
	 
	public void Setup() 
	{
		System.out.println("Open");  
		System.out.println(driver.getTitle()+"Title:");
	
	}  
	

	public void Login(String username, String password)  
	{
		System.out.println(username+"user");
		try {
			Thread.sleep(2000); 
			driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys(username); 
			driver.findElement(By.name("password")).sendKeys(password);   
			driver.findElement(By.xpath("//input[@type='submit']")).click();
	
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		System.out.println("alertr");

		/*
		 * WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30)); Alert
		 * alert= wait.until(ExpectedConditions.alertIsPresent()); alert.accept();
		 */
		 try {
		        Alert alert = driver.switchTo().alert();
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        System.out.println("No alert was present to handle.");
		    }
		
	}  
	
	

	public Dashboard_Class GotoDashboard() {
		// TODO Auto-generated method stub
		return PageFactory.initElements(driver, Dashboard_Class.class);	
	}

	
	
	
	
	
}

//navigation list 
//nav[contains(@class,'oxd-topbar-body-nav')]/ul/li[3]

//select dropdown
//div[contains(@class,'oxd-select-dropdown')]
//div[@class='oxd-select-option'][2]/span
