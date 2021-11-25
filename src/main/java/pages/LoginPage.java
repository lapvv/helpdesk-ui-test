package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.url="https://at-sandbox.workbench.lanit.ru/login/?next=/";
    }

    /*Обычный поиск элемента
    //private WebElement user = driver.findElement(By.id(""));

    // Поиск элемента через аннотацию
//    @FindBy(name = "login")
//    private WebElement loginButton2 = driver.findElement(By.xpath("//input[@type='submit']"));*/

    @Override
    public void open() {
        super.open();
    }

    // todo: остальные элементы страницы

    // todo
    @Step("Ищем поля для логина и передаём значения")
    public void login(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(System.getProperty("user"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(System.getProperty("password"));
        WebElement loginButton2 = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton2.click();
        makeScreenshot();
    }
    @Step("Вводим данные в поисковую строку")
    public void search(String search){
        driver.findElement(By.xpath("//input[@id='search_query']")).sendKeys(search);
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        searchButton.click();
        makeScreenshot();
//        driver.navigate().to(u);
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
