package ui_tests;

import dto.Car;
import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import utils.enums.HeaderMenuItem;

import java.util.Random;

public class LetCarWorkTests extends ApplicationManager {
    LoginPage loginPage;
    LetTheCarWorkPage letTheCarWorkPage;

    @BeforeMethod(alwaysRun = true)
    public void login() {
        User user = User.builder()
                .username("iv@mail.com")
                .password("123456Aa!")
                .build();
        new HomePage(getDriver()).clickButtonHeader(HeaderMenuItem.LOGIN);
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        //loginPage.clickBtnOk();
        letTheCarWorkPage = loginPage.clickButtonHeader(HeaderMenuItem.LET_THE_CAR_WORK);

    }

    @Test(groups = "smoke")
    public  void addNewCarPositiveTest(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("jpeg.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.btnOkPopUpPresent());

    }

    @Test
    public  void addNewCarNegativeTest_withoutManufacture(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("jpeg.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Make is required"));

    }



}
