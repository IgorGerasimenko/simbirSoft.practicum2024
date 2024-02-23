package test.bankingProjectTest;

import Models.Customer;
import org.junit.jupiter.api.Test;
import pages.bankingProjectPages.AddCustomerPage;
import pages.bankingProjectPages.CustomersPage;
import pages.bankingProjectPages.webElements.ButtonTabs;
import test.BaseTest;
import utils.TestDataGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest extends BaseTest {

    public static AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
    public static CustomersPage customersPage = new CustomersPage(driver);
    public static ButtonTabs buttonTabs = new ButtonTabs(driver);


    @Test
    public void addCustomer() throws InterruptedException {
        String postCode = TestDataGenerator.getRandomNumber(10);
        String firstName = TestDataGenerator.getCharactersByNumbers(postCode);
        String lastName = "Fisher";

        addCustomerPage.open()
                .fillForm(firstName, lastName, postCode)
                .clickElement(addCustomerPage.addCustomerButton)
                .acceptAlert();
        buttonTabs.clickCustomersButton();

        List<Customer> customers = customersPage.getCustomersList();


        assertNotNull(customers.stream()
                .filter(customer -> customer.getFirstName().equals(firstName) &&
                        customer.getLastName().equals(lastName) &&
                        customer.getPostCode().equals(postCode))
                .findAny()
                .orElse(null));
    }

    @Test
    public void sortCustomersByFirstName() throws InterruptedException {

        customersPage.open()
                .clickSortedByFirstName();

        List<Customer> customers = customersPage.getCustomersList();
        System.out.println(customers);

        assertTrue(customersPage.isCustomersSortedByFirstName(customers));

    }

    @Test
    public void deleteCustomerByAverageLength() throws InterruptedException {

        customersPage.open();

        List<Customer> customersBeforeDeleteCustomer = customersPage.getCustomersList();


        Double averageFirstNameLength = customersPage.getAverageFirstNameLength(customersBeforeDeleteCustomer);
        Customer customerWithAverageFirstName = customersPage.getCustomerByClosestFirstNameLength(customersBeforeDeleteCustomer, averageFirstNameLength);
        String averageFirstName = customerWithAverageFirstName.getFirstName();

        customersPage.deleteCustomerByFirstName(averageFirstName);

        List<Customer> customersAfterDeleteCustomer = customersPage.getCustomersList();

        assertNull(customersAfterDeleteCustomer.stream()
                .filter(customer -> customer.getFirstName().equals(customerWithAverageFirstName.getFirstName()) &&
                        customer.getLastName().equals(customerWithAverageFirstName.getLastName()) &&
                        customer.getPostCode().equals(customerWithAverageFirstName.getPostCode()))
                .findAny()
                .orElse(null));
    }


}
