
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PageConstants;

// Базовый класс для тестов
public class BaseTest {

    protected WebDriver driver; //


    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get(PageConstants.MAIN_PAGE_URL);
    }


}
