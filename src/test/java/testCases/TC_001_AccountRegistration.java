
	package testCases;

	import java.time.Duration;

		import org.apache.commons.lang3.RandomStringUtils;
		import org.junit.Assert;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.annotations.AfterClass;
		import org.testng.annotations.BeforeClass;
		import org.testng.annotations.Test;

		import io.github.bonigarcia.wdm.WebDriverManager;
		import pageObjects.AccountRegistrationPage;
		import pageObjects.HomePage;
import testBase.BaseClass;

		public class TC_001_AccountRegistration extends BaseClass {

			
			
			@Test(groups= {"regression","master"})
			public void test_account_Registration() {
				logger.info("Starting of TC_001");
				try {
				driver.get(rb.getString("appURL"));
				logger.info("HomePage is displayed");
				driver.manage().window().maximize();
				HomePage hp= new HomePage(driver);
				hp.clickMyAccount();
				logger.info("Clicked on My account");
				hp.clickRegister();
				logger.info("Clicked On Register");
				
				AccountRegistrationPage arp=new AccountRegistrationPage(driver);
				arp.setFirstName("Monika");
				logger.info("Provided First Name");
				arp.setLastName("Gupta");
				logger.info("Provided Last Name");
				
				arp.setEmail(randomestring()+ "@gmail.com");
				logger.info("provided email");
				arp.setTelephone("1234567890");
				logger.info("Provd Mobile number");
				arp.setPassword("Excel@123");
				logger.info("Provided Password");
				arp.setConfirmPwd("Excel@123");
				logger.info("Provided Confirmation of pwd");
				arp.setCheckPolicy();
				logger.info("Checked Set Privacy");
				arp.clickContinue();
				logger.info("Clicked on Continue Button");
				String confirmMsg=arp.getConfirmationMsg();
				if(confirmMsg.equals("Your Account Has Been Created!"))
				{
					logger.info("Account Registration Passed");
					Assert.assertTrue(true);
					
				}
				else {
					//Call Screenshot method no need to create object as already created
					
					logger.error("Account Registration Fail");
					capturescreen(driver,"test_account_Registration");
					Assert.assertTrue(false);
				}
			}
			catch(Exception e) {
				logger.fatal("Account Registration Failed");
				Assert.fail();
			}
				
				logger.info("TC_001_AccountRegistration Completed");
				}
				
			
				
				
				
			}
			
			
			
			
			





