package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }



    @FindBy(css = "input[id='name']")
    WebElement inputName;

    @FindBy(css = "input[id='lastName']")
    WebElement inputLastName;

    @FindBy(css = "input[id='email']")
    WebElement inputEmail;

    @FindBy(css = "input[id='password']")
    WebElement inputPassword;

    @FindBy(css = "label[for='terms-of-use']")
    WebElement chekBoxAgree;

    @FindBy(css = " button[type='submit']")
    WebElement btnYallaRegistration;





    public void typeRegistrationForm(User user){
        inputName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        chekBoxAgree.click();
        btnYallaRegistration.click();

    }

}
