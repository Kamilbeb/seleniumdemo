package pl.testowanie.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.models.Customer;
import pl.testowanie.pages.HomePage;
import pl.testowanie.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();
        customer.setEmail("specifedemail@gmail.com"); // nadpisywanie wartości domyślnej
        OrderDetailsPage orderDetailsPage = new HomePage(driver).openShopPage().openProduct("Java Selenium WebDriver")
                .addProductToCard().viewCart().openAddressDetails()
                .fillAddressDetails(customer,"Some comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(),"Java Selenium WebDriver × 1");
    }

}
