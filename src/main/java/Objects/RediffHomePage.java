package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage
 {

     WebDriver Driver;

	public RediffHomePage(WebDriver Driver)
	{
		this.Driver=Driver;
	}
	
	//1st Element 
	
	By signin = By.cssSelector("a.signin");
	
	By nav = By.cssSelector("ul.navbarul");
	
	By text = By.cssSelector("a[title*='Lightning fast free']");
	
	public WebElement Nav()
	{
		return Driver.findElement(nav);
	}
	
	public RediffSignPage Signin()
	{
		Driver.findElement(signin).click();
		RediffSignPage rsp = new RediffSignPage(Driver);
		return rsp;
	}
	
	public WebElement Text()
	{
		return Driver.findElement(text);
	}
}
