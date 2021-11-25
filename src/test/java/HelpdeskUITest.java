import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.TicketsPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        // Читаем конфигурационный файл в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /*@AfterMethod
    public void onTestFailure(ITestResult tr) {
        makeScreenshot();
    }*/

    /*@Override
    public void onTestFailure(ITestResult tr){
        Object currentClass = tr.getInstance();
        WebDriver driver = (currentClass).getDriver();
        byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
    }*/

    /*@Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot){ return screenshot; }*/

    @Test
    public void createTicketTest() {
        driver.get(System.getProperty("site.url"));
        MainPage mainPage = new MainPage(driver);
        mainPage.createTicket("No internet connection", "No internet connection via WI-FI", "135@yandex.ru");
        String u = driver.getCurrentUrl();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login();
        loginPage.search("No internet connection");

        TicketsPage ticketPage = new TicketsPage(driver);
        driver.navigate().to(u);
        ticketPage.edit();
        assert ("No internet connection".equals(ticketPage.PassIssueName()))&("135@yandex.ru".equals(ticketPage.passEmail()));
//        driver.close();
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void onTestFailure() {
        makeScreenshot();
    }
}
