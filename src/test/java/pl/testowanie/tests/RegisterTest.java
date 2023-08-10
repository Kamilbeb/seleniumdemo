package pl.testowanie.tests;

import org.testng.annotations.Test;
import pl.testowanie.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest(){
        new HomePage(driver).openMyAccountPage();
    }
}
