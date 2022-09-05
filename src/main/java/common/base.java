package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public WebDriver driver = null;
	public static ExtentTest test;
	public static ExtentReports report;
	@BeforeTest
	public void launchBrowser() {
		
		report = new ExtentReports(System.getProperty("user.dir")+"Report.html");
		test = report.startTest("J2store");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://j2store.net/demo/");
		
		test.log(LogStatus.PASS, "Chrome Browser Launched and URL Loaded");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Before Test");

	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("After Test");
		driver.close();
		report.endTest(test);
		report.flush();

	}
}
