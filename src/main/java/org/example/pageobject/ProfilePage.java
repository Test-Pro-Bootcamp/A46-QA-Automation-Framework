package org.example.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(id = "inputProfileName")
    private WebElement profileNameInput;

    @FindBy(id = "inputProfileCurrentPassword")
    private WebElement currentPasswordInput;

    @FindBy(id = "inputProfileNewPassword")
    private WebElement newPasswordInput;

    @FindBy(id = "inputProfileEmail")
    private WebElement emailInput;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void changePassword(String currentPassword, String newPassword, String email) {
        enterText(profileNameInput, getRandomString());
        enterText(currentPasswordInput, currentPassword);
        enterText(newPasswordInput, newPassword);
        enterText(emailInput, email);
    }
}
