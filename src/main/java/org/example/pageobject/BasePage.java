package org.example.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public abstract class BasePage {

    //Base class for all tests

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // without this implementation we can't create webElements
        PageFactory.initElements(driver, this);
    }

    public void enterText(WebElement element, String textToEnter) {
        element.click();
        element.clear();
        element.sendKeys(textToEnter);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    protected String getRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
