package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.ReportLibrary;
import frameworkLibrary.WebLibrary;

public class Pg107_Qualification 
{
	WebDriver driver;
	boolean stepstatus;
	public Pg107_Qualification(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		
	@FindBy(how=How.XPATH,using="//input[@id='addWorkExperience']")
    WebElement Addwork;
	
	@FindBy(how=How.XPATH,using="//input[@id='experience_employer']")
    WebElement company;
	
	@FindBy(how=How.XPATH,using="//input[@id='experience_jobtitle']")
    WebElement Jobtitle;
	
	@FindBy(how=How.XPATH,using="//input[@id='experience_from_date']")
    WebElement fromdate;
	
	@FindBy(how=How.XPATH,using="//input[@id='experience_to_date']")
    WebElement todate;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='experience_comments']")
    WebElement experiencecomments;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnWorkExpSave']")
    WebElement save;
	
	@FindBy(how=How.XPATH,using="//input[@id='addEducation']")
    WebElement AddEDU;
	
	@FindBy(how=How.XPATH,using="//select[@id='education_code']")
    WebElement levelEdu;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_institute']")
    WebElement Institute;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_major']")
    WebElement specialization;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_year']")
    WebElement year;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_gpa']")
    WebElement GPA;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_start_date']")
    WebElement startdate;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_end_date']")
    WebElement enddate;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnEducationSave']")
    WebElement Edusave;
	
	@FindBy(how=How.XPATH,using="//input[@id='addSkill']")
    WebElement skill;
	
	@FindBy(how=How.XPATH,using="//select[@id='skill_code']")
    WebElement selectskill;
	
