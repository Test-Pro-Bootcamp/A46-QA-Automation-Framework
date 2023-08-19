package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {


    @Test
    public void deleteEmptyPlaylist() throws InterruptedException {
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
//    public void navigatetoPage() {
//        String url = baseUrl;
//        getWebDriver() .get(baseUrl);
//    }
        //step1
        //public void navigatetoPage() {
            //String url = "https://qa.koel.app/";
            //driver.get(url);
        //}

        //step2
        public void provideEmail (String email) {
            WebElement emailField = driver.findElement(By.cssSelector("[type ='email']"));
            emailField.click();
            emailField.sendKeys(email);

        }
        //step3
        public void providePassword(String password) {
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys(password);

        }
        //step4
        public void clickSubmit()  {
            WebElement submit = driver.findElement(By.cssSelector("[type ='submit']"));
            submit.click();

        }
        //step5
        public void choosePlaylist (String playlistName) throws InterruptedException {
            WebElement playlistNameElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(12) > a"));
            playlistNameElement.click();
            Thread.sleep(2000);
        }
        //step6
    public void deletePlaylist() throws InterruptedException{
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
        Thread.sleep(2000);
    }
         //step7
    public WebElement getDeletePlaylistMessage () {
        return driver.findElement(By.cssSelector("div.success.show"));

    }
    void assertDeletedPlaylistMessageIsDisplayed(){
        //Assert.assertTrue(deletedPlaylistMessage.isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.success.show")).isDisplayed());


    }
    }



