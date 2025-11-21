package ui_tests;

import data_provider.UserDP;
import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utils.TestNGListener;

import static utils.UserFactory.*;

@Listeners(TestNGListener.class)
public class SignUpTests extends ApplicationManager {
SignUpPage signUpPage;
    @BeforeMethod(alwaysRun = true)
    public void goToSignUp(){
        new HomePage(getDriver()).clickBtnSignUpHeader();
        signUpPage= new SignUpPage(getDriver());
    }

    @Test(groups = {"smoke", "user"})
    public void  registrationPositiveTest(){
        User user = positiveUser();
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());


    }

    @Test(dataProvider = "dataProviderUserFile", dataProviderClass = UserDP.class)
    public void  registrationPositiveTestWithDataProvider(User user){
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());


    }



    @Test(groups = {"negative"})
    public void registrationNegativeTest_emptyName(){
        User user = positiveUser();
        user.setFirstName("");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Name is required"));
    }

}
