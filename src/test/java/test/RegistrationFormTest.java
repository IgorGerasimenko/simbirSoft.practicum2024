package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;
import pages.SubmittedPage;
import webComponents.Datepicker;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFormTest {

    public static WebDriver driver = new ChromeDriver();
    public static RegistrationPage regPage = new RegistrationPage(driver);
    public static SubmittedPage sbmForm = new SubmittedPage(driver);
    public static Datepicker datepicker = new Datepicker(driver);


    @BeforeAll
    public static void setUp() {
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    public void fillRegistrationForm() throws InterruptedException {
        regPage
                .open()
                .sendKeys(regPage.firstNameField, "Igor")
                .sendKeys(regPage.lastNameField, "Petrov")
                .sendKeys(regPage.emailField, "1@1.com")
                .clickElement(regPage.radioButtonGenderOther)
                .sendKeys(regPage.phoneNumberField, "1234567890")
                .clickElement(regPage.dateOfBirthField);
        datepicker
                .setDate("20", "June", "2010");
        regPage
                .sendKeys(regPage.subjectField, "M")
                .clickElementByText("Maths")
                .sendKeys(regPage.subjectField, "C")
                .clickElementByText("Commerce")
                .clickElement(regPage.hobbiesCheckBoxMusic)
                .sendKeys(regPage.currentAddressField, "Moskva, ul. Pushkina")
                .clickElement(regPage.stateList)
                .clickElementByText("NCR")
                .clickElement(regPage.cityList)
                .clickElementByText("Delhi")
                .uploadFile("C:\\simbirSoft.practicum2024\\src\\test\\resources\\777.jpg")
                .clickElement(regPage.submitButton);
        assertEquals("Thanks for submitting the form", sbmForm.getValue(sbmForm.title));
        assertEquals("Igor Petrov", sbmForm.getValue(sbmForm.studentName));
        assertEquals("1@1.com", sbmForm.getValue(sbmForm.studentEmail));
        assertEquals("Other", sbmForm.getValue(sbmForm.gender));
        assertEquals("1234567890", sbmForm.getValue(sbmForm.phoneNumber));
        assertEquals("Maths, Commerce", sbmForm.getValue(sbmForm.subjects));
        assertEquals("Music", sbmForm.getValue(sbmForm.hobbies));
        assertEquals("777.jpg", sbmForm.getValue(sbmForm.picture));
        assertEquals("Moskva, ul. Pushkina", sbmForm.getValue(sbmForm.Address));
        assertEquals("NCR Delhi", sbmForm.getValue(sbmForm.stateAndCity));
        assertEquals("20 June,2010", sbmForm.getValue(sbmForm.dateOfBirth));
    }

}
