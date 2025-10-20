package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    static WebDriver driver;

    public static void setDriver(){
    }

    public boolean elementIsDisplayed(WebElement element){
        return element.isDisplayed();
    }


}
