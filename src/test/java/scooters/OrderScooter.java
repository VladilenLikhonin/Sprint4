package scooters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scooters.pages.OrderPage;

import java.time.Duration;

import static scooters.pages.OrderPage.*;


@RunWith(Parameterized.class)
public class OrderScooter {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final By metroStation;
    private final String calendar;
    private final String comment;




    public OrderScooter (String name, String surname, String address, String phone, By metroStation, String calendar, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.metroStation = metroStation;
        this.calendar = calendar;
        this.comment = comment;
    }


@Parameterized.Parameters
public static Object[][] getPersonInfo() {
    return new Object[][]{
            {"Фагот", "Коровьев", "Полярная 18", "89059998877", OrderPage.stationCherkizovskaya, "01.09.2021", "По возможности доставить после обеда"},
            {"Алоизий", "Могарыч", "1-й Транспортный проезд", "+79069080011", OrderPage.stationKrasnoselskaya, "12.05.2025", ""}
    };
}

@Before
public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://qa-scooter.praktikum-services.ru/");
}

@Test
public void personInfoTest() {
    // Принимаем кукисы
    driver.findElement(questionCookieButton).click();

    // прокручиваем до кнопки Заказать
    WebElement element = driver.findElement(orderStart);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    // Нажимаем на кнопку Заказать
    driver.findElement(orderStart).click();

    // Дожидаемся появление текста Для кого самокат
    wait.until(ExpectedConditions.presenceOfElementLocated(scooterFor));

    // Заполняем форму на странице Для кого самокат
    driver.findElement(nameLocator).sendKeys(name);
    driver.findElement(surnameLocator).sendKeys(surname);
    driver.findElement(addressLocator).sendKeys(address);
    driver.findElement(metroList).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(stationCherkizovskaya));
    driver.findElement(metroStation).click();
    driver.findElement(phoneLocator).sendKeys(phone);

    // Нажимаем на кнопку Далее
    driver.findElement(nextButton).click();

    // Дожидаемся появление текста Про аренду
    wait.until(ExpectedConditions.presenceOfElementLocated(aboutRent));

    // Заполняем форму на странице Про аренду
    driver.findElement(calendarLocator).sendKeys(calendar);
    driver.findElement(aboutRent).click(); // кликаем на текст, чтобы на всякий случай скрыть календарь
    driver.findElement(periodRent).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(day));
    driver.findElement(day).click();
    driver.findElement(colorScooter).click();
    driver.findElement(commentLocator).sendKeys(comment);

    // Нажать на кнопку Заказать
    driver.findElement(makeOrderButton).click();

    // Дожидаемся появление текста Хотите оформить заказ?
    wait.until(ExpectedConditions.presenceOfElementLocated(questionOrderConfirmation));

    // Нажимаем Да
    driver.findElement(orderConfirmation).click();

    // Дожидаемся появление текста Хотите оформить заказ?
    wait.until(ExpectedConditions.presenceOfElementLocated(orderHasBeenPlaced));
    }
    
@After
public void tearDown() {
    driver.quit();
}
}
