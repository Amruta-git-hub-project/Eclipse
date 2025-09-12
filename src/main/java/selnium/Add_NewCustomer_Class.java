package selnium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_NewCustomer_Class extends Demo_BaseClass {
	
  public  WebDriver driver;

	 public Add_NewCustomer_Class(WebDriver driver) 
	 	{
		 this.driver=driver;
	     PageFactory.initElements(driver, this); // Initialize all elements

		 }
	
			
			 @FindBy(xpath="//input[@name='name']") 
			 WebElement CustomerName1;
			 
	
	@FindBy(xpath="//input[@name='dob']")
	WebElement DOB;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement Address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement City;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement State;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement Pin;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement Email;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement Submit;
	
	
	 
	 public void Add_Customer(String CustName, String dob, String Add, String city, String state, String PIN, String email)  
	 {
		
		 System.out.println(CustName+"Custnamerrr"); 
		 System.out.println(Add+"Addrrr");
		 System.out.println(dob+"dobrrr"); 

			
			 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(1000));
			// WebElement CustomerName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));//It can be used when using webelement locators direclty//
			 WebElement CustomerName=wait.until(ExpectedConditions.visibilityOf(CustomerName1));
			 CustomerName.clear(); 
			 CustomerName.sendKeys(CustName);     
 
			 WebElement Date=wait.until(ExpectedConditions.visibilityOf(DOB));
			 Date.clear(); 
			 Date.sendKeys(dob);   
			 
			 Address.clear();
			 Address.sendKeys(Add);
			 City.clear(); 
			 City.sendKeys(city); 
			 State.clear();
			  State.sendKeys(state); 
			  Pin.clear();
			  Pin.sendKeys(PIN); 
			  Email.clear();
			  Email.sendKeys(email);
			
		 Submit.click();
	 }
	  
	 public void AddTitle()  
	 {
		 System.out.println(driver.getTitle()+"AddTitle");   
			/*
			 * WebElement
			 * CustomerName1=driver.findElement(By.xpath("//input[@name='name']"));
			 */
			/*
			 * WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(1000));
			 * wait.until(ExpectedConditions.visibilityOf(CustomerName1));
			 * 
			 * CustomerName1.sendKeys("amruta");
			 */
			 

	 }
}
