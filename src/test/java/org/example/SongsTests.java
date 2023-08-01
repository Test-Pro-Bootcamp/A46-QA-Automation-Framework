package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        loginPage.login("demo@class.com", "te$t$tudent");
        String song = "Reactor";
        homePage.searchSong(song);
        homePage.clickViewAllButton();
        homePage.clickFirstSongInTheList();
        homePage.clickAddToButton();
        String playlistName = generateRandomPlaylistName();
        System.out.println(playlistName);
        homePage.fillNewPlayListName(playlistName);
        homePage.clickSaveButton();
        Assert.assertTrue(homePage.isSuccessMessageDisplayed());
        Assert.assertEquals(homePage.getPlayListName(), playlistName);
        Assert.assertEquals(song, homePage.getSongName());
    }
}