package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        User user = User.builder()
                .firstName("Eva")
                .lastName("Brown")
                .username("ev1@mail.com")
                .password("123456Aa!")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickBtnNotRegistered();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);

    }

}
