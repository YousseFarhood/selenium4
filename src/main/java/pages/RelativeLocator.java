package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocatorServerSide;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class RelativeLocator {
    private WebDriver driver;

    public RelativeLocator(WebDriver driver)
    {
        this.driver=driver;
    }
    private By login= By.tagName("h5");
    private By footer = By.xpath("//p[contains(@class,'oxd-text oxd-text--p orangehrm-login-forgot-header')]");
    public void searchBelowLocator()
    {       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(login));
        WebElement loginElement = driver.findElement(login);
        System.out.println(loginElement.getText());
      WebElement relativeElement = driver.findElement
              (org.openqa.selenium.support.locators.RelativeLocator.with(By.tagName("p")).below(login));


            System.out.println(relativeElement.getText());
    }
    public void searchListElements()
    {       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        listOfSocialMedia();
        wait.until(ExpectedConditions.presenceOfElementLocated(footer));
       //  this is an approach to loop through the webelements and convert them to strings as it is not a good practice to return webelements to our tests
        for(WebElement socialMedia:listOfSocialMedia())

        {
            System.out.println(socialMedia.getAttribute("href"));
        }

    }

    /**
     *
     * @return this is the other approach to map the list of webelements to list of strings both of them are okay
     */
    public List<String> getAllSearchList()
    {           listOfSocialMedia();
        return  listOfSocialMedia().stream().map(e->e.getAttribute("href")).collect(Collectors.toList());
    }
    private List<WebElement> listOfSocialMedia()
    {
        String css="a:not(div.orangehrm-login-footer>div.orangehrm-copyright-wrapper>p[class='oxd-text oxd-text--p orangehrm-copyright']>a[href='http://www.orangehrm.com'])";
        List<WebElement> allSocialMedia = driver.findElements(org.openqa.selenium.support.locators.RelativeLocator.with(By.cssSelector(css)).below(footer));
        return allSocialMedia;
    }

}
