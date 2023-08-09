package org.example;

import org.example.pageobject.HomePage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.utils.WaitUtil.waitUntilElementToBeClickable;
import static org.example.utils.WaitUtil.waitUntilElementToBeVisible;

public class LoginTests extends BaseTest {

    @BeforeMethod(dependsOnMethods = "setUpTest")
    public void createPages() {
        loginPage = new LoginPage(getWebDriver());
        homePage = new HomePage(getWebDriver());
        profilePage = new ProfilePage(getWebDriver());
    }

    @Test
    public void loginEmptyEmailPasswordTest() {
        Assert.assertEquals(getWebDriver().getCurrentUrl(), "https://qa.koel.app/");
    }

    @Test(description = "Test is checking happy path Login with correct details")
    public void validLoginTest() {
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }


    @Test
    public void inValidPasswordTest() {
        loginPage.provideEmail("demo@class.com")
                .providePassword("")
                .clickSubmit();
        Assert.assertEquals(getWebDriver().getCurrentUrl(), baseUrl);
    }

    @Test
    public void changeUserName() {
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        waitUntilElementToBeVisible(getWebDriver(), homePage.getAvatar());
        waitUntilElementToBeClickable(getWebDriver(), homePage.getAvatar());
        homePage.clickAvatar();
        profilePage.changePassword("te$t$tudent", "te$t$tudent", "demo@class.com");
//Step7. Click Submit  - To be completed
//        clickSubmit();
//Step8. Assertion - verify the name  - To be completed

    }
}