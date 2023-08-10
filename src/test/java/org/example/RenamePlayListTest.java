package org.example;

import org.example.pageobject.HomePage;
import org.example.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlayListTest extends BaseTest {
    String newPlaylistName = "Test Pro Edited Playlist";

    @Test
    public void renamePlaylist() {
        loginPage = new LoginPage(getWebDriver());
        homePage = new HomePage(getWebDriver());
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        homePage.doubleClickPlaylistByNumber(6).enterNewPlaylistName(newPlaylistName);
        Assert.assertTrue(homePage.doesPlaylistExist(newPlaylistName));
    }
}