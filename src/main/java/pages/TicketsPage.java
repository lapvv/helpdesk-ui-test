package pages;

import org.openqa.selenium.WebDriver;

public class TicketsPage extends AbstractPage {

    public TicketsPage(WebDriver driver) {
        super(driver);
        this.url="https://at-sandbox.workbench.lanit.ru/tickets/";
    }
}
