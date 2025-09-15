package selnium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectDetailsForm_Class extends Registration_BaseClass{

	public WebDriver driver;
	public WebDriverWait wait;
	public String ChildWindowHandle;

	public ProjectDetailsForm_Class(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath="//button[@name='145newbrowsertab234']")
	WebElement NewBrowserTab;
	
	@FindBy(xpath="//center/h2")
	WebElement PageTitle;
	
	@FindBy(id="nameInput")
	WebElement Name;
	
	@FindBy(id="roleInput")
	WebElement Role;
	
	@FindBy(id="emailInput")
	WebElement Email;
	
	@FindBy(id="locationInput")
	WebElement Location;
	
	@FindBy(id="departmentInput")
	WebElement Dept;
	
	@FindBy(id="addBtn")
	WebElement Add;
	
	
	 @FindBy(xpath="//input[@type='checkbox']") 
	 WebElement checkbox;
	 
	
	public void PageDetails()
	{
		System.out.println(driver.getTitle()+"Project tile");
		//System.out.println(nm+"NAme");

		NewBrowserTab.click();
		String parentid=driver.getWindowHandle();
		
		Set<String>childid=driver.getWindowHandles();
		for(String childhandle:childid)
		{
			if(!childhandle.equals(parentid))
			{
				ChildWindowHandle=childhandle;
				driver.switchTo().window(ChildWindowHandle);
				System.out.println(driver.getTitle()+"Inside the childwindow");
				wait.until(ExpectedConditions.visibilityOf(PageTitle));
				//Add_Row(nm,role,email,loc,dept);
			}
			
		}
		//driver.switchTo().window(childid);
		
		
	}
	
	public void Add_Row(String name,String role, String email, String location,String department )
	{
		Name.sendKeys(name);
		Role.sendKeys(role);
		Email.sendKeys(email);
		Location.sendKeys(location);
		Dept.sendKeys(department); 
		Add.click(); 
	}
	
	
	public void Deselect_Row()
	{
		List<WebElement>checkboxs=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement Multiple_Chkbox:checkboxs)
		{
			WebElement Namecolumn=Multiple_Chkbox.findElement(By.xpath("./ancestor::td/following-sibling::td[1]"));
			System.out.println(Namecolumn.getText()+"Tvale name"); 
			if(Namecolumn.getText().contains("Abhishek"))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Namecolumn);

				try {
					//Thread.sleep(2000);
					/*if(!Multiple_Chkbox.isSelected())
					{*/
						wait.until(ExpectedConditions.elementToBeClickable(Multiple_Chkbox)).click();
						//Multiple_Chkbox.click(); 
						System.out.println("checkbox.click"); 
					//}  
				
				} catch (ElementClickInterceptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 System.out.println("Normal click failed, trying JS click");
					 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Multiple_Chkbox);
				}
			
			}
		}
			
	}
} 
