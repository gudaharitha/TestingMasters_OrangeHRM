package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.ReportLibrary;
import frameworkLibrary.WebLibrary;

public class Pg106_Immigration
{
	WebDriver driver;
	boolean stepstatus;
	public Pg106_Immigration(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		
	@FindBy(how=How.XPATH,using="//input[@id='btnAdd']")
    WebElement Add;
	
	@FindBy(how=How.XPATH,using="//label[text()='Passport']/preceding-sibling::input")
    WebElement Document;
	
	@FindBy(how=How.XPATH,using="//input[@id='immigration_number']")
    WebElement number;
	
	@FindBy(how=How.XPATH,using="//input[@id='immigration_passport_issue_date']")
    WebElement issueddate;
	
	@FindBy(how=How.XPATH,using="//input[@id='immigration_passport_expire_date']")
    WebElement expireddate;
	
	@FindBy(how=How.XPATH,using="//input[@id='immigration_i9_status']")
    WebElement status;
	
	
	@FindBy(how=How.XPATH,using="//select[@id='immigration_country']")
    WebElement Issuedby;
	
	@FindBy(how=How.XPATH,using="//input[@id='immigration_i9_review_date']")
    WebElement Reviewdate;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='immigration_comments']")
    WebElement comments;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnSave']")
    WebElement save;
	
	@FindBy(how=How.XPATH,using="//table[@class='table hover']/tbody/tr/td[1]/input[@type='checkbox']")
    WebElement selectrecord;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnDelete']")
    WebElement Delete;
	
	public void clickonAdd()
	{	
		stepstatus = WebLibrary.clickElement(Add);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Add", "Unable to click on Add");
	}
	
	public void clickonDocument()
	{	
		stepstatus = WebLibrary.clickElement(Document);
		ReportLibrary.reportEvent(stepstatus, "Able to select document type", "Unable to select document type");
	}
	
	public void setnumber(String strnumber)
	{	
		stepstatus = WebLibrary.setText(number, strnumber);
		ReportLibrary.reportEvent(stepstatus, "Able to enter number", "Unable to enter number");
	}
	
	public void setIssueddate(String strIssueddate)
	{	
		stepstatus = WebLibrary.setText(issueddate, strIssueddate);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Issued date", "Unable to enter Issued date");
	}
	
	public void setexpirydate(String strexpirydate)
	{	
		stepstatus = WebLibrary.setText(expireddate, strexpirydate);
		ReportLibrary.reportEvent(stepstatus, "Able to enter expiry date", "Unable to enter expiry date");
	}
	
	public void setstatus(String strstatus)
	{	
		stepstatus = WebLibrary.setText(status, strstatus);
		ReportLibrary.reportEvent(stepstatus, "Able to enter status", "Unable to enter status");
	}
	
	public void setIssuedby(String strIssuedby)
	{	
		stepstatus = WebLibrary.setText(Issuedby, strIssuedby);
		ReportLibrary.reportEvent(stepstatus, "Able to enter status", "Unable to enter status");
	}
	
	public void Reviewdate(String strreviewdate)
	{	
		stepstatus = WebLibrary.setText(Reviewdate, strreviewdate);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Review date", "Unable to enter Review date");
	}
	
	public void setcomments(String strcomments)
	{	
		stepstatus = WebLibrary.setText(comments, strcomments);
		ReportLibrary.reportEvent(stepstatus, "Able to enter comments", "Unable to enter comments");
	}
	
	public void clickonsave()
	{	
		stepstatus = WebLibrary.clickElement(save);
		ReportLibrary.reportEvent(stepstatus, "Able to click on save", "Unable to click on save");
	}
	
	public void clickonrecord()
	{	
		stepstatus = WebLibrary.clickElement(selectrecord);
		ReportLibrary.reportEvent(stepstatus, "Able to select record", "Unable to select record");
	}
	
	public void clickondelete()
	{	
		stepstatus = WebLibrary.clickElement(Delete);
		ReportLibrary.reportEvent(stepstatus, "Able to click on delete", "Unable to click on delete");
	}
}
