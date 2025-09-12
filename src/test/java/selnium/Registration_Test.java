package selnium;

import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestUtil.ExcelUtil;

public class Registration_Test extends Registration_BaseClass{

	RegistrationForm_Class RFC;
	TransactionPage_Class TXC;
	ProjectDetailsForm_Class PDC;
	String sheetname="Registration"; 
	
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	public Registration_Test()
	{
		super();
	}
	
	
	@BeforeTest
	public void OpenUrl()
	{
		Registration_BaseClass RBC= new Registration_BaseClass();
		RBC.Setup();
		RFC=RBC.DemoRegistration();
	}
	
	
	@DataProvider
	public Object[][] GetData1() throws InvalidFormatException
	{
		
			Object data[][]=ExcelUtil.getTestData(sheetname);
	
		
		return data;
	}
	
	/*
	 * @Test(priority=1, dataProvider="GetData1") public void Registration(String
	 * fname,String lname,String gender,String course,String email,String
	 * verification) { //System.out.println("Regggg");
	 * 
	 * RFC=new RegistrationForm_Class(driver);
	 * //System.out.println(fname+"firstnmae" +gender+"Gendere");
	 * 
	 * TXC=RFC.Register(fname,lname,gender,course,email,verification); String
	 * Transaction=TXC.GetTransaction_ID();
	 * System.out.println(Transaction+"transc id"); TXC.MenuClick();
	 * 
	 * //RFC=TXC.GoToRegistrationform();//This step from transaction page is
	 * excluded//
	 * 
	 * // Step 5: Reinitialize Registration Page object AFTER navigation RFC = new
	 * RegistrationForm_Class(driver);
	 * 
	 * // Step 6: Wait until Registration form is visible again //
	 * RFC.wait.until(ExpectedConditions.visibilityOf(RFC.FirstName));//below is the
	 * another option to wait // new WebDriverWait(driver, Duration.ofSeconds(15))
	 * .until(ExpectedConditions.visibilityOfElementLocated(By.id("vfb-5")));
	 * 
	 * System.out.println("Returned to Registration Page for next dataset"); }
	 */
	
	 
	
	
	@Test(priority=1, dataProvider = "GetData1")
	public void RegistrationFlow(String fname, String lname, String gender,
	                             String course, String email, String verification) throws InterruptedException {

	    // Fill form + Submit → Redirects to Transaction Page
	    TXC = new RegistrationForm_Class(driver)
	             .Register(fname, lname, gender, course, email, verification);

	    // Capture Transaction ID
	    String transactionId = TXC.GetTransaction_ID();
	    System.out.println("Transaction ID for " + fname + ": " + transactionId);
	    
	    //TO set the data in same excel file with different row //
	    int currentrow= ExcelUtil.CurrentRow;
	    ExcelUtil.setCellData(sheetname, currentrow, 6, transactionId);
	    ExcelUtil.CurrentRow++;// This is to increment for each row //

	    // Navigate back to Registration Form
	    RFC = TXC.MenuClick();   // This already waits + returns fresh object

	    System.out.println("Ready for next dataset");
	}
	
	@Test(priority=2)
	public void ProjectDetails_Page()
	{
		PDC =new ProjectDetailsForm_Class(driver);

		PDC=TXC.GoToProjectDetails_Page(); 
		PDC.PageDetails();
	}
	
	 
	/*
	 * @Test(priority=2) public void Test1() { TXC= new
	 * TransactionPage_Class(driver); String Transaction=TXC.GetTransaction_ID();
	 * System.out.println(Transaction+"transc id"); TXC.MenuClick(); }
	 */
	/*
	 * @Test(priority=3) public void ReturntoRegForm() {
	 * RFC=TXC.GoToRegistrationform(); }
	 */


}
