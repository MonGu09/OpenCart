package testBase;
//base class dummy for git
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public WebDriver driver;
public org.apache.logging.log4j.Logger logger;// log4j
public ResourceBundle rb;

@BeforeClass(groups= {"master","sanity","regression"})
@Parameters("browser")
public void setUp(String br) {
	//log Config File
	rb=ResourceBundle.getBundle("config");
	logger= LogManager.getLogger(this.getClass());
	
	if (br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		logger.info("Chrome is Launched");
	}
	else if(br.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		logger.info("firefox is Launched");
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
@AfterClass
public void teardown () {
	driver.close();
}

public String randomestring() {
	String generateEmail=RandomStringUtils.randomAlphabetic(6);
	return (generateEmail);
}	
public int randomeNumber() {
	String randomeNumber1 =RandomStringUtils.randomNumeric(10);
	return(Integer.parseInt(randomeNumber1));
	
}
//Capturing Screenshot
public void capturescreen(WebDriver driver, String tName) throws IOException {
	TakesScreenshot ss=(TakesScreenshot)driver;
	File src=ss.getScreenshotAs(OutputType.FILE);
	File trg=new File (System.getProperty("user.dir")+"\\screenshots\\"+tName+ ".png");
	
	FileUtils.copyFile(src, trg);
}

}
