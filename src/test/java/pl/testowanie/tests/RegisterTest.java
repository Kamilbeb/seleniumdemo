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
                .registerUser("newuser"+random+"@test.pl", "zaq1@WSX#EDC$RFV")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(),"Dashboard");
    }
}
