package Models;

public class Customer {
    private String firstName;
    private String lastName;
    private String postCode;
    private String accountNumbers;

    public Customer(String firstName, String lastName, String postCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
    }

    public Customer(String firstName, String lastName, String postCode, String accountNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
        this.accountNumbers = accountNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(String accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postCode='" + postCode + '\'' +
                ", accountNumbers=" + accountNumbers +
                '}';
    }
}
