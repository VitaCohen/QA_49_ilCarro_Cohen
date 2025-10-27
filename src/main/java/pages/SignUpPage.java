package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(id = "name")
    WebElement inputName;

    @FindBy(id = "lastName")
    WebElement inputLastName;

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement checkBoxIAgree;

    @FindBy(css = "button[type='submit']")
    WebElement btnYalla;

    @FindBy(xpath = "//mat-dialog-container//h2")
    WebElement textDialogContainer;


    public boolean isTextDialogContainerPresent(){
        return elementIsDisplayed(textDialogContainer);
    }


    public void  clickBtnYalla(){
        btnYalla.click();
    }


    public void typeLoginForm(User user) {
        inputName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickCheckBox() {
        checkBoxIAgree.click();
    }

    public void clickCheckBoxWithActions() {
        Actions actions = new Actions(driver);
        // actions.moveToElement(checkBoxIAgree, -50, 0)
        // .click().perform();
        int y = checkBoxIAgree.getSize().getHeight();
        int x = checkBoxIAgree.getSize().getWidth();
        System.out.println(x + " = x, " + y + " = y");

        actions.moveToElement(checkBoxIAgree, -(x / 10 * 4), -(y / 4))
                .click().perform();

    }


}
