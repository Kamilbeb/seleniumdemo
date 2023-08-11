package pl.testowanie.tests;

import org.testng.annotations.Test;
import pl.testowanie.models.Customer;
import pl.testowanie.pages.HomePage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();
        customer.setEmail("specifedemail@gmail.com"); // nadpisywanie wartości domyślnej
        new HomePage(driver).openShopPage().openProduct("Java Selenium WebDriver")
                .addProductToCard().viewCart().openAddressDetails()
                .fillAddressDetails(customer,"Some comment");

    }

}
