import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String baseUrl;


    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }
     @BeforeMethod
     @Parameters({"baseUrl"})

    static void setupBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        //driver = new ChromeDriver();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //String baseUrl = "https://qa.koel.app/";
         driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}