package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pom.HomePage;
import pom.LoginPage;

import java.time.Duration;

public class BaseTest {
    public  WebDriver driver;
    public  WebDriverWait wait;
    public Actions actions;
    public String baseUrl;
    protected LoginPage loginPage ;
    protected HomePage homePage;
    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void setupBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         baseUrl = "https://qa.koel.app/";
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver) ;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }
    public void provideEmail (String email){
        WebElement emailField = driver.findElement(By.cssSelector("[type ='email']"));
        emailField.click();
        emailField.sendKeys(email);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type ='email']")));
    }
    //step3
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type='password']")));
    }
    //step4
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("[type ='submit']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type ='submit']")));
        submit.click();
    }
    public String getPlaylistName(){
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)") ) ;
        return playlistElement.getText() ;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "invalidLoginProviders")
    public Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "notExistingPassword"},
                {"daria.pavlyuk@testpro.io", ""},
                {"", ""},
        };
    }
}
