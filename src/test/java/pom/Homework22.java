package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String playlistName = "Daria46";
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver) ;

        loginPage.login();
        homePage.doubleClickFirstPlayList();
        homePage.enterPlaylistName(playlistName);
        //Assert.assertTrue(playlistName,getPlaylistName()) ;

        //String newPlaylistName = "Daria's Best Playlist 2";
        //@Test
        //public void renamePlaylist(){
        //provideEmail("daria.pavlyuk@testpro.io");
        // providePassword("te$t$tudent");
        //clickSubmit();
        //choosePlaylist();
        // doubleClickChoosePlaylist();
        //enterNewPlaylistName();
        //Assert.assertTrue(doesPlaylistExist()) ;

        // }
        //public void choosePlaylist ()  {
        //WebElement playlistNameElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(12) > a"));
        //playlistNameElement.click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(12) > a") ) );
        // }

        //public void doubleClickChoosePlaylist (){
        // WebElement playlistElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(11)") ) );
//        Actions actions = new Actions(driver);//we can remove this
        // actions.doubleClick(playlistElement).perform();

    }
    //// public void enterNewPlaylistName(){
    //WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']") );
    // playlistInputField.sendKeys((Keys.chord(Keys.COMMAND , "A", Keys.DELETE)));
    //playlistInputField.sendKeys(newPlaylistName);//let's use newPlaylistName variable we declared in line 11
    //playlistInputField.sendKeys(Keys.ENTER );

    //  }
    //public boolean doesPlaylistExist() {
       // WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), \"" + playlistName + "\")]")));
        //return playlistElement.isDisplayed();
    //}
}




