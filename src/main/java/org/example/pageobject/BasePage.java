package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(By elementBy, String textToEnter) {
        WebElement email = getWebDriver().findElement(elementBy);
        email.click();
        email.clear();
        email.sendKeys(textToEnter);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public WebElement findElement(By selector) {
        return getWebDriver().findElement(selector);
    }

    public List<WebElement> findElements(By selector) {
        return getWebDriver().findElements(selector);
    }
}
