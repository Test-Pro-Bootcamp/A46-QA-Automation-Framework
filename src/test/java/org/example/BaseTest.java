package org.example;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageobject.HomePage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import java.net.URI;
import java.time.Duration;
import java.util.Locale;

public abstract class BaseTest {
    public WebDriver driver;
    public String baseUrl;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ProfilePage profilePage;

    @BeforeMethod
    void setUpTest() throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        baseUrl = "https://qa.koel.app/";
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);
    }

    @AfterMethod
    void teardawn() {
        driver.quit();
    }

    public String generateRandomPlaylistName() {
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }


    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.0.159:4444"; // change it to your own url
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
            case "grid-chrome": // gradle clean test -Dbrowser=grid-safari
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                return driver = new ChromeDriver(options);
        }
    }


}