package ecom.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.abstractcomponents.AbstractComponent;



public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".infoWrap")
    List<WebElement> items;

       
    public Boolean verifyProductMatch(String productName)
    {
        Boolean match = items.stream().anyMatch(item -> item.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(productName));
        return match;
    }

        public CheckOutPage clickOnBuyNow(String productName)
        {
            WebElement buyNow = items.stream().filter(item -> item.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
            buyNow.findElement(By.cssSelector(".infoWrap button:first-child")).click();
        CheckOutPage checkoutPage = new CheckOutPage(driver);
        return checkoutPage;
        
        }

       






}
