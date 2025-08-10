package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInpage {
    WebDriver driver;

    By txt_succesfullMessage = By.xpath("//div[@class='post-header']/h1");

    public LoggedInpage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessFullMessage() {
        return driver.findElement(txt_succesfullMessage).getText();
    }
}
