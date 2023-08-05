package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlayListTest extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        homePage.openPlaylistByNumber(3).clickDeletePlaylistBtn();
        Assert.assertTrue(homePage.getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }
}