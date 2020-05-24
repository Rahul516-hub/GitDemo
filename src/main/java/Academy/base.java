package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;




public class base {
	
	WebDriver Driver;
	Properties prop;


	
	public WebDriver Intialization() throws IOException
	{

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/Academy/E2E.properties");
		prop.load(fis);
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");


		String browsername = System.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Chrome//chromedriver.exe");
			
			
			if(browsername.contains("headless"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless","user-agent=rock");
				Driver = new ChromeDriver(options);
			}
			else
			{
				Driver=new ChromeDriver();
			}
		}
		
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Firefox\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			Driver = new FirefoxDriver();
		}
		
		else
		{
			System.setProperty("webdriver.ie.driver", "D:\\Ie\\IE\\IEDriverServer.exe");
			Driver = new InternetExplorerDriver();
		}
		
		
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		@SuppressWarnings("unused")
		WebDriverWait d = new WebDriverWait(Driver,20);
		return Driver;
	}
	
	
	public String Screenshot(String TestCaseName,WebDriver Driver) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot) Driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\resources\\"+TestCaseName+".png";
		FileUtils.copyFile(src,new File(destination));
		return destination;
	}

}
