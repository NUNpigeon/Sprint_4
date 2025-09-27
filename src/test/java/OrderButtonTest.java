import Pages.MainPageScooter;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderButtonTest extends BaseTest {

    private MainPageScooter mainPage; // Page Object для главной страницы


    @Test
    public void checkTopOrderButtonLeadsToOrderPage() {
        mainPage = new MainPageScooter(driver);
        mainPage.open();
        mainPage.clickHeaderOrderButton();

        assertTrue(driver.getCurrentUrl().contains("order"));

    }

    @Test
    public void checkBottomOrderButtonLeadsToOrderPage() {
        mainPage = new MainPageScooter(driver);
        mainPage.open();
        mainPage.clickHeaderOrderButton();
        assertTrue(driver.getCurrentUrl().contains("order"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
