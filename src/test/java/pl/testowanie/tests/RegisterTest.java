package pl.testowanie.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        int random = (int) (Math.random()*1000);
        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .registerUserValidData("newuser"+random+"@test.pl", "zaq1@WSX#EDC$RFV")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(),"Dashboard");
    }
    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData("newuser1@test.pl", "zaq1@WSX#EDC$RFV")
                .getError();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address."));
    }
}
