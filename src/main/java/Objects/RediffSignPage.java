package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffSignPage {
	
	WebDriver Driver;
	
	public RediffSignPage(WebDriver Driver)
	{
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}
	
	@FindBy(css="input#login1")
	WebElement username;
	
	@FindBy(css="input#password")
	WebElement password;
	
    @FindBy(css="a[title='Create new Rediffmail account']")
    WebElement forgot;
    
	public WebElement Username()
	{
		return username;
	}
	
	public WebElement Password()
	{
		return password;
	}
	
	public WebElement Forgot()
	{
		return forgot;
	}
	

}
