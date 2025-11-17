package pages;

import dto.Car;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class LetTheCarWorkPage extends BasePage {

    public LetTheCarWorkPage(WebDriver driver) {
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(id = "pickUpPlace")
    WebElement inputLocations;
    @FindBy(id = "make")
    WebElement inputManufacture;
    @FindBy(id = "model")
    WebElement inputModel;
    @FindBy(id = "year")
    WebElement inputYear;
    @FindBy(id = "fuel")
    WebElement selectFuel;
    @FindBy(id = "seats")
    WebElement inputSeats;
    @FindBy(id = "class")
    WebElement inputClass;
    @FindBy(id = "serialNumber")
    WebElement inputSerialNumber;
    @FindBy(id = "price")
    WebElement inputPrice;

    @FindBy(id = "photos")
    WebElement inputPhoto;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;




    public void typeAddNewCarForm(Car car) {
        inputLocations.sendKeys(car.getCity());
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        typeFuel(car.getFuel());
        inputSeats.sendKeys(car.getSeats() + "");
        inputClass.sendKeys(car.getCarClass());
        inputSerialNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(car.getPricePerDay() + "");
        addPhoto(car.getImage());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")");
        btnSubmit.click();

    }

    private void typeFuel(String fuel) {
        Select select = new Select(selectFuel);
        select.selectByValue(fuel);
    }

    private void addPhoto(String fileName){
        inputPhoto.sendKeys(
                new File("src/test/resources"+File.separator+fileName)
                        .getAbsolutePath());
    }

public  boolean btnOkPopUpPresent(){
        return elementIsDisplayed(btnOkPopUp);

}

}
