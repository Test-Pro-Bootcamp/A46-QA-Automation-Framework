package org.example.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public final class ActionsUtil {

    private static Actions actions;

    public static void doubleClickToElement(WebDriver driver, WebElement element) {
        actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public static void clickEnterButton(WebDriver driver) {
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }
}
