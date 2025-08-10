package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Refer chat gpt constructor calling => https://chatgpt.com/share/676fcd46-139c-8000-9a2c-da20822754b0

public class LoginpageForDemo {

    WebDriver driver;

    By txt_username = By.id("username");
    By txt_password = By.id("password");
    By btn_submit = By.id("submit");

    public LoginpageForDemo(WebDriver driver) {
        this.driver = driver;
    }

    public void enteruserName(String userName) {
        driver.findElement(txt_username).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(btn_submit).click();
    }
}
