package ecom.tests;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecom.pageobjects.CartPage;
import ecom.pageobjects.CheckOutPage;
import ecom.pageobjects.LandingPage;
import ecom.pageobjects.OrderConfirmationPage;
import ecom.pageobjects.ProductCatalogue;
import ecom.testcomponents.BaseTest;



public class SubmitOrderTest extends BaseTest
{
    @Test
   public void submitOrder() throws IOException
   {

        String productName = "ZARA COAT 3";
        String countryName="india";

        // ProductCatalogue pc = new ProductCatalogue(driver);


        LandingPage lp= launchApplication();
        ProductCatalogue pc= lp.loginApplication("admingama@example.com","Function@1234");
                    
        List<WebElement> products = pc.getProductList();

        pc.addproductToCart(productName);
        CartPage cp = pc.goToCartPage();
        
        Assert.assertTrue(cp.verifyProductMatch(productName)); 
        CheckOutPage checkoutPage=  cp.clickOnBuyNow(productName);

        checkoutPage.enterTheInfo(countryName);
        checkoutPage.clickPlaceOrder();

        OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
        Assert.assertTrue(ocp.VerifyOrderConfMessage());
        driver.close();
   }

    
}