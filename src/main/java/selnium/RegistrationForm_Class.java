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

public class RegistrationForm_Class extends Registration_BaseClass {

	public WebDriver driver;
	public WebDriverWait wait;

	public RegistrationForm_Class(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
	}

	@FindBy(xpath = "//div[@class='vfb-legend']/h3")
	WebElement RegTitle;

	@FindBy(id = "vfb-5")
	WebElement FirstName;

	@FindBy(id = "vfb-7")
	WebElement LastName;

	@FindBy(id = "vfb-14")
	WebElement Email;

	@FindBy(id = "vfb-3")
	WebElement Verification;

	@FindBy(id = "vfb-4")
	WebElement Submit;

	public void SelectGender(String gender) {
		WebElement radio = driver.findElement(By.xpath("//input[@type='radio' and @value='" + gender + "']"));
		if (!radio.isSelected()) {
			wait.until(ExpectedConditions.elementToBeClickable(radio)).click();
		}

	}

	public void SelectCheckbox(String Course) {
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='" + Course + "']"));
		if (!checkbox.isSelected()) {
			wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		}

	}

	public TransactionPage_Class Register(String fname, String lname, String gender, String course, String email,
			String verification) {
		System.out.println(driver.getTitle() + "Title of page");
		wait.until(ExpectedConditions.visibilityOf(FirstName));
		FirstName.clear();
		System.out.println(fname + "frst_name");
		FirstName.sendKeys(fname);
		wait.until(ExpectedConditions.visibilityOf(LastName));

		LastName.clear();
		LastName.sendKeys(lname);
		SelectGender(gender);
		System.out.println(gender + "Gndrrr");

		SelectCheckbox(course);
		System.out.println(course + "Coursss");
		wait.until(ExpectedConditions.visibilityOf(Email));

		Email.clear();
		Email.sendKeys(email);

		wait.until(ExpectedConditions.visibilityOf(Verification));

		Verification.clear();
		Verification.sendKeys(verification);
		// wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Submit);
		//wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();
		// Submit.click();
		
		 try { wait.until(ExpectedConditions.elementToBeClickable(Submit)).click(); }
		 catch (ElementClickInterceptedException e) {
		 System.out.println("Normal click failed, trying JS click");
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Submit);
		  } 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='messageContainer']")));
		return new TransactionPage_Class(driver);
	}

	public void Test() {
		System.out.println(driver.getTitle() + "Testsss");
	}

}
