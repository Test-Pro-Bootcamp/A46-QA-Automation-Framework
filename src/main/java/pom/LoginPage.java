package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.security.auth.login.LoginContext;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver){
        super(givenDriver);
    }
    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("button[type='submit']");
    public void provideEmail(String email){

        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    public void providePassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password) ;

    }
    public void clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
    }
    public void login(){
//        provideEmail("daria.pavlyuk@testpro.io");
//        providePassword("te$t$tudent");
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
