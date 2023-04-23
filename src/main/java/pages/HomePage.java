package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By logoElement = By.xpath("//div/header/a/img");
    private void clickLink( String linkText)
    {
        driver.findElement(By.linkText(linkText)).click();
    }

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public UserAuthPage clickUserAuth()
    {
        clickLink("Basic Auth");
        return new UserAuthPage(driver);

    }

    public AddAnElementPage goToAddElementPage()
    {
        //clickLink("Add/Remove Elements");
        return new AddAnElementPage(driver);
    }
    public Rectangle getLogoLocation()
    {
       return  driver.findElement(logoElement).getRect();

    }



}
