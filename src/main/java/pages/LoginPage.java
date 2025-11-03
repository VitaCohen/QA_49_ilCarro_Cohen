package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    @FindBy(xpath = "//h2[text()='Logged in success']")
    WebElement popUpTextLoggedSuccess;

    @FindBy(xpath = "//h2[contains(text(),'Login or Password incorrect')]")
    WebElement popUpTextLoggedIncorrect;

    @FindBy(xpath = "//span[text() = 'Click here']")
    WebElement btnNotRegistered;


    //Homework_7
   // @FindBy(xpath = "//div[@class = 'error']")
   // WebElement textErrorUnderFieldEmail;

   // @FindBy(xpath = "//div[contains(text(), 'Password is required')]")
   // WebElement textRequiredUnderFieldEmail;

      // public void typeLoginFormWrongEmail(User user) {
       // inputEmail.sendKeys(user.getUsername());
        //inputPassword.click();
  //  }

  //  public boolean isEmailWrong() {
//return elementIsDisplayed(textErrorUnderFieldEmail);
   // }

    //public void typeLoginFormWithoutPassword(User user) {
    //    inputEmail.sendKeys(user.getUsername());
     //   inputPassword.click();
      //  btnYalla.click();
   // }

   // public boolean isPasswordRequired() {
       // return elementIsDisplayed(textRequiredUnderFieldEmail);
   // }
//=======================================================//


    public void clickBtnNotRegistered(){
        btnNotRegistered.click();
    }

    baseUrl=https://ilcarro.web.app/search
    login=iv@mail.com
            password=123456Aa!

    public void typeLoginForm(User user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnYalla.click();
    }

    public boolean isLoggedDisplayed() {

        return elementIsDisplayed(popUpTextLoggedSuccess);
    }

    public boolean isLoggedIncorrect() {
        return elementIsDisplayed(popUpTextLoggedIncorrect);
    }




}
