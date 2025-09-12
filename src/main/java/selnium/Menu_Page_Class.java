package selnium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu_Page_Class {

	private WebDriver driver;
    private WebDriverWait wait;
    
    public Menu_Page_Class(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    
	@FindBy(xpath="//div[contains(@class,'pull-right')]/ul/li[5]/a")
	private WebElement Menu;
    
	@FindBy(xpath="//div[contains(@class,'pull-right')]/ul/li[5]/ul/li[2]/a")
	private WebElement SubMenu;
	
	@FindBy(xpath="//div[contains(@class,'pull-right')]/ul/li[5]/ul/li[2]/ul/li[2]/a")
	private WebElement RegMenu;
	
	@FindBy(xpath="//div[contains(@class,'pull-right')]/ul/li[5]/ul/li[2]/ul/li[8]/a")
	private WebElement ProjectDetails;
	
    public void clickmainmenu()
    {
		 //**********************Retry Logic********************************************//
		 By menuLocator = By.xpath("//li[contains(@class,'menu-item-6372')]/a"); 
		 WebElement menu =null;
		 boolean clicked=false;
		 int attempt=0;
	    // now wait for menu visible
	   // WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));
		  
		while(attempt<2 && !clicked)  
		{
			
		
		 try {
		 menu=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'pull-right')]/ul/li[5]/a")));
	    // scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);

	    // try normal click, fallback JS click
	  
	        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
	        clicked=true;
	    } catch (Exception e) {
	        System.out.println("Attempt " + (attempt + 1) + " failed to click menu. Retrying...");
	        try {
               Thread.sleep(2000); // small buffer before retry
           } catch (InterruptedException ie) {
               Thread.currentThread().interrupt();
           }
	        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);//
	    } 
		 attempt++;
			System.out.println("clickssssss");

		}// End of While loop//	 
    }
    
    public RegistrationForm_Class GoToRegistrationForm()
    {
    	clickmainmenu();
    	wait.until(ExpectedConditions.elementToBeClickable(SubMenu)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(RegMenu)).click();
    	// Wait until Registration page loads (FirstName visible)
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vfb-5")));
    	System.out.println("Successfully navigated back to Registration Form");

   	 	return new RegistrationForm_Class(driver);

    }
    
    public ProjectDetailsForm_Class GoToProjectDetails()
    {
    	clickmainmenu();
    	wait.until(ExpectedConditions.elementToBeClickable(SubMenu)).click();

    	wait.until(ExpectedConditions.elementToBeClickable(ProjectDetails)).click();
    	
		return new ProjectDetailsForm_Class(driver);
    	
    }
    
    
    
}
