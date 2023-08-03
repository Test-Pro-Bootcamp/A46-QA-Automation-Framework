package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class ProfilePage extends BasePage {

    private static final By PROFILE_NAME_INOUT = By.id("inputProfileName");
    private static final By CURRENT_PASSWORD_INPUT = By.id("inputProfileCurrentPassword");
    private static final By NEW_PASSWORD_INPUT = By.id("inputProfileNewPassword");
    private static final By EMAIL_INPUT = By.id("inputProfileEmail");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void enterText(By elementBy, String textToEnter) {
        WebElement email = findElement(elementBy);
        email.click();
        email.clear();
        email.sendKeys(textToEnter);
    }

    public void changePassword(String currentPassword, String newPassword, String email) {
        enterText(PROFILE_NAME_INOUT, getRandomString());
        enterText(CURRENT_PASSWORD_INPUT, currentPassword);
        enterText(NEW_PASSWORD_INPUT, newPassword);
        enterText(EMAIL_INPUT, email);
    }


    String getRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
