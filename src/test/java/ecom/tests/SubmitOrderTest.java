package ecom.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecom.pageobjects.OrderPage;
import ecom.pageobjects.CartPage;
import ecom.pageobjects.CheckOutPage;
import ecom.pageobjects.OrderConfirmationPage;
import ecom.pageobjects.ProductCatalogue;
import ecom.testcomponents.BaseTest;
import ecom.testcomponents.Retry;

public class SubmitOrderTest extends BaseTest {
	
	
	String productName="ZARA COAT 3";
	String countryName = "india";
	 
	
	@Test(dataProvider="getData",groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException 
	{

		// ProductCatalogue pc =   new ProductCatalogue(driver);

		ProductCatalogue pc = lp.loginApplication(input.get("email"), input.get("pass"));

		List<WebElement> products = pc.getProductList();

		pc.addproductToCart(input.get("product"));
		CartPage cp = pc.goToCartPage();

		Assert.assertTrue(cp.verifyProductMatch(input.get("product")));
		CheckOutPage checkoutPage = cp.clickOnBuyNow(input.get("product"));

		checkoutPage.enterTheInfo(countryName);
		checkoutPage.clickPlaceOrder();

		OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
		Assert.assertTrue(ocp.VerifyOrderConfMessage());
		
	}
	
	//To verify product is displayed in Orders page
	
	@Test(dependsOnMethods= {"submitOrder()"})
	public void orderHistoryTest()
	{
			
		ProductCatalogue pc = lp.loginApplication("admingama@example.com", "Function@1234");
		OrderPage op = pc.goToOrderPage();
		Boolean flag = op.verifyproductHistoryMatch(productName);
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//		HashMap<String,String> map = new HashMap<String,String>();
		//		map.put("email","admingama@example.com");
		//		map.put("pass","Function@1234");
		//		map.put("product","ZARA COAT 3");
		//		
		//		HashMap<String,String> map1 = new HashMap<String,String>();
		//		map1.put("email","networkadmin@example.com");
		//		map1.put("pass","Network@1234");
		//		map1.put("product","ADIDAS ORIGINAL");
		//		return new Object[][]	 {{map},{map1}};
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//ecom//data//PurchaseOrder.json");
		return new Object[][]	 {{data.get(0)},{data.get(1)}};
		
		
	}
	
	
		
	//	@DataProvider
	//	public Object getData()
	//	{
	//		
	//		return new Object[][]	 {{"admingama@example.com","Function@1234","ZARA COAT 3"},{"networkadmin@example.com","Network@1234","ADIDAS ORIGINAL"}};
	//		
	//	}
	
	
	

}