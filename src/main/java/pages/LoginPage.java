package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends AbstractPage {

    // Обычный поиск элемента
    private WebElement user = driver.findElement(By.id(""));

    // Поиск элемента через аннотацию
    @FindBy(id = "")
    private WebElement password;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.url="https://at-sandbox.workbench.lanit.ru/login/?next=/";
    }

    // todo: остальные элементы страницы

    public void login(String user, String password) throws IOException {
        // todo
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

}
