package pl.testowanie.tests;

import org.testng.annotations.Test;
import pl.testowanie.models.Customer;
import pl.testowanie.pages.HomePage;
import pl.testowanie.pages.PostPage;

public class CommentTest extends BaseTest{

    @Test
    public void sendCommentTest(){
        Customer customer = new Customer();
        PostPage postPage = new PostPage(driver);
        new HomePage(driver).openSecondPostPage();
        postPage.sendComment(customer,"test");
    }
}
