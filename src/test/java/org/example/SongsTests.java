package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        // login
        loginPage.login("demo@class.com", "te$t$tudent");
        //search for song
        String song = "Reactor";
        homePage.searchSong(song);
        // click View All
        homePage.clickViewAllButton();
        // click first song in the list
        homePage.clickFirstSongInTheList();
        // click Add To btn
        homePage.clickAddToButton();
        // create a playlist name
        String playlistName = generateRandomPlaylistName();
        System.out.println(playlistName);
        // create a playlist
        homePage.fillNewPlayListName(playlistName);
        homePage.clickSaveButton();
        // assertions:
        // success banner
        Assert.assertTrue(homePage.isSuccessMessageDisplayed());
        // playlist name is equal our unique playlist name
        Assert.assertEquals(homePage.getPlayListName(), playlistName);
        // playlist contains our song
        Assert.assertEquals(song, homePage.getSongName());
    }
}