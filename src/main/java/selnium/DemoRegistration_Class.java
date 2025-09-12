package selnium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoRegistration_Class extends Demo_BaseClass 

{
	@FindBy(xpath="//ul[@class='menusubnav']/li[2]")
	WebElement NewCustomer;
	
	 public DemoRegistration_Class(WebDriver driver) 
	 	{
		 this.driver=driver;
		 System.out.println(driver.getTitle()+"dashboard"); 
		 }
	 
	 public Add_NewCustomer_Class NewCustomer_Page()
	 { 
		 NewCustomer.click();
		 return PageFactory.initElements(driver, Add_NewCustomer_Class.class);
		 
	 }
	 

}
