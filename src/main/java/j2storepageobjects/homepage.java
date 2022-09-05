package j2storepageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import common.base;

public class homepage extends base {
	
	
	
	@FindBy(xpath = "//li[@data-id='116']/a[text()='Blog ']")
	private WebElement BlogTopNavigation;

	@FindBy(xpath = "//h2[@class='article-title']/a[contains(@title,'Homepage')]")
	private WebElement HomePageBlogLink;

	@FindBy(xpath = "//h2[@class='article-title']/a[contains(@title,'Ecommerce')]")
	private WebElement EccomerceBlogLink;
	@FindBy(xpath = "//li[@data-id='110']/a[text()='Shop ']")
	private WebElement ShopTopNavigation;

	@FindBy(xpath = "//li[@data-id='123']/a[text()='Top ']")
	private WebElement topsSubNavigation;

	@FindBy(xpath = "//li[@data-id='122']/a[text()='T-Shirts ']")
	private WebElement tshirtsSubavigation;

	@FindBy(xpath = "//li[@data-id='136']/a[text()='Dressing table ']")
	private WebElement dressingtableSubNavigation;

	@FindBy(xpath = "//li[@data-id='136']/a[text()='Blog ']")
	private WebElement blogTopNavigation;
	
	@FindBy(xpath = "//input[@data-cart-action-done='Add to cart']")
	private WebElement addtocart;
	@FindBy(xpath = "//a[text()='Checkout']")
	private WebElement checkout;
	
	@FindBy(xpath = "//button[@id='button-account']")
	private WebElement continueButton;
	
	@FindBy(id = "first_name")
	private WebElement first_name;
	@FindBy(id = "last_name")
	private WebElement last_name;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "phone_2")
	private WebElement mobile;
	
	@FindBy(xpath = "//div[@class='j2store']//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//div[@class='j2store']//input[@name='confirm']")
	private WebElement confirm_password;
	
	
	@FindBy(id = "address_1")
	private WebElement address_1;
	@FindBy(id = "city")
	private WebElement city;
	@FindBy(id = "zip")
	private WebElement zip;
	
	@FindBy(id = "country_id")
	private WebElement country_id;
	
	@FindBy(id = "zone_id")
	private WebElement zone_id;
	
	@FindBy(xpath = "//input[@id='button-register']")
	private WebElement buttonregister;
	
	
	@FindBy(xpath = "//input[@id='button-payment-method']")
	private WebElement buttonpayment;
	
	@FindBy(xpath = "//input[@id='bank-submit-button']")
	private WebElement buttonpplaceorder;
	
	
	
	public homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void browseBlogs() throws InterruptedException {

		BlogTopNavigation.click();
		test.log(LogStatus.PASS, "Navigated to blogs page");
		HomePageBlogLink.click();
		test.log(LogStatus.PASS, "Homepage using SiteOrigin Page Builder Blog browsed ");
		Thread.sleep(2000);
		BlogTopNavigation.click();
		Thread.sleep(3000);
		EccomerceBlogLink.click();
		test.log(LogStatus.PASS, "Ecommerce Analytics with Segment Blog browsed ");
	}

	public void browseCategories() {

		Actions action = new Actions(driver);
		action.moveToElement(ShopTopNavigation).click(tshirtsSubavigation).build().perform();
		test.log(LogStatus.PASS, "Browsed TShirts from Cloth Categories");
		action.moveToElement(ShopTopNavigation).click(topsSubNavigation).build().perform();
		
		test.log(LogStatus.PASS, "Browsed Tops from Cloth Categories");
		action.moveToElement(ShopTopNavigation).click(dressingtableSubNavigation).build().perform();
		test.log(LogStatus.PASS, "Browsed Dressing table from Furniture Categories");
	}
	public void addItemsToCart()
	{
		Actions action = new Actions(driver);
		action.moveToElement(ShopTopNavigation).click(tshirtsSubavigation).build().perform();
		test.log(LogStatus.PASS, "TShirt added to Cart");
		addtocart.click();
		action.moveToElement(ShopTopNavigation).click(topsSubNavigation).build().perform();	
		addtocart.click();
		test.log(LogStatus.PASS, "Top added to Cart");
		action.moveToElement(ShopTopNavigation).click(dressingtableSubNavigation).build().perform();
		addtocart.click();
		test.log(LogStatus.PASS, "Dressing table added to Cart");
		
		checkout.click();
		continueButton.click();
		
		first_name.sendKeys("hellow");
		last_name.sendKeys("world");
		int min = 200;  
		int max = 400;  
		int b = (int)(Math.random()*(max-min+1)+min); 
		email.sendKeys("hello"+b+"@world.com");
		mobile.sendKeys("1234567890");
		password.sendKeys("12345678");
		confirm_password.sendKeys("12345678");
		address_1.sendKeys("bangalore");	
		city.sendKeys("bangalore");	
		zip.sendKeys("560001");
		
		Select sel=new Select(country_id);
		sel.selectByVisibleText("India");
		
		sel=new Select(zone_id);
		sel.selectByVisibleText("Karnataka");
		
		
		buttonregister.click();
		test.log(LogStatus.PASS, "Registration Completed ");
		buttonpayment.click();
		test.log(LogStatus.PASS, "Payment Selection Completed ");
		buttonpplaceorder.click();
		test.log(LogStatus.PASS, "Order Placed ");
	}
}
