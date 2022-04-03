package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
WebDriver driver;
 public Login(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
@FindBy(xpath="//input[@id='input-email']")
WebElement Email;
@FindBy(xpath="//input[@id='input-password']")
WebElement Password;
@FindBy(xpath="//input[@value='Login']")
WebElement LoginBtn;
@FindBy(xpath="//h2[text()='My Account']")
WebElement Myaccount;

	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	public void clickLoginButton() {
		LoginBtn.click();
	}
	
	public boolean isMyAccountDisplayed() {
	try {
		return(Myaccount.isDisplayed());
	}
	catch(Exception e) {
		return(false);
	}
	}
}
