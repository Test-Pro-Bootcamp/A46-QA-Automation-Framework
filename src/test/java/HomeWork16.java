import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends BaseTest {
    @Test
    public void NavigationRegistrationTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//step1 Get URL
        String url = "https://qa.koel.app/";
        driver.get(url);
//step2 Click Registration Link
       WebElement registrationLink = driver.findElement(By.id("hel"));
       registrationLink.click();
//assertion Compare expected and actual
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration.php");
//step3 Email registration
        WebElement email = driver.findElement(By.id("email"));
        email.click();
        email.clear();
        email.sendKeys("valivkote+3@gmail.com");
//step4 Click Registration Button
        WebElement registrationButton = driver.findElement(By.id("button"));
        registrationButton.click();
//step5 Click login
        WebElement login = driver.findElement(By.cssSelector("[class = 'button']"));
        login.click();
//step6 Click emailLogin
        WebElement emailLogin = driver.findElement(By.cssSelector("[type ='email']"));
        emailLogin.click();
        emailLogin.clear();
        emailLogin.sendKeys("valivkote+2@gmail.com");
//step7 Click password
        WebElement password = driver.findElement(By.cssSelector("[type = 'password']"));
        password.click();
        password.clear();
        password.sendKeys("te$t$tudent");
//step8 Click submit
        WebElement submit = driver.findElement(By.cssSelector("[type = 'submit']"));
        submit.click();
//assertion Compare expected and actual
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement avatar = driver.findElement(By.cssSelector("[class = 'avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
          driver.quit();

    }
}
