package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void deleteEmptyPlaylist() {
        //navigatetoPage();
        provideEmail("daria.pavlyuk@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        String playlistName = "Daria's playlist";
        choosePlaylist(playlistName);
        deletePlaylist();
        getDeletePlaylistMessage();
        assertDeletedPlaylistMessageIsDisplayed();

    }
    //step1
    public void navigatetoPage() {
        String url = baseUrl;
        getWebDriver() .get(baseUrl);
    }

    //step2
    public void provideEmail (String email){
        WebElement emailField = getWebDriver() .findElement(By.cssSelector("[type ='email']"));
        emailField.click();
        emailField.sendKeys(email);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type ='email']")));
    }
    //step3
    public void providePassword(String password) {
        WebElement passwordField = getWebDriver() .findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type='password']")));
    }
    //step4
    public void clickSubmit() {
        WebElement submit = getWebDriver().findElement(By.cssSelector("[type ='submit']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type ='submit']")));
        submit.click();
    }
    //step5
    public void choosePlaylist (String playlistName)  {
        WebElement playlistNameElement = getWebDriver() .findElement(By.cssSelector("#playlists > ul > li:nth-child(12) > a"));
        playlistNameElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(12) > a") ) );
    }
    //step6
    public void deletePlaylist() {
        WebElement deletePlaylistButton = getWebDriver() .findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".btn-delete-playlist") ));

    }
    //step7
    public WebElement getDeletePlaylistMessage () {
        return getWebDriver() .findElement(By.cssSelector("div.success.show"));

    }
    void assertDeletedPlaylistMessageIsDisplayed(){
        //Assert.assertTrue(deletedPlaylistMessage.isDisplayed());
        Assert.assertTrue(getWebDriver() .findElement(By.cssSelector("div.success.show")).isDisplayed());


    }
}