	@FindBy(how=How.XPATH,using="//input[@id='skill_years_of_exp']")
    WebElement Experience;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='skill_comments']")
    WebElement skillcomments;
	
	@FindBy(how=How.XPATH,using="//input[@id='addLanguage']")
    WebElement Addlanguage;
	
	@FindBy(how=How.XPATH,using="//select[@id='language_code']")
    WebElement languagecode;
	
	@FindBy(how=How.XPATH,using="//select[@id='language_lang_type']")
    WebElement Fluency;
	
	@FindBy(how=How.XPATH,using="//select[@id='language_competency']")
    WebElement competency;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='language_comments']")
    WebElement comment_language;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnLanguageSave']")
    WebElement save_language;
	
	@FindBy(how=How.XPATH,using="//input[@id='addLicense']")
    WebElement License;
	
	@FindBy(how=How.XPATH,using="//select[@id='license_code']")
    WebElement LicenseType;
	
	@FindBy(how=How.XPATH,using="//input[@id='license_license_no']")
    WebElement Licencenumber;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='license_date']")
    WebElement LicenseIssueddate;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='license_date']")
    WebElement LicenseExpirydate;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnLicenseSave']")
    WebElement Licensesave;
	
	public void clickonAdd()
	{	
		stepstatus = WebLibrary.clickElement(Addwork);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Addwork", "Unable to click on Addwork");
	}
	
	public void setcompanyname(String strcompany)
	{	
		stepstatus = WebLibrary.setText(company, strcompany);
		ReportLibrary.reportEvent(stepstatus, "Able to enter company name", "Unable to enter company name");
	}
	
	public void setjobtitle(String strjob)
	{	
		stepstatus = WebLibrary.setText(Jobtitle, strjob);
		ReportLibrary.reportEvent(stepstatus, "Able to enter job title", "Unable to enter job title");
	}
	
	public void setfromdate(String strfromdate)
	{	
		stepstatus = WebLibrary.setText(fromdate, strfromdate);
		ReportLibrary.reportEvent(stepstatus, "Able to enter from date", "Unable to enter from date");
	}
	
	public void settodate(String strtodate)
	{	
		stepstatus = WebLibrary.setText(todate, strtodate);
		ReportLibrary.reportEvent(stepstatus, "Able to enter to date", "Unable to enter to date");
	}
	
	public void setcomments(String strcomments)
	{	
		stepstatus = WebLibrary.setText(experiencecomments, strcomments);
		ReportLibrary.reportEvent(stepstatus, "Able to enter comments", "Unable to enter comments");
	}
	
	public void clickonsave()
	{	
		stepstatus = WebLibrary.clickElement(save);
		ReportLibrary.reportEvent(stepstatus, "Able to click on save", "Unable to click on save");
	}
	
	public void clickonAddEdu1()
	{	
		stepstatus = WebLibrary.clickElement(AddEDU);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Addwork", "Unable to click on Addwork");
	}
	
	public void setlevel(String strlevel)
	{	
		stepstatus = WebLibrary.setText(levelEdu, strlevel);
		ReportLibrary.reportEvent(stepstatus, "Able to select edu level", "Unable to select edu level");
	}
	
	public void setInstname(String strInstname)
	{	
		stepstatus = WebLibrary.setText(Institute, strInstname);
		ReportLibrary.reportEvent(stepstatus, "Able to enter Institute name", "Unable to enter Institute name");
	}
	
	public void setspecialization(String strspecialization)
	{	
		stepstatus = WebLibrary.setText(specialization, strspecialization);
		ReportLibrary.reportEvent(stepstatus, "Able to enter specialization", "Unable to enter specialization");
	}
	
	public void setpassedyear(String stryear)
	{	
		stepstatus = WebLibrary.setText(year, stryear);
		ReportLibrary.reportEvent(stepstatus, "Able to enter passed year", "Unable to enter passes year");
	}
	
	public void setStartdate(String strstartdate)
	{	
		stepstatus = WebLibrary.setText(startdate, strstartdate);
		ReportLibrary.reportEvent(stepstatus, "Able to enter start date", "Unable to enter start date");
	}
	
	public void setenddate(String strenddate)
	{	
		stepstatus = WebLibrary.setText(enddate, strenddate);
		ReportLibrary.reportEvent(stepstatus, "Able to enter end date", "Unable to enter end date");
	}
	
	public void clickonedusave()
	{	
		stepstatus = WebLibrary.clickElement(Edusave);
		ReportLibrary.reportEvent(stepstatus, "Able to click on save", "Unable to click on save");
	}
	
	public void clickonskills()
	{	
		stepstatus = WebLibrary.clickElement(skill);
		ReportLibrary.reportEvent(stepstatus, "Able to click on skill", "Unable to click on skill");
	}
	
	public void setselectskill(String strselectskill)
	{	
		stepstatus = WebLibrary.setText(selectskill, strselectskill);
		ReportLibrary.reportEvent(stepstatus, "Able to select skills", "Unable to select skills");
	}
	
	public void setExperience(String strexperience)
	{	
		stepstatus = WebLibrary.setText(Experience, strexperience);
		ReportLibrary.reportEvent(stepstatus, "Able to enter experience", "Unable to enter experience");
	}
	
	public void setcommentsonskills(String strcommentsskills)
	{	
		stepstatus = WebLibrary.setText(skillcomments, strcommentsskills);
		ReportLibrary.reportEvent(stepstatus, "Able to enter comments", "Unable to enter comments");
	}
	
	public void clickonskillsave()
	{	
		stepstatus = WebLibrary.clickElement(save);
		ReportLibrary.reportEvent(stepstatus, "Able to clik on save", "Unable to click on save");
	}
	
	public void clickonAddlanguage()
	{	
		stepstatus = WebLibrary.clickElement(Addlanguage);
		ReportLibrary.reportEvent(stepstatus, "Able to click on Add language", "Unable to click on Add languages");
	}
	
	public void setGPA(String strGPA)
	{	
		stepstatus = WebLibrary.setText(GPA, strGPA);
		ReportLibrary.reportEvent(stepstatus, "Able to enter GPA score", "Unable to enter GPA score");
	}
	
	public void setGPA1(String strGPA)
	{	
		stepstatus = WebLibrary.setText(GPA, strGPA);
		ReportLibrary.reportEvent(stepstatus, "Able to enter GPA score", "Unable to enter GPA score");
	}
	
	
	
	
	
	

}
