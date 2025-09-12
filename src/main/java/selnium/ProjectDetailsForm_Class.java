package selnium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectDetailsForm_Class extends Registration_BaseClass{

	public WebDriver driver;
	public WebDriverWait wait;

	public ProjectDetailsForm_Class(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath="//button[@name='145newbrowsertab234']")
	WebElement NewBrowserTab;
	
	
	public void PageDetails()
	{
		System.out.println(driver.getTitle()+"Project tile");
		NewBrowserTab.click();
	}
	
}
