package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPageScooter {

    private WebDriver driver;


    private final By headerOrderButtonLocator = By.xpath(".//div[contains(@class,'Header_Nav')]/button[text()='Заказать']");
    private final By expandedAnswerLocator = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]");

    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PageConstants.MAIN_PAGE_URL);
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButtonLocator).click();
    }

}
