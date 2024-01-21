package webComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Datepicker extends BasePage {

    public Datepicker(WebDriver driver) {
        super(driver);
    }

    public void setDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']")).sendKeys(monthOfBirth);
        driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']")).sendKeys(yearOfBirth);
        driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[text()='" + dayOfBirth + "']")).click();
    }


}