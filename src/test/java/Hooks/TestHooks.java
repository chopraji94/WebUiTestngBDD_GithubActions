package Hooks;

import Base.Constants;
import StepDefinitions.BaseSteps;
import Util.Commons;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestHooks {

    public static final Logger logger = LoggerFactory.getLogger(TestHooks.class);

    WebDriver _driver;
    private static ExtentReports extent = getInstance();
    private static ThreadLocal<ExtentTest> scenarioThread = new ThreadLocal<>();
    String platform;
    Properties properties;
    String requireHeadless;

    @Before
    public void setUpBrowser(Scenario scenario) throws IOException {
        ExtentTest scenarioTest = extent.createTest(scenario.getName());
        scenarioThread.set(scenarioTest);
        FileInputStream fileInputStream = new FileInputStream(Constants.ADMIN1_PROPERTIES);
        properties = new Properties();
        properties.load(fileInputStream);
        _driver = setUpDriver();
        BaseSteps.driver = _driver;
        BaseSteps.properties = properties;
    }

    public WebDriver setUpDriver() throws IOException {
        RemoteWebDriver _driver = null;
        String gridSetup = System.getProperty("gridSetup");
        requireHeadless = System.getProperty("headlessEnable");
        String hubUrl = System.getenv("SELENIUM_HUB_URL");
        hubUrl = hubUrl != null ? hubUrl : "http://127.0.0.1:4444/wd/hub";
        platform = System.getProperty("os.name").toLowerCase().contains("windows") ? "Windows" : System.getProperty("os.name");

        String browser = getBrowser();
        switch (browser){
            case "chrome":
                ChromeOptions options = getChromeOptions();

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credential_enable_service",false);
                prefs.put("profile.password_manager_enabled",false);
                prefs.put("profile.default_content_settings.popups",0);
                prefs.put("download.prompt_for_download",false);
                if(platform.startsWith("Windows"))
                    prefs.put("download.default_directory", Constants.DOWNLOAD_FILE_DIR);
                else if(platform.startsWith("Linux"))
                    prefs.put("download.default_directory", Constants.DOWNLOAD_FILE_DIR_LINUX);
                prefs.put("download.directory_upgrade", "true");

                options.setExperimentalOption("prefs",prefs);

                if(gridSetup==null||gridSetup.equalsIgnoreCase("")||gridSetup.equalsIgnoreCase("No")){
                    _driver = new ChromeDriver(options);
                }
                else {
                    System.out.println("Running on grid");
                    _driver = new RemoteWebDriver(new URL(hubUrl), options);
                    _driver.setFileDetector(new LocalFileDetector());
                }
        }
        _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        _driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        _driver.manage().window().maximize();
        return _driver;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");
        options.setCapability("platformName", platform);
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        if(requireHeadless.equalsIgnoreCase("yes")){
            options.addArguments("--headless=new");
        }

        return options;
    }

    public String getBrowser(){
        String browser = System.getProperty("browser");
        if(null == browser)
            return "chrome";

        return browser;
    }

    public static ExtentReports getInstance() {
        String reportPath = Constants.REPORT_DIR+"Report_"+Commons.getDateTime("ddMMyy_HHmm") +".html";
        System.out.println(reportPath);
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    @BeforeStep
    public void BeforeStep() {
        System.out.println("Insdie before step");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        ExtentTest test = scenarioThread.get();
        // You can log each step using:
        test.info("Step executed");
    }

    @After
    public void TearDown(Scenario scenario) {
        ExtentTest test = scenarioThread.get();

        if (scenario.isFailed()) {
            test.fail("Scenario Failed: " + scenario.getName());
            // Optionally add screenshot logic here
        } else {
            test.pass("Scenario Passed: " + scenario.getName());
        }

        extent.flush(); // writes everything to the report
        _driver.close();
        _driver.quit();
    }
}
