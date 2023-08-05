package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlayListTest extends BaseTest {

    String newPlaylistName = "Test Pro Edited Playlist";

    @Test
    public void renamePlaylist() {
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        homePage.doubleClickPlaylistByNumber(6).enterNewPlaylistName(newPlaylistName);
        Assert.assertTrue(homePage.doesPlaylistExist(newPlaylistName));
    }
}