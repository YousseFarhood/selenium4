package utils;

import org.openqa.selenium.WebDriver;

public class NavigationsPage {
    private WebDriver driver;
    private WebDriver.Navigation navigate;
    public NavigationsPage(WebDriver driver)
    {
        this.driver=driver;
        navigate = driver.navigate();
    }
    //This Test is used for the test(TestRelativeLocators)
    public void goHome()
    {
        navigate.to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    //this method is used for the Test(MultipleWindowsTest)
    public void goMain()
    {
        navigate.to("https://the-internet.herokuapp.com/");
    }
    //This Test is used for the test(GetLocationTest)
    public void getLocationMethod()
    {
        navigate.to("https://testautomationu.applitools.com/learningpaths.html");
    }
    //this method is used for the test(TakeScreenshotForWebElement)
    public void goToAppliPage()
    {
        navigate.to("https://applitools.com/");
    }
    public void getBack()
    {
        navigate.back();
    }
    public void refreshPage()
    {
        navigate.refresh();
    }
    public void goForward()
    {
        navigate.forward();
    }

}
