import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RelativeLocator;
import pages.TakeScreenshotForWebelement;
import utils.NavigationsPage;

import java.util.Collections;

public class BaseTests {
    private WebDriver driver;
    protected RelativeLocator relatives;
    protected HomePage multiple;
    protected TakeScreenshotForWebelement screenshotForWebelement;
    @BeforeTest
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(getChromeOptions());
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver(getFireFoxOptions());
        }
        //this test is used for the test (TestRelativeLocators)
       // getNavigationPage().goHome();
        //This Test is used for the test (MultipleWindowsTest)
       // getNavigationPage().goMain();
        //this is used for test (GetLocationTest)
       // getNavigationPage().getLocationMethod();
        //this method is used for the test (TakeScreenshotForWebElement)

        //getNavigationPage().goToAppliPage();
        relatives=new RelativeLocator(driver);
        multiple = new HomePage(driver);
        screenshotForWebelement = new TakeScreenshotForWebelement(driver);
    }
    public NavigationsPage getNavigationPage()
    {
        return new NavigationsPage(driver);
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    private ChromeOptions getChromeOptions()
    {
        ChromeOptions chromeOptions=new ChromeOptions();

        //  chromeOptions.addArguments("disable-infobars");
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.addArguments("--headless=new");
        return chromeOptions;
    }

    private FirefoxOptions getFireFoxOptions()
    {
        FirefoxOptions firefoxOptions=new FirefoxOptions();

        //  chromeOptions.addArguments("disable-infobars");
       // firefoxOptions.addArguments("disable-infobars");
        firefoxOptions.addArguments("-headless");
        return firefoxOptions;
    }
}
