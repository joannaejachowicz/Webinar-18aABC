import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void checkMainHeaderText() {
        // test z wykorzystaniem POP/POM
        Assert.assertEquals(homePage.getWelcomeMessage(), HomePage.WELCOME_HEADER);

        // test klasyczny
//        WebElement header = driver.findElement(By.tagName("h1"));
//        Assert.assertEquals(header.getText(), "Welcome to the-internet");
    }

    @Test
    public void checkDescriptionHeaderText() {
        Assert.assertEquals(homePage.getDescriptionMessage(), HomePage.DESCRIPTION_HEADER);
    }
}
