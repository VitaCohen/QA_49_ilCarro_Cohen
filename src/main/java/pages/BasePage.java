package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HeaderMenuItem;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    @FindBy(css = "div[class='error']")
    List<WebElement> listErrorElements;

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

    public static <T extends BasePage> T clickButtonHeader(HeaderMenuItem item){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(item.getLocator())));
        element.click();
        switch (item){
            case SEARCH -> {
                return (T) new HomePage(driver);
            }
            case LET_THE_CAR_WORK -> {
                return (T) new LetTheCarWorkPage(driver);
            }
            default -> throw new IllegalArgumentException("Invalid parameter headerMenuItem");
        }

    }

}
