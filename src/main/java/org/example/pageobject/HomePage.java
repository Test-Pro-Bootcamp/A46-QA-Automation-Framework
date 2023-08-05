package org.example.pageobject;

import org.example.utils.WaitUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.example.utils.ActionsUtil.clickEnterButton;
import static org.example.utils.ActionsUtil.doubleClickToElement;
import static org.example.utils.WaitUtil.waitUntilElementToBeClickable;
import static org.example.utils.WaitUtil.waitUntilElementToBeVisible;

public class HomePage extends BasePage {

    @FindBy(css = "#userBadge")
    private WebElement avatar;

    @FindBy(css = ".playlist")
    private List<WebElement> playListItems;

    @FindBy(css = "[name='name']")
    private WebElement playLustItemName;

    @FindBy(css = "[type='search']")
    private WebElement searchInput;

    @FindBy(css = "[data-test='view-all-songs-btn']")
    private WebElement viewAllButton;

    @FindBy(css = ".search-results .song-item .title")
    private WebElement firstSongItem;

    @FindBy(css = "#songResultsWrapper .btn-add-to")
    private WebElement addToButton;

    @FindBy(css = "#songResultsWrapper [data-test='new-playlist-name']")
    private WebElement newPlayListName;

    @FindBy(css = "#songResultsWrapper [type='submit']")
    private WebElement saveButton;

    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlayListButton;

    @FindBy(css = "div.success.show")
    private WebElement successMessage;

    @FindBy(css = "#playlistWrapper h1")
    private WebElement playListHeader;

    @FindBy(css = "#playlistWrapper .song-item .title")
    private WebElement songName;

    @FindBy(css = ".ok")
    private WebElement dialogOkButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAvatar() {
        return avatar;
    }

    public boolean isAvatarDisplayed() {
        return getAvatar().isDisplayed();
//        return driver.findElement(AVATAR).isDisplayed();
    }

    public void clickAvatar() {
        getAvatar().click();
//        driver.findElement(AVATAR).click();
    }

    public HomePage openPlaylistByNumber(int number) {
        playListItems.get(number).click();
        return this;
    }

    public HomePage doubleClickPlaylistByNumber(int number) {
        waitUntilElementToBeClickable(getWebDriver(), playListItems.get(number));
        doubleClickToElement(getWebDriver(), playListItems.get(number));
        return this;
    }

    public void enterNewPlaylistName(String newPlaylistName) {
        waitUntilElementToBeVisible(getWebDriver(), playLustItemName);
//       clear() does not work, element has an attribute of "required"
//       workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playLustItemName.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playLustItemName.sendKeys(newPlaylistName);
        playLustItemName.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String newPlayListName) {
        //use List<WebElements>
        waitUntilElementToBeVisible(getWebDriver(), playListItems.get(0));
        List<String> playListNames = new ArrayList<>();
        for (int i = 0; i < playListItems.size(); i++) {
            playListNames.add(playListItems.get(i).getText());
        }
        return new HashSet<>(playListNames).contains(newPlayListName);
    }

    public HomePage searchSong(String songName) {
        enterText(searchInput, songName);
        clickEnterButton(getWebDriver());
        return this;
        // click Enter
    }

    public HomePage clickViewAllButton() {
        waitUntilElementToBeClickable(getWebDriver(), viewAllButton);
        viewAllButton.click();
        return this;
    }

    public HomePage clickFirstSongInTheList() {
        firstSongItem.click();
        return this;
    }

    public HomePage clickAddToButton() {
        addToButton.click();
        return this;
    }

    public HomePage fillNewPlayListName(String playListName) {
        enterText(newPlayListName, playListName);
        return this;
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public HomePage clickDeletePlaylistBtn() {
        deletePlayListButton.click();
        dialogOkButton.click();
        WaitUtil.waitUntilElementNotToBeVisible(getWebDriver(), deletePlayListButton);
        return this;
    }

    public String getDeletedPlaylistMsg() {
        return successMessage.getText();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public String getPlayListName() {
        return playListHeader.getText();
    }

    public String getSongName() {
        return songName.getText();
    }
}
