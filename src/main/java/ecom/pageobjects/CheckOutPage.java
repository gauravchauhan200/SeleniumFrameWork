package ecom.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.abstractcomponents.AbstractComponent;



public class CheckOutPage extends AbstractComponent 
{

    WebDriver driver;

    public CheckOutPage(WebDriver driver)
    {   
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    
    
	    @FindBy(css ="[placeholder='Select Country']")
	    WebElement selectCountry;
	
	    @FindBy(css=".ta-item:last-of-type")
	    WebElement selectCountrySuggestion;
	
	    @FindBy(css=".action__submit")
	    WebElement placeOrder;
	
	    By results = By.cssSelector(".ta-results");


    public void enterTheInfo(String countryName)
    {
        Actions a = new Actions(driver);
        a.sendKeys(selectCountry, countryName).build().perform();
        waitForElementToAppear(results);
        selectCountrySuggestion.click();
       
    }

    public void clickPlaceOrder()
    {
    	placeOrder.click();
    }



}
