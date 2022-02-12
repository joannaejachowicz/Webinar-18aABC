package sampleshop.pages;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sampleshop.ProductDetailsPage;
import sampleshop.pages.BaseTest;

public class ProductDetailsTest extends BaseTest {

    private ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void openPage() {
        driver.get("http://sampleshop.inqa.pl/men/1-1-hummingbird-printed-t-shirt.html#/1-rozmiar-s/8-kolor-bialy");
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test(description = "Zamawianie produktu - dodanie do koszyka")
    @Description("To jest opis do zamowienia elementu")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Zamawianie produktu")
    @Link(name = "Link do dokumentacji", url = "http://webinar.edu/testuj/docs")
    @Issue("BUG-99")
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

    @Test
    @Severity(SeverityLevel.MINOR)
    @Epic("WDU-001")
    @Story("EDU-111")
    @Link(name = "link do story", url = "http://webinar.edu/testuj/story")
    @TmsLink("TMS-12")
    public void thisMethodWillFail() {
        Assert.assertEquals(3, 3);
    }
}
