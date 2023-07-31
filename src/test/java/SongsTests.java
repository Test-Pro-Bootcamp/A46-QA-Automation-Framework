import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        // login
        login("demo@class.com", "te$t$tudent");
        //search for song
        String song = "Reactor";
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(song);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        // click View All
        WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='view-all-songs-btn']")));
        viewAllBtn.click();
        // click first song in the list
        WebElement songInResults = driver.findElement(By.cssSelector(".search-results .song-item .title"));
        songInResults.click();
        // click Add To btn
        WebElement addToBtn = driver.findElement(By.cssSelector("#songResultsWrapper .btn-add-to"));
        addToBtn.click();
        // create a playlist name
        String playlistName = generateRandomPlaylistName();
        System.out.println(playlistName);
        // create a playlist
        WebElement inputNewPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper [data-test='new-playlist-name']"));
        inputNewPlaylist.click();
        inputNewPlaylist.clear();
        inputNewPlaylist.sendKeys(playlistName);
        WebElement saveBtn = driver.findElement(By.cssSelector("#songResultsWrapper [type='submit']"));
        saveBtn.click();
        // assertions:
        // success banner
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
        // playlist name is equal our unique playlist name
        WebElement header = driver.findElement(By.cssSelector("#playlistWrapper h1"));
        String playlistHeader = header.getText();
        Assert.assertEquals(playlistHeader, playlistName);
        // playlist contains our song
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        Assert.assertEquals(song, songText);
    }
}
