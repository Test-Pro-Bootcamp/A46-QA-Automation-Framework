package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    String playlistName = "Daria46";
     //private By userAvatarIcon = By.cssSelector("img.avatar");
    @FindBy(css = "img[class = 'avatar']")
    WebElement avatarIcon;
    //private By playlistNamefield = By.cssSelector("[name='name']");
    @FindBy (css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    //private By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    @FindBy (css="[name='name']")
    WebElement playlistNameField ;

    @FindBy (css="div.success.show")
    WebElement popUpMessage ;


    //public boolean getUserAvatar() {
        //return findElement((WebElement) userAvatarIcon).isDisplayed();
    //}
    //public void doubleClickFirstPlaylist() {
        //WebElement firstPlaylistInput = driver.findElement(firstPlaylist);
           // doubleClick(firstPlaylistInput);
        //}
public HomePage doubleClickPlaylist(){
    doubleClick(firstPlaylist );
    return this;
}
        public HomePage enterPlaylistName(String playlistName){
        //WebElement playlistNameInput = driver.findElement(playlistNameField);
            findElement(playlistNameField).sendKeys(playlistName);
            findElement(playlistNameField ).sendKeys((Keys.chord(Keys.COMMAND, "A", Keys.DELETE)));
            findElement(playlistNameField ).sendKeys(playlistName);
            findElement(playlistNameField ).sendKeys(Keys.ENTER);
            return this;
        }
        public String getPlaylistName () {
            //WebElement playlistName = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
            findElement(popUpMessage);
            return findElement(firstPlaylist).getText() ;
        }
       // public boolean doesPlaylistExist (String playlistName){
            //WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
            //return playlistElement.isDisplayed();
        //}
public boolean isAvatarDisplayed(){
    return avatarIcon.isDisplayed() ;
}
        public HomePage  doubleClickFirstPlayList() {
            doubleClick(firstPlaylist);
            return this;
        }

    }



