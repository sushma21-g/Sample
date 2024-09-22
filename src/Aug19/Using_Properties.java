package Aug19;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Using_Properties 
{
	WebDriver driver;
	Properties conpro;
	
@BeforeMethod 
public void SetUp() throws Throwable 
{
	conpro = new Properties();
	conpro.load(new FileInputStream("primus.properties"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(conpro.getProperty("Url"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath(conpro.getProperty("objuser"))).sendKeys(conpro.getProperty("Enteruser"));
	driver.findElement(By.xpath(conpro.getProperty("objpass"))).sendKeys(conpro.getProperty("Enterpass"));
	driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();	
}

@Test
public void branchCreation() throws Throwable 
{
	driver.findElement(By.xpath(conpro.getProperty("objBranches"))).click();
	driver.findElement(By.xpath(conpro.getProperty("objNewBranch"))).click();
	driver.findElement(By.xpath(conpro.getProperty("objBname"))).sendKeys(conpro.getProperty("EnterbranchN"));
	driver.findElement(By.xpath(conpro.getProperty("objAddress1"))).sendKeys(conpro.getProperty("EnterAdd1"));
	driver.findElement(By.xpath(conpro.getProperty("objAddress2"))).sendKeys(conpro.getProperty("EnterAdd2"));
	driver.findElement(By.xpath(conpro.getProperty("objAddress3"))).sendKeys(conpro.getProperty("EnterAdd3"));
	driver.findElement(By.xpath(conpro.getProperty("objArea"))).sendKeys(conpro.getProperty("EnterArea"));
	driver.findElement(By.xpath(conpro.getProperty("objZip"))).sendKeys(conpro.getProperty("EnterZip"));
	new Select(driver.findElement(By.xpath(conpro.getProperty("objCountry")))).selectByVisibleText(conpro.getProperty("SelectCountry"));
	Thread.sleep(3000);
	new Select(driver.findElement(By.xpath(conpro.getProperty("objState")))).selectByVisibleText(conpro.getProperty("SelectState"));
	Thread.sleep(3000);
	new Select(driver.findElement(By.xpath(conpro.getProperty("objCity")))).selectByVisibleText(conpro.getProperty("SelectCity"));
	Thread.sleep(3000);
	driver.findElement(By.xpath(conpro.getProperty("objSubmit"))).click();
	String alert = driver.switchTo().alert().getText();
	System.out.println(alert);
	driver.switchTo().alert().accept();	
}
@Test
public void roleCreation() throws Throwable 
{
	driver.findElement(By.xpath(conpro.getProperty("objRoles"))).click();
	driver.findElement(By.xpath(conpro.getProperty("objNewRole"))).click();
	driver.findElement(By.xpath(conpro.getProperty("objRoleName"))).sendKeys(conpro.getProperty("EnterRole"));
	driver.findElement(By.xpath(conpro.getProperty("objRoleDesc"))).sendKeys(conpro.getProperty("EnterRoleDesc"));
	new Select(driver.findElement(By.xpath(conpro.getProperty("objRoleType")))).selectByVisibleText(conpro.getProperty("SelectRoleType"));
	Thread.sleep(3000);
	driver.findElement(By.xpath(conpro.getProperty("objSubmitbtn"))).click();
	String alerttext = driver.switchTo().alert().getText();
	System.out.println(alerttext);
	driver.switchTo().alert().accept();	
}
@AfterMethod
public void tearDown() 
{
	driver.findElement(By.xpath(conpro.getProperty("objLogout"))).click();
	driver.quit();
}

}
