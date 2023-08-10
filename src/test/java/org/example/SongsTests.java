package org.example;

import org.example.pageobject.HomePage;
import org.example.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        loginPage = new LoginPage(getWebDriver());
        homePage = new HomePage(getWebDriver());
        loginPage.login("demo@class.com", "te$t$tudent");
        String song = "Reactor";
        homePage.searchSong(song)
                .clickViewAllButton()
                .clickFirstSongInTheList()
                .clickAddToButton();
        String playlistName = generateRandomPlaylistName();
        System.out.println(playlistName);
        homePage.fillNewPlayListName(playlistName)
                .clickSaveButton();
        Assert.assertTrue(homePage.isSuccessMessageDisplayed());
        Assert.assertEquals(homePage.getPlayListName(), playlistName);
        Assert.assertEquals(song, homePage.getSongName());
    }
}