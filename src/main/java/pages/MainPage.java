package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(name = "ticket")
    private WebElement ticketInput;


    public MainPage(WebDriver driver) {
        super(driver);
        this.url="https://at-sandbox.workbench.lanit.ru/";
    }

    public void sendKeys(String text){
        ticketInput.sendKeys(text);
    }


}
