package org.fasttrackit.login;

import com.codeborne.selenide.Selenide;
import org.fasttrackit.DemoShopPage;
import org.fasttrackit.LoginModal;
import org.fasttrackit.config.BaseTestConfig;

import org.fasttrackit.dataProvider.User;
import org.fasttrackit.dataProvider.UserDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTestConfig {
    DemoShopPage page;
    @BeforeMethod
    public void setup() {
        page = new DemoShopPage();
        page.openDemoShopApp();
    }

    @AfterMethod
    public void cleanup() {
        page.openDemoShopApp();
        Selenide.refresh();
        page.getFooter().resetPage();
    }

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "validUserDataProvider")
    public void userCanLoginOnDemoShopPage(User user) {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername(user.getUsername());
        loginModal.fillInPassword(user.getPassword());
        loginModal.clickSubmitButton();
        assertEquals(page.getHeader().getGreetingsMsg(), user.getExpectedGreetingsMsg(), "Greetings message is : " + user.getExpectedGreetingsMsg());
    }

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "invalidUserDataProvider")
    public void userCanNotLoginOnDemoShopPageWithInvalidUser(User user) {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername(user.getUsername());
        loginModal.fillInPassword(user.getPassword());
        loginModal.clickSubmitButton();

        assertTrue(loginModal.isDisplayed());
        assertTrue(loginModal.isErrorMsgDisplayed(), "Login error message is displayed.");
        assertEquals(loginModal.getErrorMsg(), user.getErrorMessage());
        assertEquals(page.getHeader().getGreetingsMsg(), user.getDefaultGreetingsMsg(), "Greetings message is : Hello guest!");
    }
}



