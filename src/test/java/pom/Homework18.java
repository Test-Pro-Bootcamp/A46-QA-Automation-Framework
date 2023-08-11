package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws MalformedURLException {

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
        getWebDriver() .get(url);
    }
    //step2
    public void provideEmail(String email) {
        WebElement emailField = getWebDriver() .findElement(By.cssSelector("[type ='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }
    //step3
    public void providePassword(String password) {
        WebElement passwordField = getWebDriver() .findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }
   //step4
   public void clickSubmit() {
        WebElement submit = getWebDriver() .findElement(By.cssSelector("[type ='submit']"));
        submit.click();
    }
    //step5
    public void searchSong (String songTitleKeyword){
        WebElement searchField = getWebDriver() .findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
    }
    //step6
    public void viewAllSearchResults () {
        WebElement viewAllSearchResults = getWebDriver() .findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResults.click();
    }

    //step7
    public void selectFirstSongResult() {
        WebElement viewAllFirstSongResult = getWebDriver() .findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        viewAllFirstSongResult.click();

    }

    //step8
        public void setButtonPlaySong () throws MalformedURLException {
            WebElement buttonPlayNextSong = getLambdaDriver() .findElement(By.cssSelector("[data-testid='play-next-btn']"));
            WebElement buttonPlaySong = getWebDriver() .findElement(By.cssSelector("[data-testid='play-btn']"));
            buttonPlayNextSong.click();
            buttonPlaySong.click();

        }
        //step9
        public boolean isDisplayedPlayingSong () {
            WebElement songIsPlaying = getWebDriver() .findElement(By.cssSelector("[data-testid='sound-bar-play']"));
            return songIsPlaying.isDisplayed();

        }

    }

