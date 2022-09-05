package one1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ecom {
	WebDriver driver;

	
	@Test
	public void searchProduct()	{
			//searchForSpecificProduct("Mobile");
			WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.sendKeys("Mobile");
			WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));
			searchButton.click();
	}
	
	@Test
	public void checkBestSellers()	{
			//searchForSpecificProduct("Mobile");
			WebElement bestSellers=driver.findElement(By.xpath("//div/a[text()='Best Sellers']"));
			bestSellers.click();
			
			WebElement bestSellersBanner=driver.findElement(By.xpath("//span[@id='zg_banner_text']"));
			Assert.assertEquals(bestSellersBanner.getText().trim(), "Amazon Bestsellers","Best Sellers Page is Displayed");
		
			int bestSellersCount=4;
			List<WebElement> bestsellWebElements=driver.findElements(By.xpath("//div[@id='anonCarousel1']/ol/li"));
			
			if(bestSellersCount==bestsellWebElements.size())
			{
				System.out.println("Expected Best Sellers Count is Displayed");
			}
			else
			{
				System.out.println("Best Sellers Count is not mathed as expected ");
			}
	}
	
	
	@Test
	public void checkMobilesPage()	{
			//searchForSpecificProduct("Mobile");
			WebElement mobipagelink=driver.findElement(By.xpath("//div/a[text()='Mobiles']"));
			mobipagelink.click();
			
			WebElement mobilesBanner=driver.findElement(By.xpath("//h2"));
			Assert.assertEquals(mobilesBanner.getText().trim(), "Top deals on mobiles and accessories","Top deals on mobiles and accessories is Displayed");
		
	}
	
	@Test
	public void checkTodaysDealsPage()	{
			//searchForSpecificProduct("Mobile");
			WebElement todaydeals=driver.findElement(By.xpath("//div/a[contains(text(),'Deals')]"));
			todaydeals.click();
			
			WebElement todaydealsBanner=driver.findElement(By.xpath("//h1"));
			Assert.assertEquals(todaydealsBanner.getText().trim(), "Today's Deals","Today's Deals is Displayed");
		
	}
	
	@Test
	public void searchforSpecificProductandGetPrice()	{
			//searchForSpecificProduct("Mobile");
			WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.sendKeys("Redmi Note 11 Pro");
			WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));
			searchButton.click();
			
			WebElement productLink=driver.findElement(By.xpath("//span[contains(text(),'Redmi Note 11 Pro (')]"));
			productLink.click();
			
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			WebElement price=driver.findElement(By.xpath("//td[text()='Deal Price:']/following-sibling::td"));
			
			System.out.println("Price of the Product"+price.getText().trim());
			
			WebElement addtocartLink=driver.findElement(By.id("add-to-cart-button"));
			addtocartLink.click();
			
			driver.close();
			 
			driver.switchTo().window(tabs.get(0));
			
			
			
	}
	
	@Test
	public void searchforSpecificProductandAddtoCart()	{
			//searchForSpecificProduct("Mobile");
			WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.sendKeys("Redmi Note 11 Pro");
			WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));
			searchButton.click();
			
			WebElement productLink=driver.findElement(By.xpath("//span[contains(text(),'Redmi Note 11 Pro (')]"));
			productLink.click();
			
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			WebElement price=driver.findElement(By.xpath("//td[text()='Deal Price:']/following-sibling::td"));
			
			System.out.println("Price of the Product"+price.getText().trim());
			
			WebElement addtocartLink=driver.findElement(By.id("add-to-cart-button"));
			addtocartLink.click();
			System.out.println("Product added to cart");
			driver.close();
			 
			driver.switchTo().window(tabs.get(0));
			
			
			
	}
	
	
	

	@BeforeMethod
	public void launchApplciation()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Training\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		System.out.println(" Chrome is Launched ");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
