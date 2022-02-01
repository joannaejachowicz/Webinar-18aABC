package sampleshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "group_1")
    private WebElement sizeSelect;

    @FindBy(css = "button[data-button-action='add-to-cart']")
    private WebElement addToCartButton;

    @FindAll({@FindBy(className = "input-color")})
    private List<WebElement> colors;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = "#blockcart-modal > div > div > div.modal-body > div > div.col-md-5.divide-right > div > div:nth-child(2) > span.product-quantity > strong")
    private WebElement quantityOfProductsInCart;


    public ProductDetailsPage selectSize(String sizeToSelect) {
        Select select = new Select(sizeSelect);
        select.selectByVisibleText((sizeToSelect));
        return this;
    }

    public ProductDetailsPage clickAddToCartButton() {
        buttonClick(addToCartButton);
        return this;
    }

    public ProductDetailsPage selectColor(String color) {
        colors.forEach(c -> {
            if (color.equals(c.getAttribute("title"))) {
                c.click();
            }
        });

        return this;
    }

    public ProductDetailsPage addSelectedQuantityOfProducts(Integer value) {
        quantityInput.clear();
        quantityInput.sendKeys(value.toString());
        return this;
    }


    public ProductDetailsPage waitForTheOrderSummaryPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(quantityOfProductsInCart));
        return this;
    }

    public Integer getDisplayedQuantity() {
        return Integer.parseInt(quantityOfProductsInCart.getText());
    }
}



