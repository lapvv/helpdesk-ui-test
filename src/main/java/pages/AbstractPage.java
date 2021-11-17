package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Элементы общие для всех страниц
public abstract class AbstractPage {

    protected WebDriver driver;
    protected String url;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        this.driver.get(url);
    }
}
