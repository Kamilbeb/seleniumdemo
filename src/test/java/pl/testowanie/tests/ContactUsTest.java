package pl.testowanie.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.pages.HomePage;

public class ContactUsTest extends BaseTest {

    @Test
    public void sendMessageTest() {
        ExtentTest test = extentReports.createTest("Send message test");
        HomePage homePage = new HomePage(driver);
        homePage.ContactUsMessage("Test", "test@test.pl", "testowy");

        Assert.assertEquals(homePage.getContactMessageNotice().getText(), "It is demo page! We are not sending emails!");
        test.log(Status.PASS,"Assertions passed");
    }
}
