package pages.bankingProjectPages.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ButtonTabs extends BasePage {

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement customersButton;


    public ButtonTabs(WebDriver driver) {
        super(driver);
    }

    public void clickCustomersButton() throws InterruptedException {
        customersButton.click();

    }

}
