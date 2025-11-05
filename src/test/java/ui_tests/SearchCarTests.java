package ui_tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.LocalDate;

public class SearchCarTests extends ApplicationManager {

    HomePage homePage;

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(getDriver());

    }

    @Test
    public void searchPositiveTest() {
        String city = "Haifa";
        LocalDate dateFrom = LocalDate.of(2025, 12, 1);
        LocalDate dateTo = LocalDate.of(2025, 12, 22);

        homePage.typeSearchForm(city, dateFrom, dateTo);

//Homework 9
        // Assert.assertTrue(homePage.isFieldCityEmpty());
        Assert.assertTrue(homePage.validateUrl());
    }

    @Test // BUG
    public void searchNegativeTest_emptyCity() {
        String city = "";
        LocalDate dateFrom = LocalDate.of(2025, 12, 1);
        LocalDate dateTo = LocalDate.of(2025, 12, 22);

        homePage.typeSearchForm(city, dateFrom, dateTo);
        Assert.assertTrue(homePage.validateUrl());
    }


    @Test // BUG
    public void searchNegativeTest_wrongCity() {
        String city = "1111111";
        LocalDate dateFrom = LocalDate.of(2025, 12, 1);
        LocalDate dateTo = LocalDate.of(2025, 12, 22);

        homePage.typeSearchForm(city, dateFrom, dateTo);
        Assert.assertTrue(homePage.validateUrl());
    }

    @Test
    public void searchNegativeTest_pastDate() {
        String city = "Haifa";
        LocalDate dateFrom = LocalDate.of(2025, 01, 1);
        LocalDate dateTo = LocalDate.of(2025, 01, 22);

        homePage.typeSearchForm(city, dateFrom, dateTo);
        Assert.assertTrue(homePage.validateUrl());
    }

    @Test
    public void searchNegativeTest_invalidMonth() {
        String city = "Haifa";
        LocalDate dateFrom = LocalDate.of(2025, 13, 01);
        LocalDate dateTo = LocalDate.of(2025, 01, 22);

        homePage.typeSearchForm(city, dateFrom, dateTo);
        Assert.assertTrue(homePage.validateUrl());
    }

}
