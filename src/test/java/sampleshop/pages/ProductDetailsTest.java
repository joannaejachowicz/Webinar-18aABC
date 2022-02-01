package sampleshop.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void openPage() {
        driver.get("http://sampleshop.inqa.pl/men/1-1-hummingbird-printed-t-shirt.html#/1-rozmiar-s/8-kolor-bialy");
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test(description = "Zamawianie produktu - dodanie do koszyka")
    public void orderElement() {
        int addedProducts = 100;

        int displayedQuantity = productDetailsPage
                .selectSize("M")
                .selectColor("czarny")
                .addSelectedQuantityOfProducts(addedProducts)
                .clickAddToCartButton()
                .waitForTheOrderSummaryPopup()
                .getDisplayedQuantity();

        Assert.assertEquals(displayedQuantity, addedProducts);
    }


}
