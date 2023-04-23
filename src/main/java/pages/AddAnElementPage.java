package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class AddAnElementPage {
    private WebDriver driver;
    public AddAnElementPage(WebDriver driver) {
        this.driver=driver;
    }
    private By addElementButton=By.xpath("//button[contains(text(),'Add Element')]");
    private By deleteElementButton=By.xpath("//button[contains(text(),'Delete')]");
    public GoMainPage addElement()
    {
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(addElementButton).click();
        Boolean deleteButton = isDeleteVisible();
        return new GoMainPage(driver);

    }
    public Boolean isDeleteVisible()
    {
        return driver.findElement(deleteElementButton).isDisplayed();
    }
}
