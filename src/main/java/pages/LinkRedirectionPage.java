package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkRedirectionPage extends BasePage{
    public LinkRedirectionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "redirect")
    private WebElement link;

    @FindBy (css = "#content > div > ul > li:nth-child(1) > a")
    public WebElement secondStatus200dLink;

    @FindBy (css = "#content > div > p")
    public WebElement statusDescription;

    @FindBy(css = "#content > div > p > a")
    public WebElement redirectLink;

    public void clickRedirectLink(){
        link.click();
    }

    public void clickStatusLink(){
        secondStatus200dLink.click();
    }

    public String showDescription(){
       return statusDescription.getText();

    }

    public void clickReturnButtonLink(){
        redirectLink.click();
    }








}
