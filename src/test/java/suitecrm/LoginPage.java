package suitecrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public  LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_name")
	public WebElement UserInput;
	
	@FindBy(id="username_password")
	public WebElement PwdInput;
	
	@FindBy(id="bigbutton")
	public WebElement SubmitButton;
	
	public void login(String username, String password){
		UserInput.sendKeys(username);
		PwdInput.sendKeys(password);
		SubmitButton.click();
	}
	
}
