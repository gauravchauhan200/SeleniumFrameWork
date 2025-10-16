package ecom.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecom.pageobjects.CartPage;



public class AbstractComponent 
{
    WebDriver driver;

    public AbstractComponent(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".btn.btn-custom[routerlink='/dashboard/cart']")
    WebElement cart;
    
    public void waitForElementToAppear(By FindBy) 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
    }


    public void waitForElementToDisappear(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele)); 

    }
   
    public CartPage goToCartPage()
    {
         cart.click();
         CartPage cp=new CartPage(driver);
         return cp;
    }




}
