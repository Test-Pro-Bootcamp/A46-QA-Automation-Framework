package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {

//        String url = "https://qa.koel.app/";
//        driver.get(url);
        navigatetoPage();
        provideEmail("daria.pavlyuk@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        String songTitleKeyword = "Pluto";
        searchSong("Pluto");
        viewAllSearchResults();
        selectFirstSongResult();
        setButtonPlaySong();
        Assert.assertTrue(isDisplayedPlayingSong());
    }

    //step1
    public void navigatetoPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    //step2
    public void provideEmail(String email) {
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
   public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("[type ='submit']"));
        submit.click();
    }
    //step5
    public void searchSong (String songTitleKeyword){
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
    }
    //step6
    public void viewAllSearchResults () {
        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResults.click();
    }

    //step7
    public void selectFirstSongResult() {
        WebElement viewAllFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        viewAllFirstSongResult.click();

    }

    //step8
        public void setButtonPlaySong () {
            WebElement buttonPlayNextSong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
            WebElement buttonPlaySong = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
            buttonPlayNextSong.click();
            buttonPlaySong.click();

        }
        //step9
        public boolean isDisplayedPlayingSong () {
            WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
            return songIsPlaying.isDisplayed();

        }

    }

