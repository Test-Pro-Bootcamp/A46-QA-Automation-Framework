package pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public abstract class BaseTest {
    public WebDriver  driver;
    public WebDriverWait wait;
    public Actions actions;
    public String url = null;
    protected static LoginPage loginPage;
    protected static HomePage homePage;
    //@BeforeSuite
    //public void setupClass() {
    //   WebDriverManager.chromedriver().setup();
    //}

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void setupBrowser(String baseUrl) throws MalformedURLException {
        //      ChromeOptions options = new ChromeOptions();
        //     options.addArguments("--remote-allow-origins=*");
        //   options.addArguments("--disable-notifications");
        //   options.addArguments("--start-maximized");
        // driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseUrl;//pass parameter baseUrl
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
//        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);

    }


    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.178:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari": // gradle clean test -Dbrowser=grid-safari
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "lambda": // gradle clean test -Dbrowser=lambda
                return getLambdaDriver();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                // options.addArguments("--headless=new");
                return driver = new ChromeDriver(options);
        }
    }
    public WebDriver getLambdaDriver() throws MalformedURLException {
        String userName = "pavlyuk.daria81";
        String authKey = "fyipWm6hV2KISCPnsQTtgjN7VEyA8QKCkDPAhVP8LI31j5VY8I";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "106.0");
        capabilities.setCapability("resolution", "1024x768");
        capabilities.setCapability("build", "TestNG With Java");
        capabilities.setCapability("name", this.getClass().getName());
        capabilities.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + userName + ":" + authKey + hub), capabilities);
    }

    public void provideEmail(String email) {
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

    public String getPlaylistName() {
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        return playlistElement.getText();
    }
    @AfterMethod
    public void closeBrowser(){
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
