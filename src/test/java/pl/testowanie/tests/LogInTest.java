package pl.testowanie.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.pages.HomePage;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        ExtentTest test = extentReports.createTest("Log in test");
        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .logInValidData("newuser1@test.pl", "zaq1@WSX#EDC$RFV")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
        test.log(Status.PASS,"Assertions passed");
    }
}
