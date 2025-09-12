package selnium;

import org.openqa.selenium.WebDriver;

public class Admin_Class extends BaseClass1{

	
	public  WebDriver driver;
	
	
	
	
	 public Admin_Class(WebDriver driver)
	 { 
		 this.driver=driver; 
	}
	 
	 public void title()
	 {
		    System.out.println(driver.getTitle()+"title");

	 }
	 
	public String AdminPage_GetTitle()
	{
		
		return driver.getTitle();
	}
}
