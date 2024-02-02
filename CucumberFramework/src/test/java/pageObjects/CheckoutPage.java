package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.GenericUtils;

public class CheckoutPage extends GenericUtils{
	public WebDriver driver;

	public CheckoutPage(WebDriver driver)
	{	
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declare Locators By locators 
	
	
	
	private By cartBag = By.cssSelector("[alt='Cart']");
	private By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoBtn = By.cssSelector(".promoBtn");
	private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	
	@FindBy(xpath="//div[@class='wrapperTwo']/div/select")
	private WebElement ListOfAllCountry; 
	
	@FindBy(css=".chkAgree")
	private WebElement IagreeCheckbox; 
	
	@FindBy(xpath="//*[contains(text(),'Proceed')]")
	private WebElement ProceedButton; 
	
	@FindBy(xpath="//*[@id='root']/div/div/div/div/span")
	private WebElement OrderSuccessMessage; 
	
	

	
	
	
	//Action Methods
	public Boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public void ClickPlaceOrder() 
	{
		driver.findElement(placeOrder).click();
	}
	public void SelectCountry() throws InterruptedException
	{
		
		waitUntilElementDisplay(ListOfAllCountry);
		//ListOfAllCountry.click();
		Select option= new Select(ListOfAllCountry);
		option.selectByValue("India");
		
	}
	
	public void AgreeAndProceed()
	{
		IagreeCheckbox.click();
		ProceedButton.click();
	}
	
	public boolean VerifyOrderSuccessMessage()
	{
		return OrderSuccessMessage.isDisplayed();
	}
	
	
	
	
}
