package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.ReportLibrary;
import frameworkLibrary.WebLibrary;

public class Pg102_Homepage 
{
	WebDriver driver;
	boolean stepstatus;
	public Pg102_Homepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//b[text()='My Info']")
    WebElement MyInfo;
	
	@FindBy(how=How.XPATH,using="//a[text()='Contact Details']")
    WebElement contactdetails;
	
	@FindBy(how=How.XPATH,using="//a[text()='Emergency Contacts']")
    WebElement Emergencycontacts;
	
	@FindBy(how=How.XPATH,using="//a[text()='Dependents']")
    WebElement Dependents;
	
	@FindBy(how=How.XPATH,using="//a[text()='Immigration']")
    WebElement Immigration;
	
	@FindBy(how=How.XPATH,using="//a[text()='Qualifications']")
    WebElement Qualifications;
	
	@FindBy(how=How.XPATH,using="//a[@id='welcome']")
    WebElement welcome;
	
	@FindBy(how=How.XPATH,using="//a[text()='Logout']")
    WebElement Logout;
	
	public void clickonMyInfo()
	{	
		stepstatus = WebLibrary.clickElement(MyInfo);
		ReportLibrary.reportEvent(stepstatus, "Able to click on My Info", "Unable to click on My Info");
	}
	
	public void clickonContactDetails1()
	{	
		stepstatus = WebLibrary.clickElement(contactdetails);
		ReportLibrary.reportEvent(stepstatus, "Able to click on contact", "Unable to click on contact");
	}
	
	public void clickonEmergencycontacts()
	{	
		stepstatus = WebLibrary.clickElement(Emergencycontacts);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Emergency contacts", "Unable to click on Emergency contacts");
	}
	
	
	public void clickonDependents()
	{	
		stepstatus = WebLibrary.clickElement(Dependents);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Dependents", "Unable to click on Dependents");
	}
	
	public void clickonImmigration()
	{	
		stepstatus = WebLibrary.clickElement(Immigration);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Immigration", "Unable to click on Immigration");
	}
	
	public void clickonQualifications()
	{	
		stepstatus = WebLibrary.clickElement(Qualifications);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Qualifications", "Unable to click on Qualifications");
	}
	
	public void clickonwelcome()
	{	
		stepstatus = WebLibrary.clickElement(welcome);
		ReportLibrary.reportEvent(stepstatus, "Able to click on welcome", "Unable to click on welcome");
	}
	
	public void clickonlogout()
	{	
		WebLibrary.waitForPageToLoad();
		stepstatus = WebLibrary.clickElement(Logout);
		ReportLibrary.reportEvent(stepstatus, "Able to click on logout", "Unable to click on logout",true);
	}

}
