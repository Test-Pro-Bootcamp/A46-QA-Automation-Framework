import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Locale;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpTest(){
        //prereq
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        baseUrl = "https://qa.koel.app/";
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(9));
    }

    @AfterMethod
    void teardawn(){
        driver.quit();
    }

    protected void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    protected void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"))      ;
        submit.click();
    }

    protected void enterEmail(String emailValue) {
        enterText(By.cssSelector("[type='email']"), emailValue);
    }

    protected void enterPassword(String passwordValue) {
        enterText(By.cssSelector("[type='password']"),passwordValue);
    }

    void enterText(By elementBy,String textToEnter){
        WebElement email= driver.findElement(elementBy)   ;
        email.click();
        email.clear();
        email.sendKeys(textToEnter);
    }

    String getRandomString (){
        UUID uuid = UUID. randomUUID();
        return uuid.toString();
    }

    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
}