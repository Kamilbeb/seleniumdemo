package pl.testowanie.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;

    @FindBy(xpath = "//input[@name='nimble_name']")
    private WebElement nimbleNameInput;

    @FindBy(xpath = "//input[@name='nimble_email']")
    private WebElement nimbleEmailInput;

    @FindBy(xpath = "//textarea[@name='nimble_message']")
    private WebElement nimbleMassageInput;

    @FindBy(xpath = "//input[@name='nimble_submit']")
    private WebElement nimbleMessageButton;

    @FindBy(className = "sek-form-message")
    private WebElement sekFormMessage;

    @FindBy(xpath = "//a[@class='czr-title' and @title='Permalink to Second post']")
    private WebElement linkToSecondPost;

    @FindBy(xpath = "//a[@title='Permalink to Hello World']")
    private WebElement linkToThirdPost;

    @FindBy(xpath = "//span[@class='sek-btn-inner']")
    private WebElement linkToShop;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public HomePage(WebDriver driver) {     //konstruktor inicjalizuje działanie pola myAccountLink i pozostałych

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver);
    }

    public ProductListPage openShopPage() {
        shopLink.click();
        return new ProductListPage(driver);
    }

    public void ContactUsMessage(String name, String email, String message) {
        logger.info("Filling contact form");
        nimbleNameInput.sendKeys(name);
        nimbleEmailInput.sendKeys(email);
        nimbleMassageInput.sendKeys(message);
        nimbleMessageButton.click();
        logger.info("Filling contact form done");
    }

    public WebElement getContactMessageNotice() {
        return sekFormMessage;
    }

    public PostPage openSecondPostPage() {
        linkToSecondPost.click();
        return new PostPage(driver);
    }

    public PostPage openThirdPostPage() {
        linkToThirdPost.click();
        return new PostPage(driver);
    }

    public ProductListPage openShopPageWithButton() {
        linkToShop.click();
        return new ProductListPage(driver);
    }
}