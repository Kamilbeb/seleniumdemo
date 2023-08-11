package pl.testowanie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement orderNotice;

    public WebElement getProductName() {
        return productName;
    }

    @FindBy(xpath = "//td[contains(@class,'product-name')]")
    private WebElement productName;
    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebElement getOrderNotice(){
        return orderNotice;
    }
}
