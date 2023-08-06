package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    String playlistName = "Daria46";
     private By userAvatarIcon = By.cssSelector("img.avatar");
    private By playlistNamefield = By.cssSelector("[name='name']");
    private By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    public boolean getUserAvatar() {
        return findElement((WebElement) userAvatarIcon).isDisplayed();
    }
    public void doubleClickFirstPlaylist() {
        WebElement firstPlaylistInput = driver.findElement(firstPlaylist);
            doubleClick(firstPlaylistInput);
        }

        public void enterPlaylistName(String playlistName){
        WebElement playlistNameInput = driver.findElement(playlistNamefield);
        findElement(playlistNameInput).sendKeys(playlistName);
            findElement(playlistNameInput).sendKeys((Keys.chord(Keys.COMMAND, "A", Keys.DELETE)));
            findElement(playlistNameInput).sendKeys(playlistName);
            findElement(playlistNameInput).sendKeys(Keys.ENTER);

        }
        public String getPlaylistName () {
            WebElement playlistName = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
            return playlistName.getText();

        }
        public boolean doesPlaylistExist (String playlistName){
            WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
            return playlistElement.isDisplayed();
        }

        public void doubleClickFirstPlayList() {
            doubleClick(driver.findElement(firstPlaylist));
        }
    }


