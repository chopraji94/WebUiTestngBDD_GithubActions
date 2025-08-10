package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.Duration;

public class DemoLoginStepDefinitnon extends BaseSteps {

    @Given("I open Login url")
    public void i_open_login_url() throws InterruptedException {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(Duration.ofSeconds(5));
    }

    @When("^I enter given userName (.*)$")
    public void i_enter_username_01(String userName) throws InterruptedException {
        loginpageForDemo.enteruserName(userName);
        Thread.sleep(Duration.ofSeconds(5));
    }

    @When("^I enter given password (.*)$")
    public void i_enter_password_01(String password) throws InterruptedException {
        loginpageForDemo.enterPassword(password);
        Thread.sleep(Duration.ofSeconds(5));
    }

    @When("^I enter username (.*)$")
    public void i_enter_username(String userName) throws InterruptedException {
        loginpageForDemo.enteruserName(userName);
        Thread.sleep(Duration.ofSeconds(5));
    }

    @When("I enter valid user credentials")
    public void i_enter_valid_username() throws InterruptedException {
        String userName = System.getProperty("username");
        System.out.println("Here is user name => "+userName);
        loginpageForDemo.enteruserName(userName);
        Thread.sleep(Duration.ofSeconds(5));
    }

    @When("^I enter password (.*)$")
    public void i_enter_password(String password) throws InterruptedException {
        loginpageForDemo.enterPassword(password);
        Thread.sleep(Duration.ofSeconds(5));
    }

    @When("I enter valid user password")
    public void i_enter_valid_user_password() throws InterruptedException {
        String password = System.getProperty("password");
        loginpageForDemo.enterPassword(password);
        Thread.sleep(Duration.ofSeconds(5));
    }

    @When("I click Submit button")
    public void i_click_submit_button() throws InterruptedException {
        loginpageForDemo.clickSubmitButton();
        Thread.sleep(Duration.ofSeconds(5));
    }

    @Then("I verify {string} is displayed after succesfull login")
    public void i_verify_is_after_succesfull_login(String succcesfulltext) {
        String text = loggedInpage.getSuccessFullMessage();
        Assert.assertEquals(text, succcesfulltext);
    }

}
