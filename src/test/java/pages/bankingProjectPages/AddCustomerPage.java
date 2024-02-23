package pages.bankingProjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AddCustomerPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameInput;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameInput;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCodeInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addCustomerButton;
    String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust";


    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    public AddCustomerPage open() throws InterruptedException {
        driver.get(baseUrl);
        return this;
    }

    public AddCustomerPage sendKeys(WebElement element, String value) {
        element.sendKeys(value);
        return this;
    }

    public AddCustomerPage clickElement(WebElement element) {
        element.click();
        return this;
    }

    public AddCustomerPage acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }


    public AddCustomerPage fillForm(String firstName, String lastName, String postCode) {
        sendKeys(firstNameInput, firstName)
                .sendKeys(lastNameInput, lastName)
                .sendKeys(postCodeInput, postCode);
        return this;
    }


}
