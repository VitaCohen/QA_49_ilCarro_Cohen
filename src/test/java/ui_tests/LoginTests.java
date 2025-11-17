package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.RetryAnalizer;
import utils.TestNGListener;
import utils.enums.HeaderMenuItem;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)
public class LoginTests extends ApplicationManager {

    @Test (retryAnalyzer = RetryAnalizer.class)
    public void loginPositiveTest(Method method){
        User user = User.builder()
                .username("iv@mail.com")
                .password("123456Aa!")
                .build();
        logger.info("start test " + method.getName()
        + "with data " + user);
        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        //logger.error("Examle error");
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }

    @Test
    public void loginNegativeTest_wrongPassword(){
        User user = User.builder()
                .username("iv@mail.com")
                .password("wrong password")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }

    //Homework_7
    @Test(enabled = false)
    public void loginErrorTextUnderFieldNegativeTest_wrongEmail(){
        User user = User.builder()
                .username("wrong email")
                .firstName("123456Aa!")
                .build();
        new  HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
       // loginPage.typeLoginFormWrongEmail(user);
      //  Assert.assertTrue(loginPage.isEmailWrong());
    }

    @Test(enabled = false)
    public void loginPasswordRequiredTextUnderFieldNegativeTest_emptyPassword(){
        User user = User.builder()
                .username("iv@mail.com")
                .firstName("")
                .build();
        new  HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
      //  loginPage.typeLoginFormWithoutPassword(user);
        //Assert.assertTrue(loginPage.isPasswordRequired());
    }

    //======================================================//


    @Test
    public void loginNegativeTest_emptyPassword(){
        User user = User.builder()
                .username("bilbo_baggins_12345@mail.com")
                .password("")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isTextInErrorPresent("Password is required"));
    }

    @Test
    public void loginNegativeTest_emailWOAt(){
        User user = User.builder()
                .username("bilbo_baggins_12345mail.com")
                .password("123456Aa!")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isTextInErrorPresent("It'snot look like email"));
    }

}
