package selnium;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestUtil.ExcelUtil;

public class Demo_Login_Test extends Demo_BaseClass {
	DemoguruLogin_Class DC;
	DemoRegistration_Class DR;
	Add_NewCustomer_Class AC;
	String sheetname="Contacts"; 
	
	
	public Demo_Login_Test()
	{
		super();
	}
	
	@BeforeTest() 
	public void OpenURL() 
	{
		Demo_BaseClass DB= new Demo_BaseClass();
		DB.Setup();
		DC=DB.DemoLogin();
 
	} 
	
	@Parameters({"username","password"})
	@Test(priority=1)
	public void LoginPage(String username, String password)
	{
		DC.Login(username, password);
		DR=DC.GotoDashboard();	 

		AC=DR.NewCustomer_Page();
		AC.AddTitle();
	}
	
	@DataProvider
	public Object[][] GetData() throws InvalidFormatException
	{
		
			Object data[][]=ExcelUtil.getTestData(sheetname);
	
		
		return data;
	}
	  
	@Test ( priority=2, dataProvider="GetData")
	public void CreateContactPage(String CustName, String Add, String dob, String city, String state, String PIN, String email) 
	{
		System.out.println(Add+"Add");
		AC=new Add_NewCustomer_Class(driver); 
		AC.Add_Customer(CustName, Add, dob, city,state,PIN,email);
	} 
	
}
