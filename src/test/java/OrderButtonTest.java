import pages.MainPageScooter;
import org.junit.After;
import org.junit.Test;
import pages.PageConstants;

import static org.junit.Assert.assertTrue;

public class OrderButtonTest extends BaseTest {

    private MainPageScooter mainPage; // Page Object для главной страницы


    @Test
    public void checkTopOrderButtonLeadsToOrderPage() {
        mainPage = new MainPageScooter(driver);
        mainPage.open();
        mainPage.clickHeaderOrderButton();

        assertTrue(driver.getCurrentUrl().contains(PageConstants.ORDER_PAGE_URL));
    }

    @Test
    public void checkBottomOrderButtonLeadsToOrderPage() {
        mainPage = new MainPageScooter(driver);
        mainPage.open();
        mainPage.clickHeaderOrderButton();
        assertTrue(driver.getCurrentUrl().contains(PageConstants.ORDER_PAGE_URL));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
