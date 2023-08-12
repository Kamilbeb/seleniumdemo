package pl.testowanie.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pl.testowanie.models.Customer;
import pl.testowanie.pages.HomePage;
import pl.testowanie.pages.PostPage;

public class CommentTest extends BaseTest{

    @Test
    public void sendCommentTest(){
        ExtentTest test = extentReports.createTest("Send comment test");
        Customer customer = new Customer();
        PostPage postPage = new PostPage(driver);
        new HomePage(driver).openSecondPostPage();
        postPage.sendComment(customer,"test");
        test.log(Status.PASS,"Send comment passed");
    }
}
