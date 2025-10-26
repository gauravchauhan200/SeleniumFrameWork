package ecom.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ecom.testcomponents.BaseTest;
import ecom.testcomponents.Retry;

public class ErrorValidationTest extends BaseTest 
{
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException 
	{
		lp.loginApplication("mingama@example.com", "Function@1234");
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		
	
	}
	
	
	
	
}
