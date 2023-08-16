package pl.testowanie.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        ExtentTest test = extentReports.createTest("Register user test");
        int random = (int) (Math.random() * 1000);
        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .registerUserValidData("newuser" + random + "@test.pl", "zaq1@WSX#EDC$RFV")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
        test.log(Status.PASS,"Assertions passed");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        ExtentTest test = extentReports.createTest("Register user with same email test");
        WebElement error = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData("newuser1@test.pl", "zaq1@WSX#EDC$RFV")
                .getError();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address."));
        test.log(Status.PASS,"Assertions passed");
    }
}
