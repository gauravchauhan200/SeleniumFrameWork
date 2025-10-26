package ecom.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecom.abstractcomponents.AbstractComponent;

public class OrderPage extends AbstractComponent
{
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(css=".table>tbody>tr>td:nth-child(3)")
	List <WebElement> listOfOrderedProducts;
	
	
	
	
	public Boolean verifyproductHistoryMatch(String orderedProduct)
	{
		Boolean match =listOfOrderedProducts.stream().anyMatch(pd-> pd.getText().equalsIgnoreCase(orderedProduct));
		return match;
	}
	
}
