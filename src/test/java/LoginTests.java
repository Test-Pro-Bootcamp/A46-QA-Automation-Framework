import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
            public void loginValidEmailValidPassword() {

        openloginUrl();
        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement emailField = driver.findElement(By.cssSelector("[type ='email']"));
        emailField.click();
        emailField.sendKeys("daria.pavlyuk@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();

    }

    public void openloginUrl() {
        driver.get("https://qa.koel.app/");
    }

    @Test
    public void loginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
     @Test (dataProvider = "invalidLoginProviders")
    public void invalidPasswordTest(String email, String password) {
    enterEmail(email);
    enterPassword(password);
    clickSubmit();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type = 'submit']")));
    Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/");


    }
    public void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type ='email']"));
        emailField.click();
        emailField.sendKeys("daria.pavlyuk@testpro.io");
    }

}
