package testScripts;

import org.testng.annotations.Test;

import applicationPages.Pg101_Login;
import applicationPages.Pg102_Homepage;
import applicationPages.Pg104_EmergencyContacts;
import frameworkLibrary.DriverClass;

public class Module2_Emergencycontacts extends DriverClass {
	@Test
	public void TC101_ContactDetails_EditValuesAndSave()
	{
		Pg101_Login login = new Pg101_Login(driver);
		Pg102_Homepage home = new Pg102_Homepage(driver);
		Pg104_EmergencyContacts Emergencycontacts = new Pg104_EmergencyContacts(driver);
		login.setUsername("ankit3");
		login.setpassword("abcd1234");
		login.clickonLogin();
		home.clickonMyInfo();
		home.clickonEmergencycontacts();
		Emergencycontacts.clickAdd();
		Emergencycontacts.setname("swapnika");
		Emergencycontacts.setrelationship("friend");
		Emergencycontacts.setHomephone("987543210");
		Emergencycontacts.setmobile("9988776655");
		Emergencycontacts.setworkphone("122343436");
		Emergencycontacts.clickonsave();
		home.clickonwelcome();
		home.clickonlogout();

}
}
