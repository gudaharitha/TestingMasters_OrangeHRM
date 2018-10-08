package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.ReportLibrary;
import frameworkLibrary.WebLibrary;

public class Pg104_EmergencyContacts {
	WebDriver driver;
	boolean stepstatus;
	public Pg104_EmergencyContacts(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(how=How.XPATH,using="//input[@id='btnAddContact']")
    WebElement Addbutton;
	
	@FindBy(how=How.XPATH,using="//input[@id='emgcontacts_name']")
    WebElement name;
	
	@FindBy(how=How.XPATH,using="//input[@id='emgcontacts_relationship']")
    WebElement relationship;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'homePhone')]")
    WebElement homephone;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'mobilePhone')]")
    WebElement mobilephone;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'workPhone')]")
    WebElement workphone;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnSaveEContact']")
    WebElement save;
	
	@FindBy(how=How.XPATH,using="//a[@id='welcome']")
    WebElement welcome;
	
	@FindBy(how=How.XPATH,using="//a[text()='Logout']")
    WebElement Logout;
	
	public void clickAdd()
	{	
		stepstatus = WebLibrary.clickElement(Addbutton);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Add", "Unable to click on Add");
	}
	
	public void setname(String Strname)
	{	
		stepstatus = WebLibrary.setText(name, Strname);
		ReportLibrary.reportEvent(stepstatus, "Able to enter name", "Unable to enter name");
	}
	
	public void setrelationship(String Strrelationship)
	{	
		stepstatus = WebLibrary.setText(relationship, Strrelationship);
		ReportLibrary.reportEvent(stepstatus, "Able to enter relationship", "Unable to enter relationship");
	}
	
	public void setHomephone(String strhomephone)
	{	
		stepstatus = WebLibrary.setText(homephone, strhomephone);
		ReportLibrary.reportEvent(stepstatus, "Able to enter homephone number", "Unable to enter homephone number");
	}
	
	public void setmobile(String strmobile)
	{	
		stepstatus = WebLibrary.setText(mobilephone, strmobile);
		ReportLibrary.reportEvent(stepstatus, "Able to enter mobile number", "Unable to enter mobile number");
	}
	
	public void setworkphone(String strworkphone)
	{	
		stepstatus = WebLibrary.setText(workphone, strworkphone);
		ReportLibrary.reportEvent(stepstatus, "Able to enter workphone number", "Unable to enter workphone number");
	}
	
	public void clickonsave()
	{	
		stepstatus = WebLibrary.clickElement(save);
		ReportLibrary.reportEvent(stepstatus, "Able to click on save", "Unable to click on save");
	}
	
	
	

}
