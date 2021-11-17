import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractPage;
import pages.LoginPage;
import pages.MainPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;

    @Before
    public void setup() throws IOException {
        // Читаем конфигурационный файл в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
//        AbstractPage.setDriver(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void createTicketTest() {
        driver.get(System.getProperty("site.url"));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        //mainPage.sendKeys("text");

        driver.findElement(By.id("id_queue"));
        Select type = new Select(driver.findElement(By.id("id_queue")));
        type.selectByVisibleText("Some Product");
        String a="No internet connection";
        driver.findElement(By.id("id_title")).sendKeys(a);
        driver.findElement(By.id("id_body")).sendKeys("No internet connection via WI-FI");
        String b="135@yandex.ru";
        driver.findElement(By.xpath("//input[@name='submitter_email']")).sendKeys(b);
        WebElement buttonTicketCreate = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
        buttonTicketCreate.click();

//        WebElement caption = driver.findElement(By.xpath("//caption"));
//        String a1 = caption.getText();        //*[text()='[SP-445] . No internet connection [Open]']
        String u = driver.getCurrentUrl();

        WebElement login = driver.findElement(By.xpath("//a[@id='userDropdown']"));
        login.click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(System.getProperty("user"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(System.getProperty("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

//        WebElement lastpage = driver.findElement(By.xpath("//a[@data-dt-idx='7']"));
//        lastpage.click();
//        driver.findElement(By.xpath("//input[@id='search_query']")).sendKeys(b);

        driver.navigate().to(u);
        WebElement edit = driver.findElement(By.xpath("//span/*[1]/*[1]"));
        edit.click();
        //WebElement email = driver.findElement(By.xpath("//tbody/*[2]//*[4]"));
        //WebElement nameOfTicket = driver.findElement(By.xpath("//thead/*[1]//*[1]//*[1]"));
        //String c = email.getText();
        //String d = nameOfTicket.getText();
        //c=c.substring(12);
        //System.out.println(c);
        WebElement title2 = driver.findElement(By.xpath("//input[@type='text'][@name='title']"));
        String c = title2.getAttribute("value");
        WebElement email2 = driver.findElement(By.xpath("//input[@name='submitter_email']"));
        String d = email2.getAttribute("value");
        if (a.equals(c)) {
            System.out.println("Email заявки совпадает с найденным");
            if (b.equals(d)){
                System.out.println("Имя заявки совпадает с введенным");
            }
            else{
                System.out.println("Имя заявки НЕ совпадает с введенным");
            }
            System.out.println("Проверка заявки завершена. Данные совпадают.");
        }
        else{
            System.out.println("Email заявки НЕ совпадает с найденным");
        }


        // ...

//        // todo: чтение данных учетной записи пользователя из user.properties в System.properties
//        LoginPage loginPage = new LoginPage();
//        loginPage.login(System.getProperty("user"), System.getProperty("password"));

        // ...

        //Закрываем текущее окно браузера
        driver.close();
    }
}
