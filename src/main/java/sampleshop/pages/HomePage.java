package sampleshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "top-menu")
    private WebElement topMenu;

    public boolean checkMenuItemExists(String itemText) {
        String xpathText = "./li[contains(.,\"" + itemText + "\")]";


        try {
            topMenu.findElement(By.xpath(xpathText));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
