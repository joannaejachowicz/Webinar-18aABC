package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String WELCOME_HEADER = "Welcome to the-internet";
    public static final String DESCRIPTION_HEADER = "Available Examples";

    @FindBy(tagName = "h1")
    private WebElement welcomeHeader;

    @FindBy(tagName = "h2")
    private WebElement desctiptionHeader;

    public String getWelcomeMessage() {
        return welcomeHeader.getText();
    }

    public String getDescriptionMessage() {
        return desctiptionHeader.getText();
    }
}

