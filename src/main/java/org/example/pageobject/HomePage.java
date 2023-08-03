package org.example.pageobject;

import org.example.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.ActionsUtil.clickEnterButton;
import static org.example.utils.ActionsUtil.doubleClickToElement;
import static org.example.utils.WaitUtil.waitUntilElementToBeClickable;
import static org.example.utils.WaitUtil.waitUntilElementToBeVisible;

public class HomePage extends BasePage {
    private static final By AVATAR = By.cssSelector("#userBadge");
    private static final By PLAY_LIST_ITEM = By.cssSelector(".playlist");
    private static final By PLAY_LIST_NAME_INPUT = By.cssSelector("[name='name']");
    private static final String PLAY_LIST_NAME = "//a[text()='%s']";
    private static final By SEARCH_INPUT = By.cssSelector("[type='search']");
    private static final By VIEW_ALL_BUTTON = By.cssSelector("[data-test='view-all-songs-btn']");
    private static final By FIRST_SONG_ITEM = By.cssSelector(".search-results .song-item .title");
    private static final By ADD_TO_BUTTON = By.cssSelector("#songResultsWrapper .btn-add-to");
    private static final By NEW_PLAY_LIST_NAME = By.cssSelector("#songResultsWrapper [data-test='new-playlist-name']");
    private static final By SAVE_BUTTON = By.cssSelector("#songResultsWrapper [type='submit']");
    private static final By DELETE_PLAYLIST_BUTTON = By.cssSelector(".btn-delete-playlist");
    private static final By SUCCESS_MESSAGE = By.cssSelector("div.success.show");
    private static final By PLAY_LIST_HEADER = By.cssSelector("#playlistWrapper h1");
    private static final By SONG_NAME = By.cssSelector("#playlistWrapper .song-item .title");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAvatar() {
        return findElement(AVATAR);
    }

    public boolean isAvatarDisplayed() {
        return getAvatar().isDisplayed();
//        return driver.findElement(AVATAR).isDisplayed();
    }

    public void clickAvatar() {
        getAvatar().click();
//        driver.findElement(AVATAR).click();
    }

    public void openPlaylistByNumber(int number) {
        List<WebElement> playlists = findElements(PLAY_LIST_ITEM);
        playlists.get(number).click();
    }

    public void doubleClickPlaylistByNumber(int number) {
        List<WebElement> webElements = new ArrayList<>();
        webElements = findElements(PLAY_LIST_ITEM);
        waitUntilElementToBeClickable(getWebDriver(), webElements.get(number));
        doubleClickToElement(getWebDriver(), webElements.get(number));
    }

    public void enterNewPlaylistName(String newPlaylistName) {
        waitUntilElementToBeVisible(getWebDriver(), findElement(PLAY_LIST_NAME_INPUT));
        WebElement playlistInputField = findElement(PLAY_LIST_NAME_INPUT);
//       clear() does not work, element has an attribute of "required"
//       workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name

        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String newPlayListName) {
        waitUntilElementToBeVisible(getWebDriver(), findElement(By.xpath(String.format(PLAY_LIST_NAME, newPlayListName))));
        WebElement playlistElement = findElement(By.xpath(String.format(PLAY_LIST_NAME, newPlayListName)));
        return playlistElement.isDisplayed();
    }

    public void searchSong(String songName) {
        WebElement searchInput = findElement(SEARCH_INPUT);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(songName);
        clickEnterButton(getWebDriver());
        // click Enter
    }

    public void clickViewAllButton() {
        WebElement viewAllBtn = findElement(VIEW_ALL_BUTTON);
        waitUntilElementToBeClickable(getWebDriver(), viewAllBtn);
        viewAllBtn.click();
    }

    public void clickFirstSongInTheList() {
        WebElement songInResults = findElement(FIRST_SONG_ITEM);
        songInResults.click();
    }

    public void clickAddToButton() {
        WebElement addToBtn = findElement(ADD_TO_BUTTON);
        addToBtn.click();
    }

    public void fillNewPlayListName(String playListName) {
        WebElement inputNewPlaylist = findElement(NEW_PLAY_LIST_NAME);
        inputNewPlaylist.click();
        inputNewPlaylist.clear();
        inputNewPlaylist.sendKeys(playListName);
    }

    public void clickSaveButton() {
        WebElement saveBtn = findElement(SAVE_BUTTON);
        saveBtn.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = findElement(DELETE_PLAYLIST_BUTTON);
        deletePlaylist.click();
        WaitUtil.waitUntilElementNotToBeVisible(getWebDriver(), deletePlaylist);
    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = findElement(SUCCESS_MESSAGE);
        return notificationMsg.getText();
    }

    public boolean isSuccessMessageDisplayed() {
        WebElement successBanner = findElement(SUCCESS_MESSAGE);
        return successBanner.isDisplayed();
    }

    public String getPlayListName() {
        WebElement header = findElement(PLAY_LIST_HEADER);
        return header.getText();
    }

    public String getSongName() {
        WebElement songName = findElement(SONG_NAME);
        return songName.getText();
    }
}
