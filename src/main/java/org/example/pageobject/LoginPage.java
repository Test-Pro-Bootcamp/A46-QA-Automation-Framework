package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.utils.WaitUtil.waitUntilElementToBeClickable;
import static org.example.utils.WaitUtil.waitUntilElementToBeVisible;

public class LoginPage extends BasePage {

    private static final By EMAIL_INPUT = By.cssSelector("[type='email']");
    private static final By PASSWORD_INPUT = By.cssSelector("[type='password']");
    private static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    public void enterEmail(String emailValue) {
        enterText(EMAIL_INPUT, emailValue);
    }

    public void enterPassword(String passwordValue) {
        enterText(PASSWORD_INPUT, passwordValue);
    }

    public void clickSubmit() {
        waitUntilElementToBeClickable(getWebDriver(), findElement(SUBMIT_BUTTON));
        WebElement submit = findElement(SUBMIT_BUTTON);
        submit.click();
    }

    public void provideEmail(String email) {
        waitUntilElementToBeVisible(getWebDriver(), findElement(EMAIL_INPUT));
        WebElement emailField = findElement(EMAIL_INPUT);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        waitUntilElementToBeVisible(getWebDriver(), findElement(PASSWORD_INPUT));
        WebElement passwordField = findElement(PASSWORD_INPUT);
        passwordField.clear();
        passwordField.sendKeys(password);
    }
}
