package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    public String baseUrl = "https://qa.koel.app/";

    @Before
    public void prepareTest() {
        //driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


        @Given("I open browser")
        public void openBrowser () {
            driver.get(baseUrl);

        }
        @Given("I open Login Page")
        public void openLoginPage () {
            driver.get(baseUrl);
        }
        @When("I enter email {string}")
        public void enterEmail (String email){
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).sendKeys(email);

        }
        @And("I enter password {string}")
        public void enterPassword (String password){
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']"))).sendKeys(password);

    }
        @And("I submit")
        public void submit () {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();

        }
        @Then("I am logged in")
        public void userIsLoggedIn () {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
        }
        @After
        public void closeBrowser () {
            driver.quit();
        }

    }
