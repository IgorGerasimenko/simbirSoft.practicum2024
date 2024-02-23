package pages.demoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class RegistrationPage extends BasePage {

    //Это CSS селектор по требованию из ТЗ
    @FindBy(css = "input[id='firstName']")
    public WebElement firstNameField;
    //Это Xpath селектор по требованию из ТЗ
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameField;
    //Это id селектор по требованию из ТЗ
    @FindBy(id = "userEmail")
    public WebElement emailField;
    @FindBy(id = "subjectsInput")
    public WebElement subjectField;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;
    @FindBy(id = "userNumber")
    public WebElement phoneNumberField;
    @FindBy(xpath = "//*[text()='Other']")
    public WebElement radioButtonGenderOther;
    @FindBy(xpath = "//*[@id='hobbiesWrapper']//label[contains(text(), 'Music')]")
    public WebElement hobbiesCheckBoxMusic;
    @FindBy(xpath = "//div[@id='state']//div[contains(text(), 'Select State')]")
    public WebElement stateList;
    @FindBy(xpath = "//div[@id='city']//div[contains(text(), 'Select City')]")
    public WebElement cityList;
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitButton;
    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthField;
    String baseUrl = "https://demoqa.com/automation-practice-form";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage open() {
        driver.get(baseUrl);
        return this;
    }

    public RegistrationPage sendKeys(WebElement element, String value) {
        element.sendKeys(value);
        return this;
    }

    public RegistrationPage clickElement(WebElement element) {
        element.click();
        return this;
    }

    public RegistrationPage clickElementByText(String text) {
        driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).click();
        return this;
    }

    public RegistrationPage uploadFile(String filePath) {
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(filePath);
        return this;
    }


}
