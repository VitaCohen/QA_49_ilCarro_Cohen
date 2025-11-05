package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.PropertiesReader;

public class TermsOfUsePage extends BasePage{

    public TermsOfUsePage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);

    }


}
