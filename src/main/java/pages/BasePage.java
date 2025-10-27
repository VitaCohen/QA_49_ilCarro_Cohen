package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
