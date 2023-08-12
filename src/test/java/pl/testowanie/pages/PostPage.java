package pl.testowanie.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testowanie.models.Customer;

public class PostPage {

    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement postTitle;

    @FindBy(id = "comment")
    private WebElement postCommentInput;

    @FindBy(id = "author")
    private WebElement postCommentAuthorInput;

    @FindBy(id = "email")
    private WebElement postCommentEmail;

    @FindBy(name = "submit")
    private WebElement postCommentButton;

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public PostPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getPostTitle() {
        return postTitle;
    }

    public void sendComment(Customer customer, String comment) {
        logger.info("Filling comment");
        postCommentInput.sendKeys(comment);
        postCommentAuthorInput.sendKeys(customer.getFirstName());
        postCommentEmail.sendKeys(customer.getEmail());
        postCommentButton.click();
        logger.info("Filling comment done");
    }
}

