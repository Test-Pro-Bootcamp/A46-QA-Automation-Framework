import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    WebDriver driver;
    String BaseUrl;
    @BeforeMethod
    void setUpTest (){
//prereq
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        BaseUrl = "https://qa.koel.app/";
        driver.get(BaseUrl);
    }
    @AfterMethod
    void teardawn(){
        driver.quit();
    }
    @Test
    public void LoginEmptyEmailPasswordTest() {
////prereq
////      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        BaseUrl = "https://qa.koel.app/";
//        driver.get(BaseUrl);
//step1
//        String url = "https://qa.koel.app/";
//        driver.get(url);
//        assertion
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl);
//        driver.quit();
    }
        @Test
        public void ValidLoginTest () {
            enterEmail("demo@class.com");
//      Added ChromeOptions argument below to fix websocket error
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//
//            WebDriver driver = new ChromeDriver(options);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////step1 Get URL
//            String url = "https://qa.koel.app/";
//            driver.get(url);
//step2 Enter email
//            WebElement email = driver.findElement(By.cssSelector("[type='email']"));
//            email.click();
//            email.clear();
//            email.sendKeys("demo@class.com");
//step3 Enter password
            enterPassword("te$t$tudent");
//            WebElement password = driver.findElement(By.cssSelector("[type='password']"));
//            password.click();
//            password.clear();
//            password.sendKeys("te$t$tudent");
//step4 Click submit
            WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
            submit.click();
//assertion Compare expected and actual
//            Assert.assertEquals(driver.getCurrentUrl(), url);
//Thread.sleep(3000);
            WebElement avatar = driver.findElement(By.className("avatar"));
            Assert.assertTrue(avatar.isDisplayed());
//            driver.quit();

        }

    private void enterPassword(String te$t$tudent) {
        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.click();
        password.clear();
        password.sendKeys("te$t$tudent");
    }


    @Test
        public void InValidPasswordTest () {
        enterEmail("demo@class.com");
//// test passed with empty password, because assertion compares url
////      Added ChromeOptions argument below to fix websocket error
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            WebDriver driver = new ChromeDriver(options);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////step1 Get URL
//            String url = "https://qa.koel.app/";
//            driver.get(url);
//step2 Enter email

//            WebElement email = driver.findElement(By.cssSelector("[type='email']"));
//            email.click();
//            email.clear();
//            email.sendKeys("demo@class.com");
//step3 Enter password
            WebElement password = driver.findElement(By.cssSelector("[type='password']"));
            password.click();
            password.clear();
            password.sendKeys("");
            //step4 Click submit
            WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
            submit.click();
//assertion Compare expected and actual
//         Thread.sleep(3000);
            Assert.assertEquals(driver.getCurrentUrl(), BaseUrl);
//      WebElement avatar = driver.findElement(By.cssSelector("[class = 'avatar']"));
//        Assert.assertTrue(avatar.isDisplayed());
//don't useAssert.assertTrue(driver.getCurrentUrl().equals(url)); expected[true] but found [false]- it's not info
//            driver.quit();
        }

    private void enterEmail(String s) {
        WebElement email = driver.findElement(By.cssSelector("[type='email']"));
        email.click();
        email.clear();
        email.sendKeys("demo@class.com");
    }
}
