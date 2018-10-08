package frameworkLibrary;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportLibrary 
{
	public static ExtentReports report;
	public static ExtentTest test;
	public static String CurrentResultPath;
	public static boolean CloseBrowser = true;
	
/*
 *****************************************************************************************************
 **************************Start:Methods For the use of test cases development************************
 *****************************************************************************************************
 */
	public static void reportEvent(boolean stepstatus,String PassMessage, String FailMessage) 
	{
		if (stepstatus == true) 
		{
			System.out.println("	<<PASS>> " + PassMessage);
			test.log(LogStatus.PASS, PassMessage);
		} 
		else 
		{
			System.out.println("	<<FAIL>> " + FailMessage);
			System.out.println("");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Exception description  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			WebLibrary.ExceptionDescription.printStackTrace();
			CloseBrowser = false;
			test.log(LogStatus.FAIL, FailMessage + test.addScreenCapture(getScreenshot()));
		}
		Assert.assertEquals(stepstatus, true);
	}
	
	public static void reportEvent(boolean stepstatus,String PassMessage, String FailMessage,boolean takescrrenshot) 
	{
		if (stepstatus == true) 
		{
			System.out.println("	<<PASS>> " + PassMessage);
			if (takescrrenshot==true) 
			{
				test.log(LogStatus.PASS, PassMessage + test.addScreenCapture(getScreenshot()));
			} 
			else 
			{
				test.log(LogStatus.PASS, PassMessage);
			}
		} 
		else 
		{
			System.out.println("	<<FAIL>> " + FailMessage);
			System.out.println("");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Exception description  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			CloseBrowser = false;
			WebLibrary.ExceptionDescription.printStackTrace();
			if (takescrrenshot==true) 
			{
				test.log(LogStatus.FAIL, FailMessage + test.addScreenCapture(getScreenshot()));
			} 
			else 
			{
				test.log(LogStatus.FAIL, FailMessage);
			}
		}
		Assert.assertEquals(stepstatus, true);
	}
/*
 *****************************************************************************************************
 ****************************End:Methods For the use of test cases development************************
 *****************************************************************************************************
 */	
	
	
	
	
	
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
//##############################################################################################################################
	
/*
 *****************************************************************************************************
 **************************Start:Methods For the use of framework development************************
 *****************************************************************************************************
 */	
	public static void CreateNewExtentReportInResultsFolderWithDateAndTimeStamp()
	{
		// get current folder path
		DriverClass.CurrentFolderPath = System.getProperty("user.dir") + "\\Results";

		// create folder with date and time stamp
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
		String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
		DateTimeStamp = DateTimeStamp.replace(",", "");
		DateTimeStamp = DateTimeStamp.replace(" ", "_");
		DateTimeStamp = DateTimeStamp.replace(":", "-");
		CurrentResultPath = DriverClass.CurrentFolderPath + "\\" + DateTimeStamp;
		File dir = new File(CurrentResultPath);
		dir.mkdir();
		
		//create folder with name as Scrrenshots
		File dir1 = new File(CurrentResultPath + "\\Screenshots");
		dir1.mkdir();

		// create extent report
		report = new ExtentReports(CurrentResultPath + "\\Summary.html", true);
	}
	
	public static void startExtentTestForCurrentTestCase()
	{
		test = report.startTest(DriverClass.CurrentModuleName + "_" + DriverClass.CurrentTestCaseName);
		System.out.println("<<TestStart>>" + DriverClass.CurrentTestCaseName);
	}
	
	public static void endExtentTestForCurrentTestCase()
	{
		report.endTest(test);
		System.out.println("<<TestCompleted>>" + DriverClass.CurrentTestCaseName);
	}
	
	public static void closeExtentReport()
	{
		report.close();
	}

	public static String  getScreenshot()
	{
		String Dest = CurrentResultPath + "\\Screenshots\\";
		try 
		{
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
			DateTimeStamp = DateTimeStamp.replace(",", "");
			DateTimeStamp = DateTimeStamp.replace(" ", "_");
			DateTimeStamp = DateTimeStamp.replace(":", "-");

			Dest = Dest + DriverClass.CurrentTestCaseName + DateTimeStamp + ".png";

			TakesScreenshot ts = (TakesScreenshot) DriverClass.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destinationfile = new File(Dest);
			FileUtils.copyFile(source, destinationfile);

			// Get entire page screenshot
			File screenshot = ((TakesScreenshot) DriverClass.driver).getScreenshotAs(OutputType.FILE);
			ImageIO.write(ImageIO.read(screenshot), "png", screenshot);

			// Copy the element screenshot to disk
			FileUtils.copyFile(screenshot, new File(Dest));
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occured while taking Scrrenshot");
		}
		return Dest;
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void encodeDetails()
	{
		try
		{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("DataFiles\\GlobalData2.json"));
	
	        JSONObject jsonObject = (JSONObject) obj;
	        
			jsonObject.put("school", "njhs");
			jsonObject.put("weight", "85");
	
	        @SuppressWarnings("resource")
			FileWriter file = new FileWriter("DataFiles\\GlobalData2.json") ;
	        file.write(jsonObject.toJSONString());
	        file.flush();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
	
	public static boolean SentMailAttachment(String AttachmentPath, String Subject, String Meassegebody,String ReceiverEmailId) 
	{
		Boolean stepStatus = true;

		// Create object of Property file
		Properties props = new Properties();
		String UserEmailIdTemp = "";
		String PasswordTemp = "";

		// this will set host of server- you can change based on your
		try {
			byte[] asBytesusername = Base64.getDecoder().decode("dG1hc3RlcnMuc2VsZW5pdW1AZ21haWwuY29t");
			UserEmailIdTemp = new String(asBytesusername, "utf-8");

			byte[] asBytespassword = Base64.getDecoder().decode("VG1hc3RlcnM1MTUw");
			PasswordTemp = new String(asBytespassword, "utf-8");

		} catch (Exception e) {
			System.out.println("Unable to decode username and password");
		}
		
		
		final String UserEmailId = UserEmailIdTemp;
		final String Password = PasswordTemp;
		try 
		{
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {
			@Override
					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication(UserEmailId, Password);
					}
				});



			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress(ReceiverEmailId));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ReceiverEmailId));

			// Add the subject link
			message.setSubject(Subject);

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText(Meassegebody);

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = AttachmentPath;
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

			stepStatus = true;

		} catch (MessagingException e) 
		{
			System.out.println("=====Email Not Sent=====");
			stepStatus = false;
		}
		return stepStatus;
	}
	
	public static void LaunchReport()
	{
		WebLibrary.launchBrowser("chrome");
		WebLibrary.launchApplication(CurrentResultPath + "\\Summary.html");
	}
	
/*
 *****************************************************************************************************
 *****************************End:Methods For the use of framework development************************
 *****************************************************************************************************
 */
}
