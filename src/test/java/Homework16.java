import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation(){


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //step1 Get URL
        String url = "https://qa.koel.app/";
        driver.get(url);
        //step2 Click Registration
        WebElement registrationLink = driver.findElement(By.id("hel"));
        registrationLink.click();
        //step3 Assert
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/registration.php");
        //step4 Enter email
        WebElement email = driver.findElement(By.cssSelector("[type='email']"));
        email.click();
        email.sendKeys("daria25@testpro.io");
        //step5 click Register
        WebElement submit = driver.findElement(By.cssSelector("[type = 'submit']"));
        submit.click();
        //Step6 LogIn message
        WebElement message = driver.findElement(By.className("button"));
        message.click();
        driver.quit();
    }
}



