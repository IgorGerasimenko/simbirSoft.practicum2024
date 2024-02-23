package pages.demoQaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SubmittedPage extends BasePage {


    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement title;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Student Name']/following-sibling::td[1]")
    public WebElement studentName;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Student Email']/following-sibling::td[1]")
    public WebElement studentEmail;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Gender']/following-sibling::td[1]")
    public WebElement gender;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Mobile']/following-sibling::td[1]")
    public WebElement phoneNumber;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Date of Birth']/following-sibling::td[1]")
    public WebElement dateOfBirth;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Subjects']/following-sibling::td[1]")
    public WebElement subjects;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Hobbies']/following-sibling::td[1]")
    public WebElement hobbies;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Picture']/following-sibling::td[1]")
    public WebElement picture;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='Address']/following-sibling::td[1]")
    public WebElement Address;
    @FindBy(xpath = "//div[@Class='modal-content']//td[text()='State and City']/following-sibling::td[1]")
    public WebElement stateAndCity;

    public SubmittedPage(WebDriver driver) {
        super(driver);

    }

    public String getValue(WebElement element) {
        return element.getText();
    }

}
