package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.HeaderMenuItem;
import utils.PropertiesReader;

import static pages.BasePage.*;

public class LetTheCarWorkTests extends ApplicationManager {


   static HomePage homePage;
    static LoginPage loginPage;
    static LetTheCarWorkPage letTheCarWorkPage;

                                                                      @BeforeMethod
    public static void login(){
        User positiveUser = User.builder()
                .username("iv@mail.com").password("123456Aa!")
                .build();
        homePage = new HomePage(getDriver());
        loginPage = BasePage.clickButtonHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(positiveUser);
        letTheCarWorkPage = BasePage.clickButtonHeader(HeaderMenuItem.LET_THE_CAR_WORK);

    }

@Test
    public static void addNewCarPositiveTest(){

}


}
