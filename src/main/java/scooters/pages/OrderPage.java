package scooters.pages;
import org.openqa.selenium.By; //button[contains(@class, 'Home_FinishButton') and text()='Заказать']

public class OrderPage {

    // кнопка согласия с работой куки
    public static By questionCookieButton = By.id("rcc-confirm-button");

    // кнопка "Заказать" внизу страницы
    public static By orderStart = By.xpath("//button[contains(@class, 'Button_Middle') and text()='Заказать']");

    // текст на странице заказа "Для кого самокат"
    public static By scooterFor = By.xpath("//div[text()='Для кого самокат']");

    // поле для ввода имени
    public static By nameLocator = By.xpath("//input[@placeholder='* Имя']");

    // поле для ввода фамилии
    public static By surnameLocator = By.xpath("//input[@placeholder='* Фамилия']");

    // поле для ввода адреса
    public static By addressLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // раскрывающийся список станций метро
    public static By metroList = By.xpath("//input[@placeholder='* Станция метро']");

    // станция метро "Черкизовская"
    public static By stationCherkizovskaya = By.xpath("//li/button/div[text()='Черкизовская']");

    // станция метро "Красносельская"
    public static By stationKrasnoselskaya = By.xpath("//li/button/div[text()='Красносельская']");

    // поле для ввода номера телефона
    public static By phoneLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка "Далее"
    public static By nextButton = By.xpath("//button[text()='Далее']");

    // текст на странице заказа "Про аренду"
    public static By aboutRent = By.xpath("//div[text()='Про аренду']");

    // поле с календарём "Когда привезти самокат"
    public static By calendarLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // поле с выпадающим списком "Срок аренды"
    public static By periodRent = By.xpath("//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");

    // выбор из списка поля "Сутки"
    public static By day = By.xpath("//div[@aria-selected='false' and text()='сутки']");

    // чек-бокс "Чёрный жемчуг"
    public static By colorScooter = By.xpath("//input[@id='black']");

    // поле "Комментарий для курьера"
    public static By commentLocator = By.xpath("//input[@placeholder='Комментарий для курьера']");

    // кнопка "Заказать" внизу страницы
    public static By makeOrderButton = By.xpath("//button[contains(@class, 'Button_Middle') and text()='Заказать']");

    // текст в модальном окне "Хотите оформить заказ?"
    public static By questionOrderConfirmation = By.xpath("//div[text()='Хотите оформить заказ?']");

    // кнопка подтверждения заказа
    public static By orderConfirmation = By.xpath("//button[contains(@class, 'Button_Middle') and text()='Да']");

    // текст в модальном окне "Заказ оформлен"
    public static By orderHasBeenPlaced = By.xpath("//div[contains(@class, 'Order_ModalHeader') and text()='Заказ оформлен']");
}
