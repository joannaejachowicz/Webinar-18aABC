import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

import java.time.Duration;

import static pages.DynamicLoadingPage.EXPECTED_CONFIRMATION_TEXT;

public class DynamicLoadingPageTests extends BaseTest {
    DynamicLoadingPage dynamicLoadingPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Test(priority = 2)
    public void checkConfirmationText() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.finishTextHeader));

        Assert.assertEquals(dynamicLoadingPage.getFinishLoadingConfirmation(), EXPECTED_CONFIRMATION_TEXT);
    }

    @Test(priority = 1)
    public void checkLoadingBarDisplay(){
        dynamicLoadingPage.clickStartButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.loadingBar));

    }

}