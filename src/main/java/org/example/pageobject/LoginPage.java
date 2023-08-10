package org.example.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.utils.WaitUtil.waitUntilElementToBeClickable;
import static org.example.utils.WaitUtil.waitUntilElementToBeVisible;

public class LoginPage extends BasePage {

    @FindBy(css = "[type='email']")
    private WebElement emailField;
//    driver.findElement(By.cssSelector("[type='email']"))

    @FindBy(css = "[type='password']")
    private WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    public LoginPage provideEmail(String email) {
        waitUntilElementToBeVisible(getWebDriver(), emailField);
        enterEmail(email);
        return this;
    }

    private void enterEmail(String emailValue) {
        enterText(emailField, emailValue);
    }

    private void enterPassword(String passwordValue) {
        enterText(passwordField, passwordValue);
    }

    public void clickSubmit() {
        waitUntilElementToBeClickable(getWebDriver(), submitButton);
        submitButton.click();
    }

    public LoginPage providePassword(String password) {
        waitUntilElementToBeVisible(getWebDriver(), passwordField);
        enterPassword(password);
        return this;
    }
}
