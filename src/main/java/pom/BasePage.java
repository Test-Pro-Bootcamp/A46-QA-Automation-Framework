package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    String playlistName = "Daria46";
    public BasePage(WebDriver givenDriver) {
        this.driver = givenDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);//addedPageFactory  initElements initialization
    }

    public void doubleClick(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator) );
        actions.doubleClick(locator).perform();
    }
    public WebElement findElement(WebElement  locator){
        return wait.until(ExpectedConditions.visibilityOf(locator));
        }
        public void click(By locator){
        findElement((WebElement) locator).click();
        }
        //actions.contextClick(findElement(locator)).perform();
    public String getPlaylistName(){
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)") ) ;
        return playlistElement.getText() ;
    }

//actions.contextClick(findElement(locator)).perform();
        }
