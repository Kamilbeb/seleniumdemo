package pl.testowanie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPage {

    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement PostTitle;

    @FindBy

    private WebDriver driver;

    public PostPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getPostTitle() {
        return PostTitle;
    }
}
