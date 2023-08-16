package pl.testowanie.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.models.Customer;
import pl.testowanie.pages.HomePage;
import pl.testowanie.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        ExtentTest test = extentReports.createTest("Check out Test");

        Customer customer = new Customer();
        customer.setEmail("specifedemail@gmail.com"); // nadpisywanie wartości domyślnej
        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCard()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer, "Some comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver × 1");
        test.log(Status.PASS,"Assertions passed");
    }

    @Test
    public void openShopPage() {
        ExtentTest test = extentReports.createTest("Open shop page");
        HomePage homePage = new HomePage(driver);
        homePage.openShopPageWithButton();
        String shopTitle = driver.findElement(By.className("page-title")).getText();

        Assert.assertEquals(shopTitle, "Shop");
        test.log(Status.PASS,"Assertions passed");
    }
}
