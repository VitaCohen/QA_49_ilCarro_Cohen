package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.enums.HeaderMenuItem;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    static WebDriver driver;

    public static void setDriver(WebDriver wd) {

        driver = wd;
    }

   // @FindBy(css = "div[class='error']")
   @FindBy(xpath = "//div[contains(@class,'error')]")
   List<WebElement> listErrorElements;

    @FindBy(xpath = "//mat-dialog-container//button")
    WebElement btnOkPopUp;

    public boolean isTextInErrorPresent(String text){
        if (listErrorElements == null || listErrorElements.isEmpty())
            return false;
        for (WebElement element:listErrorElements){
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public boolean elementIsDisplayed(WebElement element){

        return element.isDisplayed();
    }


    //Homework 7(28.10.25)

    public  static <T extends BasePage> T clickButtonHeader(HeaderMenuItem item){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(item.getLocator())));
        button.click();
        switch (item){
            case SEARCH -> {
                return (T) new HomePage(driver);
            }
            case SIGNUP -> {
                return (T) new SignUpPage(driver);
            }
            case LOGIN -> {
                return (T) new LoginPage(driver);
            }
            case LET_THE_CAR_WORK -> {
                return (T) new LetTheCarWorkPage(driver);
            }
            case TERMS_OF_USE -> {
                return (T) new TermsOfUsePage(driver);
            }

            default -> throw new IllegalArgumentException("Invalid parameter headerMenuItem");
        }

    }

    static  void pause(int time){
        try {
            Thread.sleep(time*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void clickWait(WebElement element, int time){
        new  WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public boolean urlContains(String fraction, int time) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.urlContains(fraction));
        }catch (TimeoutException e){
            e.printStackTrace();
            return false;
        }
    }


}
