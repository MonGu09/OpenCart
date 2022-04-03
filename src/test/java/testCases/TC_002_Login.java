package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.Login;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
    @Test(groups= {"sanity","master"})
	public void test_Login() throws IOException {
		logger.info("Login test Started");
		try {
		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed");
		driver.manage().window().maximize();
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Myaccount options are displayed");
		hp.clickLogin();
		logger.info("Login Page has been displayed");
		
		Login lg=new Login(driver);
		lg.setEmail(rb.getString("email"));
		logger.info("Provided Email");
		lg.setPassword(rb.getString("password"));
		logger.info("provided Password");
		lg.clickLoginButton();
		logger.info("Login Button clicked");
		boolean target=lg.isMyAccountDisplayed();
		if(target) {
			logger.info("Login Successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login Failed");
			capturescreen(driver,"test_Login");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e){
			logger.fatal("Login Failed");
			Assert.fail();
		}
		
		logger.info("TC--002 Completed");
	}
	
}
