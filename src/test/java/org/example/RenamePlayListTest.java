package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlayListTest extends BaseTest {

    String newPlaylistName = "Test Pro Edited Playlist";

    @Test
    public void renamePlaylist() {
      loginPage.provideEmail("demo@class.com");
      loginPage.providePassword("te$t$tudent");
      loginPage.clickSubmit();
      homePage.doubleClickPlaylistByNumber(5);
      homePage.enterNewPlaylistName(newPlaylistName);
      Assert.assertTrue(homePage.doesPlaylistExist(newPlaylistName));
    }
}