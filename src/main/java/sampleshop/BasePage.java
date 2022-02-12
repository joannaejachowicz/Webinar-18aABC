package sampleshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //metody wspólne dla różnych stron
    // mogą to być operacje na typowych elementach
    //wspólne operacje wait

    protected void buttonClick(WebElement buttonElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonElement));

        buttonElement.click();
    }

    protected void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
