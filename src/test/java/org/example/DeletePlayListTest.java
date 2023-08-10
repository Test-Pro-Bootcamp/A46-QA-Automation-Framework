package org.example;

import org.example.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlayListTest extends BaseTest {

    @Test
    public void deletePlaylist() {
        loginPage = new LoginPage(getWebDriver());
        String deletedPlaylistMsg = "Deleted playlist";
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        homePage.openPlaylistByNumber(3).clickDeletePlaylistBtn();
        Assert.assertTrue(homePage.getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }
}