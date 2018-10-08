package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.DataLibrary;
import frameworkLibrary.ReportLibrary;
import frameworkLibrary.WebLibrary;

public class Pg101_Login {

	WebDriver driver;
	boolean stepstatus;
	public Pg101_Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='txtUsername']")
    WebElement Username;
	
	@FindBy(how=How.XPATH,using="//input[@id='txtPassword']")
    WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@name='Submit']")
    WebElement Login;
	
	@FindBy(how=How.XPATH,using="//a[@id='welcome']")
    WebElement welcome;
	
	@FindBy(how=How.XPATH,using="//a[text()='Logout']")
    WebElement Logout;
	
		
	public void setUsername(String strUsername)
	{
		stepstatus = WebLibrary.setText(Username, strUsername);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Username", "Unable to enter Username");
	}
	
	public void setpassword(String strpassword)
	{
		stepstatus = WebLibrary.setText(password, strpassword);
		ReportLibrary.reportEvent(stepstatus, "Able to enter password", "Unable to enter password");
	}
	
	public void clickonLogin()
	{
		stepstatus = WebLibrary.clickElement(Login);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Login", "Unable to click on Login",true);
	}
	
	public void clickonwelcome()
	{	
		stepstatus = WebLibrary.clickElement(welcome);
		ReportLibrary.reportEvent(stepstatus, "Able to click on welcome", "Unable to click on welcome");
	}
	
	public void clickonLogout()
	{	
		stepstatus = WebLibrary.clickElement(Logout);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Logout", "Unable to click on Logout");
	}
	
	
}
	
	