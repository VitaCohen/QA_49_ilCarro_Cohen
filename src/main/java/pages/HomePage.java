package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;
import utils.enums.FooterMenuItem;
import utils.enums.HeaderMenuItem;

import java.time.Duration;
import java.time.LocalDate;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        setDriver(driver);
        // driver.get("https://ilcarro.web.app/search");
        driver.get(PropertiesReader.getProperty("base.properties", "baseUrl"));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//a[text()=' Log in ']")
    WebElement btnLginHeader;

    @FindBy(xpath = "//a[text()=' Sign up ']")
    WebElement btnSignUpHeader;

    @FindBy(id = "city")
    WebElement inputCity;

    @FindBy(id = "dates")
    WebElement inputDates;

    @FindBy(xpath = "//button[@type ='submit']")
    WebElement btnYalla;


    public void clickBtnLoginHeader(HeaderMenuItem login) {

        btnLginHeader.click();
    }

    public void clickBtnSignUpHeader() {
        btnSignUpHeader.click();
    }


    public void typeSearchForm(String city, LocalDate dateFrom, LocalDate dateTo) {
        inputCity.sendKeys(city);
        System.out.println(dateFrom.toString());
        String dates = dateFrom.getMonthValue() + "/" + dateFrom.getDayOfMonth()
                + "/" + dateFrom.getYear() + " - "
                + dateTo.getMonthValue() + "/" + dateTo.getDayOfMonth()
                + "/" + dateTo.getYear();
        inputDates.sendKeys(dates);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")");
        pause(2);
        //btnYalla.click();
        clickWait(btnYalla, 3);

    }

    public void typeSearchFormWOJS(String city, LocalDate dateFrom, LocalDate dateTo) {
        inputCity.sendKeys(city);
        System.out.println(dateFrom.toString());
        String dates = dateFrom.getMonthValue() + "/" + dateFrom.getDayOfMonth()
                + "/" + dateFrom.getYear() + " - "
                + dateTo.getMonthValue() + "/" + dateTo.getDayOfMonth()
                + "/" + dateTo.getYear();
        inputDates.sendKeys(dates);
        //clickWait(btnYalla, 3);
        btnYalla.click();

    }


    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement calendarBtnYear;

    private String monthCreate(String month) {
        StringBuilder result = new StringBuilder();
        return result.append(month.substring(0, 1).toUpperCase())
                .append(month.substring(1).toLowerCase()).toString();
    }

    private void typeCalendar(LocalDate date) {
        calendarBtnYear.click();
        String year = Integer.toString(date.getYear());  //2025   2026
        WebElement btnYear = driver.findElement(By.xpath("//td[@aria-label='" + year + "']"));
        //  "//td[@aria-label='"+year+"']" --> "//td[@aria-label='"   "2026"   "']" -->  //td[@aria-label='2026']
        btnYear.click();
        //   //td[@aria-label="December 2025"]
        String month = date.getMonth().toString();
        month = monthCreate(month);
        WebElement btnMonth = driver.findElement(By.xpath("//td[@aria-label='" + month + " " + year + "']"));
        btnMonth.click();
        // //div[text()=' 1 ']
        String day = String.valueOf(date.getDayOfMonth());
        String date1 = month + " " + day + ", " + year;
        System.out.println(date1);
        WebElement btnDay = driver.findElement(
                By.xpath("//td[@aria-label='" + date1 + "']"));
        btnDay.click();
    }

//        String day = String.valueOf(date.getDayOfMonth());
//        WebElement btnDay = driver.findElement
//                (By.xpath("//td[contains(@aria-label,'" + month + " " + day + ", " + year + "')]"));
//      btnDay.click();



public void typeSearchFormCalendar(String city, LocalDate dateFrom, LocalDate dateTo) {

    inputCity.sendKeys(city);
    inputDates.click();
    pause(5);
    typeCalendar(dateFrom);
    pause(3);
    typeCalendar(dateTo);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")");
    btnYalla.click();
}


    // Homework 9

    public boolean isFieldCityEmpty() {
        String valueCity = inputCity.getAttribute("city");
        if (valueCity == null || valueCity.trim().isEmpty()) {
            return true;
        }
        return false;
    }


    public boolean validateUrl() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("results"));
    }

    public boolean clickFooterItem(FooterMenuItem item, String title){
        driver.findElement(By.cssSelector(item.getLocator())).click();
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleContains(title));
    }


}
