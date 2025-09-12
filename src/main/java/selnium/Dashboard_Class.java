package selnium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Class extends BaseClass1{
	//public  WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'product_label')]")
	WebElement Dashboardtitle;
	
	/*
	 * @FindBy(css="//img[contains(@class,'oxd-userdropdown-img')]") WebElement
	 * Dashboardimg;
	 */
	
	@FindBy(xpath="//a[contains(@href,'admin')]")
	WebElement Admin;
	
	
	 public Dashboard_Class(WebDriver driver) 
	 	{
		 this.driver=driver;
		 System.out.println(driver.getTitle()+"dashboard");
		 }
	 
	  
			/*
			 * public Dashboard_Class() { PageFactory.initElements(driver,this); }
			 */
	 
	 public String Dashboard_GetTitle()
		{
		 System.out.println(driver.getCurrentUrl()+"URL");
	
		String title=Dashboardtitle.getText();
		 System.out.println(title+"title");
		 return title;
		}
	 
	 public boolean Dashboard_Img()
	 {
		 //WebElement Img= driver.findElement(By.xpath("//div[@class='peek' and style='left:15px;width:100px;height:100px;']"));
		 WebElement Img=driver.findElement(By.cssSelector("div.peek"));
		 //String ProImg=Img.getCssValue("backgroung-image");
		 return Img.isDisplayed();  
	 }
	 
	 public WebElement Dashboard_Img2()
	 {
		 //WebElement Img= driver.findElement(By.xpath("//div[@class='peek' and style='left:15px;width:100px;height:100px;']"));
		 WebElement Img=driver.findElement(By.cssSelector("div.peek"));
		 //String ProImg=Img.getCssValue("backgroung-image");
		 return Img;  
	 }
	  
		/*
		 * public Admin_Class GotoAdminPage() {
		 * driver.findElement(By.xpath("//a[contains(@href,'admin')]")).click(); return
		 * PageFactory.initElements(driver, Admin_Class.class); }
		 */

  
}
