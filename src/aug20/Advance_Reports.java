package aug20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Advance_Reports 
{
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
@BeforeTest
public void generateReports() 
{
	reports = new ExtentReports("./ExtentReport/Demo.html");
}
@BeforeMethod
public void setUp() 
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http:/google.com");
}

@Test
public void firstTestcase() 
{
	logger = reports.startTest("Pass Test");
	logger.assignAuthor("Sushma");
	String Expected = "Google";
	String Actual = driver.getTitle();
	if(Actual.equalsIgnoreCase(Expected)) 
	{
		logger.log(LogStatus.PASS, "Title is matched::::"+"-------"+Actual);
	}else 
	{
		logger.log(LogStatus.FAIL, "Title is Not matched::::"+"-------"+Actual);
	}
}

@Test
public void secondTestcase() 
{
	logger = reports.startTest("Fail Test");
	logger.assignAuthor("Sushma Reddy");
	String Expected = "Gmail";
	String Actual = driver.getTitle();
	if(Actual.equalsIgnoreCase(Expected)) 
	{
		logger.log(LogStatus.PASS, "Title is matched::::"+"-------"+Actual);
	}else 
	{
		logger.log(LogStatus.FAIL, "Title is Not matched::::"+"-------"+Actual);
	}
}

@AfterMethod
public void tearDown() 
{
	reports.endTest(logger);
	reports.flush();
	driver.quit();
}

}
