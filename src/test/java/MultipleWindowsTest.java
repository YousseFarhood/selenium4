import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MultipleWindowsTest extends BaseTests{
    @Test
    public void testMultipleWindows() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities =new DesiredCapabilities();
        desiredCapabilities.setBrowserName(Browser.CHROME.browserName());
        URL url=new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(url,desiredCapabilities);
        //This Test is used for the test (MultipleWindowsTest)
         getNavigationPage().goMain();
       var addPage= multiple.goToAddElementPage();
        var goHome=addPage.addElement();
        Assert.assertTrue(addPage.isDeleteVisible(),"it wasn't displayed");
        goHome.goToMainPage();

    }
}
