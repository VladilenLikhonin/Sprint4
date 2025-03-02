package scooters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static scooters.pages.StartPage.*;
import static scooters.pages.StartPage.responseOutsideMoscow;

@RunWith(Parameterized.class)
public class QuestionsTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final By questionLocator;
    private final By answerLocator;
    private final String expectedAnswer;

    public QuestionsTest(By questionLocator, By answerLocator, String expectedAnswer) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameters(name = "{0} -> {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {questionPrice, responsePrice, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {questionSeveralScooter, responseSeveralScooter, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {questionRentalTime, responseRentalTime, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {questionPossibleToday, responsePossibleToday, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {questionExtendOrReturn, responseExtendOrReturn, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {questionBringCharger, responseBringCharger, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {questionCancelOrder, responseCancelOrder, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {questionOutsideMoscow, responseOutsideMoscow, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }

    @Test
    public void testQuestionAndAnswer() {
        try {
            // Принимаем кукисы
            driver.findElement(questionCookieButton).click();

            // JavaScriptExecutor Прокрутка до конца страницы
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Ждем и кликаем на вопрос
            WebElement question = wait.until(ExpectedConditions.elementToBeClickable(questionLocator));
            question.click();

            // Ждем появления ответа
            WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));


            // Получаем текст ответа
            String actualText = answer.getText();

            // Сравниваем с ожидаемым текстом
            assertEquals("Текст ответа не совпадает с ожидаемым", expectedAnswer, actualText);
        } catch (Exception e) {
            System.out.println("Ошибка при работе с вопросом: " + e.getMessage());
        }
    }
        @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
