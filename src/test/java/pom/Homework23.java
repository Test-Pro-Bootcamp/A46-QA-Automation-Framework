package pom;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework23 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String playlistName = "Daria46";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("daria.pavlyuk@testpro.io")
                 .providePassword("te$t$tudent")
                 .clickSubmitBtn();
        homePage.doubleClickFirstPlayList()
                .enterPlaylistName(playlistName );

        Assert.assertEquals(homePage.getPlaylistName(),playlistName );


    }

}
