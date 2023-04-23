import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import java.net.URL;

public class GetLocationTest extends BaseTests{
    @Test
    public void testGetLocation() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities =new DesiredCapabilities();
        desiredCapabilities.setBrowserName(Browser.FIREFOX.browserName());
        URL url=new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(url,desiredCapabilities);
        //this is used for test (GetLocationTest)
        getNavigationPage().getLocationMethod();
     var rectAUTLogo=   multiple.getLogoLocation();
     System.out.println("x: "+rectAUTLogo.getX()+" y: "+rectAUTLogo.getY() +" height: "+rectAUTLogo.getHeight()+" width: "+rectAUTLogo.getWidth());

    }

}
