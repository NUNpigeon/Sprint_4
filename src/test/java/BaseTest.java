
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

// Базовый класс для тестов
public class BaseTest {

    protected WebDriver driver; //


    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    }
