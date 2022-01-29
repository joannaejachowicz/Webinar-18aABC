import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.LinkRedirectionPage;

import java.time.Duration;

public class LinkRedirectionPageTest extends BaseTest{

    LinkRedirectionPage linkRedirectionPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        linkRedirectionPage = new LinkRedirectionPage(driver);

    }

        @Test(priority = 1)
        public void moveFromHomePageToAnother() {
        driver.get("http://the-internet.herokuapp.com/redirector");
            linkRedirectionPage.clickRedirectLink();
        }

        @Test(priority = 2)
        public void checkThatStatus200IsDisplayed(){
            driver.get("http://the-internet.herokuapp.com/status_codes");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(linkRedirectionPage.secondStatus200dLink));
        }

        @Test(priority = 3)
        public void moveFromListStatusesPageTo200StatusDescription(){
            driver.get("http://the-internet.herokuapp.com/status_codes");
            linkRedirectionPage.clickStatusLink();
        }

        @Test(priority = 4)
        public void checkStatusDescription() {
        driver.get("http://the-internet.herokuapp.com/status_codes/200");
        Assert.assertTrue(linkRedirectionPage.showDescription().contains("This page returned a 200 status code"));

        }

        @Test(priority = 5)
        public void checkReturnToHomePage() {
        driver.get("http://the-internet.herokuapp.com/status_codes/200");
        linkRedirectionPage.clickReturnButtonLink();
        String expectedUrl = "http://the-internet.herokuapp.com/status_codes";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
        }




