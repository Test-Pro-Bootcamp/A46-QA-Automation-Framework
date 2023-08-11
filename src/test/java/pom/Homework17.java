package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
        @Test
        public void addSongtoPlaylist() {

            String url = "https://qa.koel.app/";
            getWebDriver().get(url);
            //String newSongAddedNotification = "Added 1 song into";
            navigatetoPage();
            provideEmail("daria.pavlyuk@testpro.io");
            providePassword("te$t$tudent");
            clickSubmit();
            String songTitleKeyword = "Pluto";
            searchSong("Pluto");
            viewAllSearchResults();
            selectFirstSongResult();
            clickAddButton();
            String newSongAddedNotification = "Added 1 song into";
            String playlistName = "Daria's playlist";
            choosePlaylist(playlistName);
            //Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));



        }

    //public String  getNotificationText() {
            //WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
            //return notificationText.getText() ;
    //}

    public void choosePlaylist(String playlistName) {
        WebElement playlistNameElement = getWebDriver() .findElement(By.cssSelector("#playlists > ul > li:nth-child(12) > a"));
        playlistNameElement.click();
    }

    public void clickSubmit() {
        WebElement submit = getWebDriver() .findElement(By.cssSelector("[type = 'submit']"));
        submit.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = getWebDriver() .findElement(By.cssSelector("[type='password']"));
           passwordField.click();
           passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = getWebDriver() .findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);

    }

    public void navigatetoPage() {
        String url = "https://qa.koel.app/";
        getWebDriver() .get(url);
    }


    public void clickAddButton() {
            WebElement addTo = getWebDriver() .findElement(By.cssSelector("button.btn-add-to") );
            addTo.click();
    }

    public void selectFirstSongResult() {
            WebElement viewAllFirstSongResult= getWebDriver() .findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
            viewAllFirstSongResult.click();

    }

    public void viewAllSearchResults() {
            WebElement viewAllSearchResults = getWebDriver() .findElement(By.cssSelector("div.results section.songs h1 button") ) ;
            viewAllSearchResults.click();
    }

    public void searchSong (String songTitleKeyword){
            WebElement searchField = getWebDriver() .findElement(By.cssSelector("div#searchForm input[type=search]") );
            searchField.sendKeys(songTitleKeyword );




}

}
