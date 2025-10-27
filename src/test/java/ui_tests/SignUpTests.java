package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import static utils.UserFactory.*;

public class SignUpTests extends ApplicationManager {
SignUpPage signUpPage;
    @BeforeMethod
    public void goToSignUp(){
        new HomePage(getDriver()).clickBtnSignUpHeader();
        signUpPage= new SignUpPage(getDriver());
    }

    @Test
    public void  registrationPositiveTest(){
        User user = positiveUser();
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());


    }

    @Test
    public void registrationNegativeTest_emptyName(){
        User user = positiveUser();
        user.setFirstName("");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Name is required"));
    }

}
