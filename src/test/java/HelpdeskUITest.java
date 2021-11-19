import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.TicketsPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;

    @Before
    public void setup() throws IOException {
        // Читаем конфигурационный файл в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void createTicketTest() {
        driver.get(System.getProperty("site.url"));
        MainPage mainPage = new MainPage(driver);
        mainPage.createTicket("No internet connection", "No internet connection via WI-FI", "135@yandex.ru");
//        mainPage.sendTicket();
        String u = driver.getCurrentUrl();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login();                          //пока всё работает...
        loginPage.search("No internet connection");

        TicketsPage ticketPage = new TicketsPage(driver);
        driver.navigate().to(u);
        ticketPage.edit();
//        ticketPage.passEmail();
        assert ("No internet connection".equals(ticketPage.PassIssueName()))&("135@yandex.ru".equals(ticketPage.passEmail()));

//        // todo: чтение данных учетной записи пользователя из user.properties в System.properties
//        см.выше

        // ...

        //Закрываем текущее окно браузера
        driver.close();
    }
}
