package frameworkLibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebLibrary
{
	public static Exception ExceptionDescription;
	public static boolean launchBrowser(String BrowserName)
	{
		boolean stepstatus = false;
		WebDriver driver = null;
		switch (BrowserName.toLowerCase()) 
		{
			case "chrome": 
				{
					System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
					driver = new ChromeDriver();
					stepstatus= true;
					break;
				}
			case "ie":
			case "internetexplorer": 
				{
					System.setProperty("webdriver.ie.driver", "BrowserServers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					stepstatus= true;
					break;
				}
			case "firefox": 
			{
				boolean firefoxinvoked = false;
				try 
				{
					driver = new FirefoxDriver();
					firefoxinvoked = true;
					stepstatus= true;
				} catch (Exception e) 
				{
					firefoxinvoked = false;
				}
				if (firefoxinvoked == false) 
				{
					System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
					driver = new FirefoxDriver();
					stepstatus= true;
				}
				break;
			}
			default: 
				{
					System.out.println("please Select the correct browser");
					stepstatus= false;
				}
		}
		DriverClass.driver = driver;
		return stepstatus;
	}
	
	public static boolean launchApplication(String URL) 
	{
		boolean stepstatus;
		try 
		{
			DriverClass.driver.get(URL);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			ExceptionDescription = e;
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean setText(WebElement ele, String StrValue
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			) 
	{	boolean stepstatus;
		try
		{
			WebLibrary.waitForPageToLoad();
			ele.click();
			ele.clear();
			ele.sendKeys(StrValue);
			stepstatus = true;
		} catch (Exception e) 
		{
			ExceptionDescription = e;
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean clickElement(WebElement ele) 
	{
		boolean stepstatus;
		try
		{
			WebLibrary.waitForPageToLoad();
			ele.click();
			stepstatus = true;
		} 
		catch (Exception e)
		{
			ExceptionDescription = e;
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean setOptionInSelectBox(WebElement ele, String eleOption) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			new Select(ele).selectByVisibleText(eleOption);
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean setCheckBox(WebElement ele, String ONorOFF) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			switch (ONorOFF.toLowerCase()) 
			{
				case "on":
					if(!ele.isSelected())
					{
						ele.click();
					}
					stepstatus = true;
					break;
				case "off":
					if(ele.isSelected())
					{
						ele.click();
					}
					stepstatus = true;
					break;
				default:
					stepstatus = false;
					break;
			}
			
		} 
		catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	
	public static String getLinkText(WebElement ele) 
	{
		String value = "";
		try 
		{
			WebLibrary.waitForPageToLoad();
			if(exists(ele))
			{
				value=ele.getText();
			}
		} catch (Exception e) 
		{
			value = "";
		}
		return value;
	}
	
	public static String getAttributeValue(WebElement ele,String AttributeName) 
	{
		String value = "";
		try 
		{
			WebLibrary.waitForPageToLoad();
			if(exists(ele))
			{
				value=ele.getAttribute(AttributeName);
			}
		} catch (Exception e) 
		{
			value = "";
		}
		return value;
	}
	
	public  static void waitForPageToLoad() 
	{
		String pageLoadStatus;
		do 
		{
	    	JavascriptExecutor js = (JavascriptExecutor)DriverClass.driver;
	        pageLoadStatus = (String)js.executeScript("return document.readyState");
	    } while (!pageLoadStatus.equals("complete") );
	}
	
	public static boolean exists(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			stepstatus = ele.isDisplayed();
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean isEnabled(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			stepstatus = ele.isEnabled();
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean isSelected(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			stepstatus = ele.isSelected();
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean mouseHover(WebElement ele) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Actions a1 = new Actions(DriverClass.driver);
			a1.moveToElement(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean rightClick(WebElement ele) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Actions a1 = new Actions(DriverClass.driver);
			a1.contextClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean doubleClick(WebElement ele) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Actions a1 = new Actions(DriverClass.driver);
			a1.doubleClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean dragAndDrop(WebElement drag, WebElement drop) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Actions a1 = new Actions(DriverClass.driver);
			a1.dragAndDrop(drag, drop);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean JsclickElement(WebElement ele) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			JavascriptExecutor js = (JavascriptExecutor) DriverClass.driver;
			js.executeScript("arguments[0].click();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean JssetText(WebElement ele, String StrValue) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			JavascriptExecutor js = (JavascriptExecutor) DriverClass.driver;
			js.executeScript("arguments[0].value='" + StrValue + ";", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean JsScrollToWebElement(WebElement ele) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			JavascriptExecutor js = (JavascriptExecutor) DriverClass.driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean acceptAlert(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			DriverClass.driver.switchTo().alert().accept();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	
	public static boolean dismissAlert(WebElement ele) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			DriverClass.driver.switchTo().alert().dismiss();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean alertExist(WebElement ele) {
		boolean stepstatus;
		try 
		{
			WebLibrary.waitForPageToLoad();
			DriverClass.driver.switchTo().alert();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static String alertGetText(WebElement ele) {
		String StrValue = "";
		try 
		{
			WebLibrary.waitForPageToLoad();
			Alert a1 = DriverClass.driver.switchTo().alert();
			StrValue = a1.getText();
		} catch (Exception e) {

		}
		return StrValue;
	}

	public static boolean isWindowExistsByURL(String URL)
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Set<String> allhandles = DriverClass.driver.getWindowHandles();
			for (String handle : allhandles) {
				DriverClass.driver.switchTo().window(handle);
				String CurrentURL = DriverClass.driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean isWindowExistsByTitle(String Title) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Set<String> allhandles = DriverClass.driver.getWindowHandles();
			for (String handle : allhandles) {
				DriverClass.driver.switchTo().window(handle);
				String CurrentURL = DriverClass.driver.getTitle();
				if (CurrentURL.contains(Title)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean SwitchtoWindowByURL(String URL) 
	{
		boolean stepstatus = false;
		try {
			WebLibrary.waitForPageToLoad();
			Set<String> allhandles = DriverClass.driver.getWindowHandles();
			for (String handle : allhandles) {
				DriverClass.driver.switchTo().window(handle);
				String CurrentURL = DriverClass.driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) 
				{
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus= false;
		}
		return stepstatus;
	}

	public static boolean SwitchtoWindowByTitle(String Title) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Set<String> allhandles = DriverClass.driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				DriverClass.driver.switchTo().window(handle);
				String CurrentURL = DriverClass.driver.getTitle();
				if (CurrentURL.contains(Title)) 
				{
					stepstatus= true;
					break;
				}
			}
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean closeWindowByURL(String URL) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Set<String> allhandles = DriverClass.driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				DriverClass.driver.switchTo().window(handle);
				String CurrentURL = DriverClass.driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) 
				{
					DriverClass.driver.close();
					stepstatus = true;
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean closeWindowByTitle(String Title) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			Set<String> allhandles = DriverClass.driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				DriverClass.driver.switchTo().window(handle);
				String CurrentURL = DriverClass.driver.getTitle();
				if (CurrentURL.contains(Title)) 
				{
					DriverClass.driver.close();
					stepstatus = true;
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean SwitchtoFrameByElementReference(WebElement FrameRef) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			DriverClass.driver.switchTo().frame(FrameRef);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean SwitchtoFrameByName(String FrameName) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			DriverClass.driver.switchTo().frame(FrameName);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean SwitchtoFrameByIndex(int FrameIndex) 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			DriverClass.driver.switchTo().frame(FrameIndex);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean SwitchtoMainDocument() 
	{
		boolean stepstatus = false;
		try 
		{
			WebLibrary.waitForPageToLoad();
			DriverClass.driver.switchTo().defaultContent();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean RobotKeysFileUpload(String Filepath) {
		boolean stepstatus;
		try {
			WebLibrary.waitForPageToLoad();
			StringSelection selection = new StringSelection(Filepath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);

			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);

			wait(2);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			wait(2);
			WebLibrary.waitForPageToLoad();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
		}
		return stepstatus;
	}

	public static boolean wait(int timeInSec) {
		boolean stepStatus;
		try 
		{
			Thread.sleep(timeInSec * 1000);
			stepStatus = true;
		} catch (Exception e) {
			stepStatus = false;
		}
		return stepStatus;
	}

	public static boolean dynamicWait(By by, int waittimeinsec) 
	{
		boolean status = false;
		int counter = 0;
		while (counter <= waittimeinsec) {
			try {
				DriverClass.driver.findElement(by);
				status = true;
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (Exception e1) {

				}
				counter = counter + 1;
			}
		}
		if (counter > waittimeinsec) {
			status = false;
		}
		return status;
	}

	public static void SetImplicitWait(int TimeInSec) {
		try 
		{
			DriverClass.driver.manage().timeouts().implicitlyWait(TimeInSec, TimeUnit.SECONDS);
		} catch (Exception e) {
		}
	}
	
	public static boolean quitdriver()
	{
		boolean stepstatus = false;
		try
		{
			WebLibrary.waitForPageToLoad();
			DriverClass.driver.quit();
			stepstatus= true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
}
