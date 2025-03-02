package scooters.pages;
import org.openqa.selenium.By;


public class StartPage {

    // кнопка согласия с работой с куки
    public static By questionCookieButton = By.id("rcc-confirm-button");

    // выпадающий вопрос "Сколько это стоит? И как оплатить?"
    public static By questionPrice = By.id("accordion__heading-0");
    // ответ на вопрос "Сколько это стоит? И как оплатить?"
    public static By responsePrice = By.id("accordion__panel-0");

    // выпадающий вопрос "Хочу сразу несколько самокатов! Так можно?"
    public static By questionSeveralScooter = By.id("accordion__heading-1");
    // ответ на вопрос "Хочу сразу несколько самокатов! Так можно?"
    public static By responseSeveralScooter = By.id("accordion__panel-1");

    // выпадающий вопрос "Как рассчитывается время аренды?"
    public static By questionRentalTime = By.id("accordion__heading-2");
    // ответ на вопрос "Как рассчитывается время аренды?"
    public static By responseRentalTime = By.id("accordion__panel-2");

    // выпадающий вопрос "Можно ли заказать самокат прямо на сегодня?"
    public static By questionPossibleToday = By.id("accordion__heading-3");
    // ответ на вопрос "Можно ли заказать самокат прямо на сегодня?"
    public static By responsePossibleToday = By.id("accordion__panel-3");

    // выпадающий вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    public static By questionExtendOrReturn = By.id("accordion__heading-4");
    // ответ на вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    public static By responseExtendOrReturn = By.id("accordion__panel-4");

    // выпадающий вопрос "Вы привозите зарядку вместе с самокатом?"
    public static By questionBringCharger = By.id("accordion__heading-5");
    // ответ на вопрос "Вы привозите зарядку вместе с самокатом?"
    public static By responseBringCharger = By.id("accordion__panel-5");

    // выпадающий вопрос "Можно ли отменить заказ?"
    public static By questionCancelOrder = By.id("accordion__heading-6");
    // ответ на вопрос "Можно ли отменить заказ?"
    public static By responseCancelOrder = By.id("accordion__panel-6");

    // выпадающий вопрос "Я живу за МКАДом, привезёте?"
    public static By questionOutsideMoscow = By.id("accordion__heading-7");
    // ответ на вопрос "Я живу за МКАДом, привезёте?"
    public static By responseOutsideMoscow = By.id("accordion__panel-7");


}


