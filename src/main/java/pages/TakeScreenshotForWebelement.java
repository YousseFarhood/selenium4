package pages;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotForWebelement {
    private WebDriver driver;
    public TakeScreenshotForWebelement (WebDriver driver)
    {
        this.driver=driver;
    }
    private By webElement=By.cssSelector("#post-8 h1");
    public void takeScreenShotForWebElement()
    {
       File file= driver.findElement(webElement).getScreenshotAs(OutputType.FILE);
        try {
            Files.move(file,new File("src/main/resources/screenshots/testResult.png"));
        } catch (IOException e) {
            e.printStackTrace();        }
    }
}
