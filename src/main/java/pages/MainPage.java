package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends AbstractPage {

    @FindBy(name = "buttonTicketCreate")
    private final WebElement buttonTicketCreate = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
    private final Select type = new Select(driver.findElement(By.id("id_queue")));
//    private final WebElement loginButton1 = driver.findElement(By.xpath("//a[@id='userDropdown']"));



    public MainPage(WebDriver driver) {
        super(driver);
        this.url="https://at-sandbox.workbench.lanit.ru/";
    }

    @Step("Создаём запись о проблеме")
    public void createTicket(String title, String body, String text){
        type.selectByVisibleText("Some Product");
        driver.findElement(By.id("id_title")).sendKeys(title);
        driver.findElement(By.id("id_body")).sendKeys(body);
        driver.findElement(By.xpath("//input[@name='submitter_email']")).sendKeys(text);
        buttonTicketCreate.click();
        makeScreenshot();
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /*public void moveToLogin(){
        loginButton1.click();
    }*/
}
