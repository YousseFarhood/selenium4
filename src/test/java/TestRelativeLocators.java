import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RelativeLocator;
import utils.NavigationsPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class TestRelativeLocators extends BaseTests {

    @Test
    public void testRelativeLocators() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities =new DesiredCapabilities();
        desiredCapabilities.setBrowserName(Browser.CHROME.browserName());
        URL url=new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(url,desiredCapabilities);
        //this test is used for the test (TestRelativeLocators)
         getNavigationPage().goHome();
        relatives.searchListElements();
        System.out.println(relatives.getAllSearchList());
    }


}
