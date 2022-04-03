package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {

	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement TelePhone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement ConfirmPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement CheckPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fName) {
		FirstName.sendKeys(fName);
	}
	public void setLastName(String lName) {
		Lastname.sendKeys(lName);
	}
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	public void setTelephone(String tPhone) {
		TelePhone.sendKeys(tPhone);
	}
	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	public void setConfirmPwd(String cpwd) {
		ConfirmPwd.sendKeys(cpwd);
	}
	public void setCheckPolicy() {
		CheckPolicy.click();
	}
	public void clickContinue() {
		btnContinue.click();
	}
	public String getConfirmationMsg() {
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e) {
		return (e.getMessage());
		}
	}
	
}
