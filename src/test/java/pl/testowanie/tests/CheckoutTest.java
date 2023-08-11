package pl.testowanie.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.models.Customer;
import pl.testowanie.pages.HomePage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();
        customer.setFirstName("Kamil");
        customer.setLastName("Testowy");
        customer.setCompanyName("TMT");
        customer.setCountry("Poland");
        customer.setStreet("Testowa");
        customer.setFlatNumber("19");
        customer.setZipCode("21500");
        customer.setCity("Warszawa");
        customer.setPhone("999999999");
        customer.setEmail("test@test.pl");

        new HomePage(driver).openShopPage().openProduct("Java Selenium WebDriver")
                .addProductToCard().viewCart().openAddressDetails()
                .fillAddressDetails(customer,"Some comment");

    }

}
