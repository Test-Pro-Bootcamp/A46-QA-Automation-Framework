package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //By emailFieldLocator = By.cssSelector("[type='email']");
    @FindBy(css = "[type='email']")
    private WebElement emailField;

    //By passwordFieldLocator = By.cssSelector("[type='password']");
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    //By submitButtonLocator = By.cssSelector("button[type='submit']");
    @FindBy(css = "button[type='submit']")
    private WebElement submitButtonLocator;
    public void  login() {
        provideEmail("daria.pavlyuk@testpro.io");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitBtn() {

        submitButtonLocator.click();
        return this;
    }

    //public void login() {
        //provideEmail("demo@class.com");
       // providePassword("te$t$tudent");
        //clickSubmitBtn();
   // }
}
    //public void provideEmail(String email){

        //driver.findElement(emailField).sendKeys(email);
    //}
    //public void providePassword(String password){
        //driver.findElement(passwordField).sendKeys(password) ;

    //}
    //public void clickSubmitBtn(){
        //driver.findElement(submitButtonLocator).click();
    //}


