package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.ReportLibrary;
import frameworkLibrary.WebLibrary;

public class Pg105_Dependents {
	WebDriver driver;
	boolean stepstatus;
	public Pg105_Dependents(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//b[text()='My Info']")
    WebElement MyInfo;
	
	@FindBy(how=How.XPATH,using="//a[text()='Dependents']")
    WebElement Dependents;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnAddDependent']")
    WebElement Add;
	
	@FindBy(how=How.XPATH,using="//input[@id='dependent_name']")
    WebElement Name;
	
	@FindBy(how=How.XPATH,using="//select[contains(@id,'relationshipType')]")
    WebElement relationship;
	
	@FindBy(how=How.XPATH,using="//input[@id='dependent_dateOfBirth']")
    WebElement DOB;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnAddAttachment']")
    WebElement Addattachment;
	
		
	public void clickonMyinfo()
	{	
		stepstatus = WebLibrary.clickElement(MyInfo);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Myinfo", "Unable to click on Myinfo");
	}
	
		
	public void Add()
	{	
		stepstatus = WebLibrary.clickElement(Add);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Add", "Unable to click on Add");
	}
	
	public void setname(String strname)
	{	
		stepstatus = WebLibrary.setText(Name, strname);
		ReportLibrary.reportEvent(stepstatus, "Able to enter name", "Unable to enter name");
	}
	
	public void setrelationship(String strrelation)
	{	
		stepstatus = WebLibrary.setText(relationship, strrelation);
		ReportLibrary.reportEvent(stepstatus, "Able to enter relationship", "Unable to enter relationship");
	}
	
	public void setDOB(String strDOB)
	{	
		stepstatus = WebLibrary.setOptionInSelectBox(DOB, strDOB);
		ReportLibrary.reportEvent(stepstatus, "Able to select DOB", "Unable to select DOB");
	}
	
	
	
	
}
