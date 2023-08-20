import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.BaseTest;
import pom.HomePage;
import pom.LoginPage;

import java.net.MalformedURLException;

public class Homework29 extends BaseTest {
    String newPlaylistName = "Daria46";
    @Test
    public void renamePlaylist(){
        LoginPage loginPage  = new LoginPage(driver) ;

    }
    @Test
    public void doesPlaylistExist(){
        String playlistName = "Daria46";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver );
        loginPage.provideEmail("daria.pavlyuk@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmitBtn() ;
        //add steps for renaming playlist if we want to use or check if the pop up message is visible
//        Assert.assertEquals(homePage.getPlaylistName(),playlistName );

        //checks if a playlist exists by playlist name
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));

    }
    @Test public void chooseAllSongsList(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver );
        loginPage.provideEmail("daria.pavlyuk@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmitBtn() ;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs") ));
        (driver).findElement(By.cssSelector("li a.songs") ).click() ;
    }
}