package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.url="https://at-sandbox.workbench.lanit.ru/login/?next=/";
    }

    // Обычный поиск элемента
    //private WebElement user = driver.findElement(By.id(""));

    // Поиск элемента через аннотацию
    @FindBy(name = "login")
    private WebElement loginButton2 = driver.findElement(By.xpath("//input[@type='submit']"));

    // todo: остальные элементы страницы

    // todo
    public void login(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(System.getProperty("user"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(System.getProperty("password"));
        loginButton2.click();
    }

}
