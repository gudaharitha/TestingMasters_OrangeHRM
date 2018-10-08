package testScripts;

import org.testng.annotations.Test;
import applicationPages.Pg101_Login;
import applicationPages.Pg102_Homepage;
import applicationPages.Pg103_contactdetails;
import frameworkLibrary.DataLibrary;
import frameworkLibrary.DriverClass;

public class Module1_contactdetails extends DriverClass
{
	@Test
	public void TC101_ContactDetails_EditValuesAndSave()
	{
		Pg101_Login login = new Pg101_Login(driver);
		Pg102_Homepage home = new Pg102_Homepage(driver);
		Pg103_contactdetails contacts = new Pg103_contactdetails(driver);
		login.setUsername("ankit3");
		login.setpassword("abcd1234");
		login.clickonLogin();
		home.clickonMyInfo();
		home.clickonContactDetails1();
		contacts.clickonEdit();
		contacts.setAddressline1("sriLaxmi Nilayam");
		contacts.setAddressline2("road number2");
		contacts.setcity("hyderabad");
		contacts.setstate("Telangana");
		contacts.setpostal("500037");
		contacts.setcountry("India");
		contacts.sethomeTelephone("123456789");
		contacts.setMobile("9998887776");
		contacts.setworktelephone("987654312");
		contacts.setworkemail("adcdef@gmail.com");
		contacts.setotheremail("efdcba@gmail.com");
		contacts.clickonsave();
		home.clickonwelcome();
		home.clickonlogout();
		
}
}
