package sampleshop.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    @Test
    public void checkCategoriesIMenu() {
        HomePage homePage = new HomePage(driver);
        driver.get("http://sampleshop.inqa.pl/");
        Assert.assertTrue(homePage.checkMenuItemExists("Clothes"));
        Assert.assertFalse(homePage.checkMenuItemExists("Promocja"));
    }

    @Test
    public void testWillFail() {
        Assert.assertEquals(1, 2);
    }
}
