package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageScooter {

    private WebDriver driver;

    // Константа для URL главной страницы
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru";


    private final By headerOrderButtonLocator = By.xpath(".//div[contains(@class,'Header_Nav')]/button[text()='Заказать']");
    private final By homeOrderButtonLocator = By.xpath(".//div[contains(@class,'Home_Finish')]/button[text()='Заказать']");
    private final By expandedAnswerLocator = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]");

    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButtonLocator).click();
    }

    public void clickHomeOrderButton() {
        driver.findElement(homeOrderButtonLocator).click();
    }

    public void clickQuestionWithText(String text) {

        By questionLocator = By.xpath(String.format(".//div[text()='%s']", text));
        driver.findElement(questionLocator).click();
    }

    public String getTextOfExpandedAnswer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement expandedAnswer = wait.until(ExpectedConditions.visibilityOfElementLocated(expandedAnswerLocator));
        return expandedAnswer.getText();
    }
}
