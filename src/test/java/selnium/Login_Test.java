package selnium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Test extends BaseClass1{
	
	Login_Class LC;
	Dashboard_Class DC;
	Admin_Class AC;
	
	@BeforeTest() 
	public void OpenURL()
	{
		BaseClass1 bs= new BaseClass1();
		bs.Setup();
		LC=bs.LoginPage();
		
		/*
		 * Login_Class LC= new Login_Class(); LC.OpenLoginPage();
		 * System.out.println("OpenURL");
		 */

		 
	} 

	@Parameters({"username","password"})
	@Test
	public void LoginPage(String username, String password)
	{
		LC.Login(username, password);
		DC=LC.GotoDashboard();	 
	}
	
	@Test
	public void VerifyTitle() 
	{
	String dashtitle=	DC.Dashboard_GetTitle();
	//String dashtitle=title.getText();
	Assert.assertEquals(dashtitle, "Products");
	}
	 
	
	 @Test public void VerifyImg() { boolean flag=DC.Dashboard_Img();
	 System.out.println(flag+"Img is present");
	 Assert.assertTrue(flag, "img is present?"); }
	 
	 @Test
	 public void VerifyImg2()
	 {
		 WebElement VerifyImg= DC.Dashboard_Img2();
		 String img= VerifyImg.getCssValue("background-img");
		 if(img!=null && img.contains("peek.img"))
		 {
			 System.out.println("Img is present");
		 }
		 else
		 {
			 System.out.println("Img is not present");

		 }
	 }
	  
	 // @Test public void Admin_Page() { AC=DC.GotoAdminPage(); }
	 
	
	
}
