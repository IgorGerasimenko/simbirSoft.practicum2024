package pages.bankingProjectPages;

import Models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomersPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'First Name')]")
    public WebElement firstName;
    String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";

    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    public CustomersPage open() throws InterruptedException {
        driver.get(baseUrl);
        return this;
    }

    public CustomersPage clickSortedByFirstName() {
        firstName.click();
        return this;
    }

    public CustomersPage deleteCustomerByFirstName(String firstName) {
        driver.findElement(By.xpath("//td[contains(text(), '" + firstName + "')]/following-sibling::td/button[contains(@ng-click, 'deleteCust')]")).click();
        return this;
    }


    public List<Customer> getCustomersList() {
        List<Customer> customers = new ArrayList<>();

        for (WebElement row : driver.findElements(By.xpath("//table/tbody/tr"))) {
            String firstName = row.findElements(By.tagName("td")).get(0).getText();
            String lastName = row.findElements(By.tagName("td")).get(1).getText();
            String postCode = row.findElements(By.tagName("td")).get(2).getText();
            String accountNumber = row.findElements(By.tagName("td")).get(3).getText();

            Customer customer = new Customer(firstName, lastName, postCode, accountNumber);
            customers.add(customer);
        }

        return customers;
    }


    public boolean isCustomersSortedByFirstName(List<Customer> customers) {
        for (int i = 0; i < customers.size() - 1; i++) {
            String FirstName = customers.get(i).getFirstName();
            String nextFirstName = customers.get(i + 1).getFirstName();

            if (FirstName.compareTo(nextFirstName) < 0) {
                return false;
            }
        }
        return true;
    }


    public double getAverageFirstNameLength(List<Customer> customers) {
        if (customers.isEmpty()) {
            return 0;
        }

        int totalLength = customers.stream()
                .mapToInt(customer -> customer.getFirstName().length())
                .sum();
        return (double) totalLength / customers.size();
    }


    public Customer getCustomerByClosestFirstNameLength(List<Customer> customers, double length) {
        Optional<Customer> closestCustomer = customers.stream()
                .min(Comparator.comparingDouble(c -> Math.abs(c.getFirstName().length() - length)));

        return closestCustomer.orElse(null);
    }

}




