package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.RediffHomePage;
import junit.framework.Assert;

public class VerifyingTest extends base {
	
	WebDriver Driver;
	RediffHomePage rhp;
	public static Logger log = LogManager.getLogger(VerifyingTest.class.getName());
	
	@BeforeTest
	public void bf() throws IOException
	{
		Driver=Intialization();
		Driver.get(prop.getProperty("url"));
	}
    
	@Test
	public void Verify()
	{
		rhp = new RediffHomePage(Driver);
		Assert.assertTrue(rhp.Nav().isDisplayed());
	}
	
	@Test
	public void Verify2()
	{
		String s =rhp.Text().getText();
		System.out.println(s);
	}
}
