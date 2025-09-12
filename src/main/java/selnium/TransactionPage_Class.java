package selnium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransactionPage_Class extends Registration_BaseClass {

	public WebDriver driver;
	public WebDriverWait wait;
	private Menu_Page_Class menupage;
	
	public TransactionPage_Class(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(15)); 
		this.menupage= new Menu_Page_Class(driver);
 
	}
	
	//@FindBy(xpath="//li[contains(@id,'menu-item-6372')]/a")
	//WebElement Menu;
	

	@FindBy(id="messageContainer")
	WebElement TransID;
	
	
	public String GetTransaction_ID()
	{
		System.out.println(TransID.getText()+"ID of Transaction page");
		String Tr_ID=TransID.getText();
		return Tr_ID;
		

	} 
	
	/*
	 * public RegistrationForm_Class MenuClick() throws InterruptedException {
	 * System.out.println("MenuClick"+driver.getTitle());
	 * 
	 * // wait until Transaction ID is visible (page loaded)
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
	 * "messageContainer")));
	 * 
	 * 
	 * 
	 

	By menuLocator = By.xpath("//li[contains(@class,'menu-item-6372')]/a");
	WebElement menu = null;
	boolean clicked = false;
	int attempt = 0;
	// now wait for menu visible
	// WebElement menu =
	// wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));

	while(attempt<2&&!clicked)
	{

		try {
			menu = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[contains(@class,'pull-right')]/ul/li[5]/a")));
			// scroll into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);

			// try normal click, fallback JS click

			wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
			clicked = true;
		} catch (Exception e) {
			System.out.println("Attempt " + (attempt + 1) + " failed to click menu. Retrying...");
			try {
				Thread.sleep(2000); // small buffer before retry
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);//
		}
		attempt++;
		System.out.println("clickssssss");

	}// End of While loop//
	// Now click submenu + registration link
	wait.until(ExpectedConditions.elementToBeClickable(SubMenu)).click();wait.until(ExpectedConditions.elementToBeClickable(RegMenu)).click();

	// Wait until Registration page loads (FirstName visible)
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vfb-5")));System.out.println("Successfully navigated back to Registration Form");

	return new RegistrationForm_Class(driver);
	}*/
	
	/*
	 * public RegistrationForm_Class GoToRegistrationform() {
	 * 
	 * return new RegistrationForm_Class(driver);
	 * 
	 * }
	 */
	
	public RegistrationForm_Class MenuClick() throws InterruptedException
	{
		System.out.println("MenuClick"+driver.getTitle());
		 
		 // wait until Transaction ID is visible (page loaded)
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("messageContainer")));
			//return new RegistrationForm_Class(driver);
		  return menupage.GoToRegistrationForm(); 

		
	}
	
	public ProjectDetailsForm_Class GoToProjectDetails_Page()
	{
		System.out.println("ProjectDetailsForm_Class"+driver.getTitle());

		return menupage.GoToProjectDetails();
		
	}
	
}
