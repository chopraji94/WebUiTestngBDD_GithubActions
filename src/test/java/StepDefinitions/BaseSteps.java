package StepDefinitions;

import Pages.*;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseSteps {

    public static WebDriver driver;

    public LoginpageForDemo loginpageForDemo;
    public LoggedInpage loggedInpage;
    public static Properties properties;

    public BaseSteps() {

        if(loginpageForDemo == null) {
            loginpageForDemo = new LoginpageForDemo(driver);
        }

        if(loggedInpage == null) {
            loggedInpage = new LoggedInpage(driver);
        }

    }
}
