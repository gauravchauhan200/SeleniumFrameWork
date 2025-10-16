package ecom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.abstractcomponents.AbstractComponent;



public class OrderConfirmationPage extends AbstractComponent {
    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".hero-primary")
    WebElement orderConf;

    public Boolean VerifyOrderConfMessage() 
    {

        String oc = orderConf.getText();
        Boolean flag = oc.equalsIgnoreCase("Thankyou for the order.");
        System.out.println("Flag Value: "+flag);
        return flag;
        
    }

}
