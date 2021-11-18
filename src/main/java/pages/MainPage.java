package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends AbstractPage {

    @FindBy(name = "buttonTicketCreate")
    private WebElement buttonTicketCreate = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
    private Select type = new Select(driver.findElement(By.id("id_queue")));
    private WebElement loginButton1 = driver.findElement(By.xpath("//a[@id='userDropdown']"));



    public MainPage(WebDriver driver) {
        super(driver);
        this.url="https://at-sandbox.workbench.lanit.ru/";
    }

    public void createTicket(String title, String body){
        type.selectByVisibleText("Some Product");
        driver.findElement(By.id("id_title")).sendKeys(title);
        driver.findElement(By.id("id_body")).sendKeys(body);
    }

    public void sendTicket(String text){
        driver.findElement(By.xpath("//input[@name='submitter_email']")).sendKeys(text);
//        buttonTicketCreate.click();
        String u = driver.getCurrentUrl();
        loginButton1.click();
    }
}
