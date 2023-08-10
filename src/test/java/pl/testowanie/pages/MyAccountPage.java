package pl.testowanie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(xpath ="//ul[@class='woocommerce-error']//li")
    private WebElement error;


    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver,this);  //inicjowanie elementów page objektu
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password){
        registerUser(email, password);
        return new LoggedUserPage(driver);      //strona zalogowanego użytkownika
    }

    public MyAccountPage registerUserInvalidData (String email, String password){ //error gdy rejestrujemy użytkownika przy pomocy niepoprawnych danych
        registerUser(email, password);
        return this;
    }

    private void registerUser(String email, String password){ //metoda do rejestracji
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        registerButton.click();
    }
    public WebElement getError(){
        return error;
    }
}
