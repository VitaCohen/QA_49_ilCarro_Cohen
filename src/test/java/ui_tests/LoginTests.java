package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends ApplicationManager {

    @Test
    public void loginPositiveTest(){
        User user = User.builder()
                .username("iv@mail.com")
                .password("123456Aa!")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }

    @Test
    public void loginNegativeTest_wrongPassword(){
        User user = User.builder()
                .username("iv@mail.com")
                .password("wrong password")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }

    //Homework_7
    @Test
    public void loginErrorTextUnderFieldNegativeTest_wrongEmail(){
        User user = User.builder()
                .username("wrong email")
                .firstName("123456Aa!")
                .build();
        new  HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWrongEmail(user);
        Assert.assertTrue(loginPage.isEmailWrong());
    }

    @Test
    public void loginPasswordRequiredTextUnderFieldNegativeTest_emptyPassword(){
        User user = User.builder()
                .username("iv@mail.com")
                .firstName("")
                .build();
        new  HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithoutPassword(user);
        Assert.assertTrue(loginPage.isPasswordRequired());
    }

}
