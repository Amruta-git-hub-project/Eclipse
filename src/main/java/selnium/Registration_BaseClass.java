package selnium;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class Registration_BaseClass {

public static WebDriver driver;
	

	public void Setup()
	{	
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver-win64/chromedriver.exe");
		//driver=new ChromeDriver(); 
		ChromeOptions options = new ChromeOptions();

        // Create a HashMap to store preferences
        Map<String, Object> prefs = new HashMap<>();
        // Disable the password manager service
        prefs.put("credentials_enable_service", false); 

        // Disable the password manager's UI
        prefs.put("profile.password_manager_enabled", false); 

     // Disable password leak detection (this can also trigger prompts)
        prefs.put("profile.password_manager_leak_detection", false);
        
        // Apply the preferences to ChromeOptions
        options.setExperimentalOption("prefs", prefs);  

        // Initialize ChromeDriver with the configured options
        driver=new ChromeDriver(options); 
        
		//driver.get("https://www.saucedemo.com/v1/index.html");  
		driver.get("https://vinothqaacademy.com/demo-site/"); 
	//----URL:Refer this-	https://vinothqaacademy.com/demo-site// 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		System.out.println("Setup");
		
	}
	
	 

	
	public RegistrationForm_Class DemoRegistration()
	{
		return PageFactory.initElements(driver, RegistrationForm_Class.class);
	}
}
