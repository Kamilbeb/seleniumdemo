package pl.testowanie.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.pages.HomePage;

public class PostTest extends BaseTest {

    @Test
    public void PostSecondTest() {
        ExtentTest test = extentReports.createTest("Post second test");
        String postLink = new HomePage(driver).openSecondPostPage()
                .getPostTitle()
                .getText();

        Assert.assertTrue(postLink.contains("post"));
        test.log(Status.PASS,"Assertions passed");
    }

    @Test
    public void PostThirdTest() {
        ExtentTest test = extentReports.createTest("Post Third test");
        String postLink = new HomePage(driver).openThirdPostPage()
                .getPostTitle()
                .getText();

        Assert.assertTrue(postLink.contains("Hello World"));
        test.log(Status.PASS,"Assertions passed");
    }
}
