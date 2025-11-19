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

    @Test
    public void addNewCarNegativeTest_woModel(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("BMW-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Model is required"));
    }

    @Test
    public void addNewCarNegativeTest_YearMinus(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("-1")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("BMW-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Wrong year"));
    }

    @Test
    public void addNewCarNegativeTest_WOYear(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("BMW-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Year required"));
    }

    @Test  //(BUG)
    public void addNewCarNegativeTest_WrongYear(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("0")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("BMW-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Wrong year"));
    }

    @Test
    public void addNewCarNegativeTest_FutureYear(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2026")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .serialNumber("BMW-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Wrong year"));
    }

    @Test
    public void addNewCarNegativeTest_NumberOfSeatsMinus(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(-1)
                .carClass("C")
                .serialNumber("BMW -"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Car must have min 2 seat"));
    }

    @Test
    public void addNewCarNegativeTest_TooMuchSeats(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(21)
                .carClass("C")
                .serialNumber("BMW -"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("To much seats"));
    }


    @Test
    public void addNewCarNegativeTest_WOClassCar(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(20)
                .carClass("")
                .serialNumber("BMW -"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Car class is required"));
    }

    @Test
    public void addNewCarNegativeTest_WORegistrationNumber(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(6)
                .carClass("A")
                .serialNumber("")
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Car registration number is required"));
    }

    @Test
    public void addNewCarNegativeTest_TooLongRegistrationNumber(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(6)
                .carClass("A")
                .serialNumber("01234567890123456")
                .pricePerDay(100.77)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("To long car registration number"));
    }

    @Test
    public void addNewCarNegativeTest_PriceIsMinus(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(6)
                .carClass("A")
                .serialNumber("BMW - "+ new Random().nextInt(10000))
                .pricePerDay(-11.0)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Price must be positive"));
    }


    @Test
    public void addNewCarNegativeTest_TooBigPrice(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(6)
                .carClass("A")
                .serialNumber("BMW - "+ new Random().nextInt(10000))
                .pricePerDay(1000.01)
                .about("about")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("To much big price"));
    }

    @Test  //(BUG)
    public void addNewCarNegativeTest_AboutIsMoreThan500symbols(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("BMW")
                .model("X-5")
                .year("2020")
                .fuel("Petrol")
                .seats(6)
                .carClass("A")
                .serialNumber("BMW - "+ new Random().nextInt(10000))
                .pricePerDay(100.2)
                .about("Comfortable and reliable, this car is perfect for city trips and long journeys. Featuring smooth handling, great fuel efficiency, and a spacious, clean interior, it provides a pleasant experience for every driver. Modern safety systems, powerful air conditioning, and Bluetooth connectivity ensure convenience and confidence for all who rent it. This versatile vehicle offers extra storage space, responsive brakes, and a comfortable seating position, making every trip smoother and more enjoyable for.")
                .image("004.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Too long descriptions"));
    }





}
