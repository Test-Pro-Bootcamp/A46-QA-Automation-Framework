package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageobject.HomePage;
import org.example.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class RenamePlaylistSteps {

    public WebDriver driver;
    public String baseUrl = "https://qa.koel.app/";

    @Before
    public void prepareTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Given("I open browser")
    public void openBrowser() {
        driver.get(baseUrl);
    }

    @When("I input email {string}")
    public void inputEmail(String email) {
        new LoginPage(driver).provideEmail(email);
    }

    @When("I input password {string}")
    public void inputPassword(String password) {
        new LoginPage(driver).providePassword(password);
    }
    @When("I click submit")
    public void clickSubmit() {
        new LoginPage(driver).clickSubmit();
    }

    @When("I double click by playlist of number {int}")
    public void doubleClickByPlaylistOfNumber(int number) {
        new HomePage(driver).doubleClickPlaylistByNumber(number);
    }

    @When("I enter new playlist name {string}")
    public void enterNewPlaylistName(String newName) {
        new HomePage(driver).enterNewPlaylistName(newName);
    }

    @Then("Playlist {string} should be exist")
    public void playlistWithNameShouldBeExist(String newName) {
        Assert.assertTrue(new HomePage(driver).doesPlaylistExist(newName));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
