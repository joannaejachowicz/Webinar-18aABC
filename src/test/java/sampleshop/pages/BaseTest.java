package sampleshop.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class BaseTest {
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    ChromeDriver driver;

    @BeforeMethod
    protected void startTest(Method method) throws Exception {
        String testName = method.getName();
        LOGGER.info("Executing test method " + testName);

    }

    @BeforeClass
    public void setUp() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "/Users/joannajachowicz/Downloads/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //uruchamianie testów bez otwierania przeglądarki
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void testTearDown(ITestResult result) {
        LOGGER.info("Metoda testowa " + result.getMethod().getMethodName() + "zakonczona");
        if (!result.isSuccess()) {
            LOGGER.info("Metoda testowa " + result.getMethod().getMethodName() + " zakonczona niepowodzeniem");
            System.out.print("Metoda testowa" + result.getMethod().getMethodName() + "zakonczona niepowodzeniem");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_hh-mm");
            String readableTimestamp = formatter.format(result.getEndMillis());
            String screenshotPath = "./target/artifacts/screenshots/" + result.getMethod().getMethodName() + "_" + readableTimestamp + ".png";
            ScreenshotUtil.takeScreenshot(driver, screenshotPath);
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
