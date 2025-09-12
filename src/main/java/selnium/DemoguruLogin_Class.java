package selnium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoguruLogin_Class extends Demo_BaseClass { 

	public  WebDriver driver;

	
	 public DemoguruLogin_Class(WebDriver driver)
	 { 
		 this.driver=driver; 
		 System.out.println(driver.getTitle()+"dashboard");

	}
	 
	 

		public void Login(String username, String password)  
		{
			System.out.println(username+"user");
			try {
				Thread.sleep(3000);  
				driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username); 
				driver.findElement(By.name("password")).sendKeys(password);   
				driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		
		}  
		
		

		public DemoRegistration_Class GotoDashboard() {
			// TODO Auto-generated method stub
			return PageFactory.initElements(driver, DemoRegistration_Class.class);	
		}

}
