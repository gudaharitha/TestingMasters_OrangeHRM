package frameworkLibrary;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class DriverClass 
{
	public static WebDriver driver = null;
	public static String DataFilesPath = "DataFiles";
	public static String CurrentTestCaseName = "";
	public static String CurrentModuleName = "";
	public static String CurrentFolderPath= "";
	
	@BeforeSuite
	public void beforesuite()
	{
		ReportLibrary.CreateNewExtentReportInResultsFolderWithDateAndTimeStamp();
	}
	
	@BeforeMethod
	public void beforemethod(Method currentmethod)
	{
		CurrentTestCaseName = currentmethod.getName();
		CurrentModuleName = currentmethod.getDeclaringClass().getSimpleName();
		
		DataLibrary.CurrentTestData = DataLibrary.loadDataFromExceltoHashMap(CurrentTestCaseName, CurrentModuleName);
		DataLibrary.loadDataFromJsontoHashMap();
		
		ReportLibrary.startExtentTestForCurrentTestCase();
		
		WebLibrary.launchBrowser(DataLibrary.CurrentTestData.get("BrowserName"));
		WebLibrary.launchApplication(DataLibrary.CurrentTestData.get("BaseURL"));
	}
	
	@AfterMethod
	public void aftermethod()
	{
		ReportLibrary.endExtentTestForCurrentTestCase();
		DataLibrary.loadDataFromHashMaptoExcel(CurrentTestCaseName, CurrentModuleName);
		
		if (ReportLibrary.CloseBrowser) WebLibrary.quitdriver();
	}
	
	@AfterSuite
	public void aftersuite()
	{
		ReportLibrary.closeExtentReport();
		ReportLibrary.LaunchReport();
	}
}
