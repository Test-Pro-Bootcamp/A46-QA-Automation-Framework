package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

//we can remove this
//    @BeforeMethod (dependsOnMethods = "setupBrowser")
//    public void createPages(){
//        loginPage = new LoginPage(getWebDriver() );
//        homePage = new HomePage(getWebDriver() );
//
//    }
//}
    @Test
            public void  loginValidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver) ;
        HomePage homePage = new HomePage(driver);
loginPage.provideEmail("demo@class.com")
        .providePassword("te$t$tudent")
        .clickSubmitBtn() ;
Assert.assertTrue(homePage.isAvatarDisplayed() );

        //loginPage.provideEmail("daria.pavlyuk@testpro.io");
//loginPage.providePassword("te$T$tudent");
//loginPage.clickSubmit();

//        openloginUrl();
//        String url = "https://qa.koel.app/";
//        getWebDriver().get(url);
//        WebElement emailField = getWebDriver().findElement(By.cssSelector("[type ='email']"));
//        emailField.click();
//        emailField.sendKeys("daria.pavlyuk@testpro.io");
//
//        WebElement passwordField = getWebDriver() .findElement(By.cssSelector("[type = 'password']"));
//        passwordField.click();
//        passwordField.sendKeys("te$t$tudent");
//
//        WebElement submitButton = getWebDriver().findElement(By.cssSelector("[type = 'submit']"));
//       submitButton.click();

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
