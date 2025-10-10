import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPageScooter;
import pages.OrderPageScooterSelenium;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PositiveScenarioTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final int deliveryDate;
    private final String rentalDays;
    private final String colorOfScooter;
    private final String commentForСourier;

    public PositiveScenarioTest(
            String name,
            String surname,
            String address,
            String metroStation,
            String phoneNumber,
            int deliveryDate,
            String rentalDays,
            String colorOfScooter,
            String commentForСourier
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalDays = rentalDays;
        this.colorOfScooter = colorOfScooter;
        this.commentForСourier = commentForСourier;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Екатерина", "Гордон", "ул. Пятницкое шоссе, д.42", "Сокольники", "89070520562", 10, "двое суток", "grey", "Оставить у двери"},
                {"Мария", "Хворова", "ул. Парковая, д.10", "Черкизовская", "+79635665520", 5, "пятеро суток", "black", "Позвонить в домофон"},
        };
    }

    @Test
    public void shouldMakeOrder() {

        MainPageScooter mainPage = new MainPageScooter(driver);
        mainPage.open();

        try {
            WebElement cookieButton = driver.findElement(By.id("rcc-confirm-button"));
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(cookieButton));
            cookieButton.click();
        } catch (Exception e) {
        }


        mainPage.clickHeaderOrderButton();


        OrderPageScooterSelenium orderPage = new OrderPageScooterSelenium(driver);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@placeholder='* Имя']")));

        Actions actions = new Actions(driver);
        WebElement nameField = driver.findElement(By.xpath(".//input[@placeholder='* Имя']"));


        actions.moveToElement(nameField).perform();


        orderPage.fillNameField(name)
                .fillSurnameField(surname)
                .fillAddressField(address)
                .selectMetroStation(metroStation)
                .fillPhoneNumberField(phoneNumber)
                .clickNextButton()
                .selectDeliveryDate(deliveryDate)
                .selectRentalDaysField(rentalDays)
                .selectColorOfScooter(colorOfScooter)
                .fillCommentForСourierField(commentForСourier)
                .clickMakeOrderMiddleButton()
                .clickConfirmOrderWindowYesButton();


        assertTrue("Сообщение об успешном оформлении заказа не появилось.", orderPage.isOrderPlaced());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
