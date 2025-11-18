package ui_tests;

import dto.Car;
import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.TestNGListener;
import utils.enums.HeaderMenuItem;

import java.util.Random;

@Listeners(TestNGListener.class)
public class LetTheCarWorkTests extends ApplicationManager {


    static HomePage homePage;
    static LoginPage loginPage;
    static LetTheCarWorkPage letTheCarWorkPage;

    @BeforeMethod
    public static void login() {
        User positiveUser = User.builder()
                .username("iv@mail.com").password("123456Aa!")
                .build();
        homePage = new HomePage(getDriver());
        loginPage = BasePage.clickButtonHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(positiveUser);
        letTheCarWorkPage = BasePage.clickButtonHeader(HeaderMenuItem.LET_THE_CAR_WORK);

    }

    @Test
    public static void addNewCarPositiveTest() {
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.btnOkPopUpPresent());
    }


    @Test
    public void addNewCarNegativeTest_woManufacture(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("")
                .model("Astra")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Make is required"));
    }

}
