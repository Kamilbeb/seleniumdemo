package pl.testowanie.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowanie.pages.HomePage;

public class PostTest extends BaseTest {

    @Test
    public void PostSecondTest() {
        String postLink = new HomePage(driver).openSecondPostPage()
                .getPostTitle()
                .getText();

        Assert.assertTrue(postLink.contains("post"));
    }

    @Test
    public void PostThirdTest() {
        String postLink = new HomePage(driver).openThirdPostPage()
                .getPostTitle()
                .getText();

        Assert.assertTrue(postLink.contains("Hello World"));
    }
}
