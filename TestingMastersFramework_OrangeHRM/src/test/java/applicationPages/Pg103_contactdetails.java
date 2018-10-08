package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.ReportLibrary;
import frameworkLibrary.WebLibrary;

public class Pg103_contactdetails {
	
	WebDriver driver;
	boolean stepstatus;
	public Pg103_contactdetails(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@id='btnSave']")
    WebElement Edit;
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_street1']")
    WebElement Addressline1;
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_street2']")
    WebElement Addressline2;
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_city']")
    WebElement city;
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_province']")
    WebElement state;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'zipcode')]")
    WebElement zipcode;
	
	@FindBy(how=How.XPATH,using="//select[@id='contact_country']")
    WebElement country;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'hm_telephone')]")
    WebElement hometelephone;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'emp_mobile')]")
    WebElement empmobile;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'work_telephone')]")
    WebElement workmobile;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'work_email')]")
    WebElement workemail;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'oth_email')]")
    WebElement otheremail;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnSave']")
    WebElement save;
	
			
	public void clickonEdit()
	{	
		stepstatus = WebLibrary.clickElement(Edit);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Edit", "Unable to click on Edit");
	}
	
	public void setAddressline1(String strLine1)
	{	
		stepstatus = WebLibrary.setText(Addressline1, strLine1);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Addressline1", "Unable to enter Addressline1");
	}
	
	public void setAddressline2(String strLine2)
	{	
		stepstatus = WebLibrary.setText(Addressline2, strLine2);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Addressline2", "Unable to enter Addressline2");
	}
	
	public void setcity(String strcity)
	{	
		stepstatus = WebLibrary.setText(city, strcity);
		ReportLibrary.reportEvent(stepstatus, "Able to enter cityname", "Unable to enter cityname");
	}
	
	public void setstate(String strstate)
	{	
		stepstatus = WebLibrary.setText(state, strstate);
		ReportLibrary.reportEvent(stepstatus, "Able to enter statename", "Unable to enter statename");
	}
	
	public void setpostal(String strpostal)
	{	
		stepstatus = WebLibrary.setText(zipcode, strpostal);
		ReportLibrary.reportEvent(stepstatus, "Able to enter postalcode", "Unable to enter postalcode");
	}
	
	public void setcountry(String strcountry)
	{	
		stepstatus = WebLibrary.setOptionInSelectBox(country, strcountry);
		ReportLibrary.reportEvent(stepstatus, "Able to enter countryname", "Unable to enter countryname");
	}
	
	public void sethomeTelephone(String hm_telephone)
	{	
		stepstatus = WebLibrary.setText(hometelephone, hm_telephone);
		ReportLibrary.reportEvent(stepstatus, "Able to home telephone number", "Unable to enter homr telephone number");
	}
	
	public void setMobile(String strMobile)
	{	
		stepstatus = WebLibrary.setText(empmobile, strMobile);
		ReportLibrary.reportEvent(stepstatus, "Able to enter mobile number", "Unable to enter mobile number");
	}
	
	public void setworktelephone(String strtelephone)
	{	
		stepstatus = WebLibrary.setText(workmobile, strtelephone);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Username", "Unable to enter Username");
	}
	
	public void setworkemail(String strmail)
	{	
		stepstatus = WebLibrary.setText(workemail, strmail);
		ReportLibrary.reportEvent(stepstatus, "Able to enter work email", "Unable to enter work email");
	}
	
	public void setotheremail(String strotheremail)
	{	
		stepstatus = WebLibrary.setText(otheremail, strotheremail);
		ReportLibrary.reportEvent(stepstatus, "Able to enter other email", "Unable to enter other email");
	}
	
	public void clickonsave()
	{	
		stepstatus = WebLibrary.clickElement(save);
		ReportLibrary.reportEvent(stepstatus, "Able to click on save", "Unable to click on save");
	}
	
		
	
	
}


































































































































































































































































































































































































































































































































































































































































































































































//contact details
//emergency contacts