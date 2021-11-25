package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class TicketsPage extends AbstractPage {

    public TicketsPage(WebDriver driver) {
        super(driver);
        this.url="https://at-sandbox.workbench.lanit.ru/tickets/";
    }

    /*public void goToPage(){
        WebElement lastpage = driver.findElement(By.xpath("//a[@data-dt-idx='7']"));
        lastpage.click();
        driver.findElement(By.xpath("//input[@id='search_query']")).sendKeys("No internet connection");
        WebElement email = driver.findElement(By.xpath("//tbody/*[2]//*[4]"));
        WebElement nameOfTicket = driver.findElement(By.xpath("//thead/*[1]//*[1]//*[1]"));
        String c = email.getText();
        String d = nameOfTicket.getText();
        c=c.substring(12);
        System.out.println(c);
    }*/

    @Step("Редактируем запись")
    public void edit() {
        WebElement edit = driver.findElement(By.xpath("//span/*[1]/*[1]"));
        edit.click();
        makeScreenshot();
    }

    public String PassIssueName(){
        WebElement title2 = driver.findElement(By.xpath("//input[@type='text'][@name='title']"));
        return title2.getAttribute("value");
    }

    public String passEmail(){
        WebElement email2 = driver.findElement(By.xpath("//input[@name='submitter_email']"));
        return email2.getAttribute("value");
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
