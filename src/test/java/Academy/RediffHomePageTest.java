package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Objects.RediffHomePage;
import Objects.RediffSignPage;




public class RediffHomePageTest extends base {
	
	WebDriver Driver;
	
	public static Logger log = LogManager.getLogger(RediffHomePageTest.class.getName());
	
	@BeforeTest
	public void bf() throws IOException
	{
		Driver=Intialization();
		log.info("Driver gets initialized");
	}
    
	
	@Test(dataProvider="getdata")
	public void Demo(String username,String password)
	{
		log.debug("Browser should get invoked");
		Driver.get(prop.getProperty("url"));
		
		//Creating object to perform test in home page
		RediffHomePage rhp = new RediffHomePage(Driver);
		RediffSignPage rsp = rhp.Signin();
		rsp.Username().sendKeys(username);
		rsp.Password().sendKeys(password);
		rsp.Forgot().click();
		
		
		
		
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="Rahul Raturi";
		data[0][1]="Jaltheband@123";
		
		data[1][0]="Nivedita Raturi";
		data[1][1]="Nivedita";
		
		return data;
	}
	
	@AfterTest
	public void AT()
	{
		Driver.quit();
	}
}
