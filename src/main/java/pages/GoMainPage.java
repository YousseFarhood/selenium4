package pages;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;

public class GoMainPage {
    private WebDriver driver;
    public GoMainPage(WebDriver driver) {
        this.driver=driver;
    }
    public WebDriver goToMainPage()
    {
        var allWindowsHandles = driver.getWindowHandles();
        Iterator<String> iterator=allWindowsHandles.iterator();
        String firstMainTab =iterator.next();
        return driver.switchTo().window(firstMainTab);
    }
}
