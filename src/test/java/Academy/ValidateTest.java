package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.RediffHomePage;
import junit.framework.Assert;

public class ValidateTest extends base{
	
	public static Logger log = LogManager.getLogger(ValidateTest.class.getName());
	WebDriver Driver;
	
	@BeforeTest
	public void bf() throws IOException
	{
		Driver=Intialization();
		Driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void Validate()
	{
		//Creating object for RediffHomePage
		RediffHomePage rhp = new RediffHomePage(Driver);
		Assert.assertTrue(rhp.Nav().isDisplayed());
	}

	
	@AfterTest
	public void At()
	{
		Driver.quit();
	}
}
