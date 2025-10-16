package ecom.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ecom.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{

    public WebDriver driver;


    public WebDriver initializeDriver() throws IOException
    {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/ecom/resources/GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {

        }

        else if(browserName.equalsIgnoreCase("edge"))
        {
            System.setProperty("webdriver.edge.driver", "edge.exe");
             driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    } 


     public LandingPage launchApplication() throws IOException
        {
            driver = initializeDriver();
            LandingPage lp = new LandingPage(driver);
            lp.goTo();
            return lp;
        }

    
}
