package pl.testowanie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;

    @FindBy(id = "nimble_name1130622852")
    private WebElement nimbleNameInput;

    @FindBy(id = "nimble_email1130622852")
    private WebElement nimbleEmailInput;

    @FindBy(id = "nimble_message1130622852")
    private WebElement nimbleMassageInput;

    @FindBy(xpath = "//input[@name='nimble_submit']")
    private WebElement nimbleMessageButton;

    @FindBy(className = "sek-form-message")
    private WebElement sekFormMessage;

    private WebDriver driver;

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
        nimbleNameInput.sendKeys(name);
        nimbleEmailInput.sendKeys(email);
        nimbleMassageInput.sendKeys(message);
        nimbleMessageButton.click();
    }

    public WebElement getContactMessageNotice() {
        return sekFormMessage;
    }
}
