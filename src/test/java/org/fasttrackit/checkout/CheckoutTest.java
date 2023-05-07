package org.fasttrackit.checkout;

import org.fasttrackit.*;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTestConfig {

    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        this.page = new DemoShopPage();
        page.openDemoShopApp();

        Product metalMagicMouse = new Product("7", "Practical Metal Mouse", "9.99");
        metalMagicMouse.clickOnTheProductLink();
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();
        page.getHeader().clickOnTheCartIcon();
        CartPage cartPage = new CartPage();
        cartPage.clickCheckoutButton();
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        Footer footer = new Footer();
        footer.resetPage();
    }
    @Test
    public void navigateToCheckoutPage() {
        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertTrue(checkoutPage.isCheckoutTitleDisplayed());
    }

    @Test
    public void testFirstNameRequiredErrorIsDisplayed() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillLastName("Last name");
        checkoutPage.fillAddress("Address");
        checkoutPage.clickContinueCheckoutButton();
        Assert.assertTrue(checkoutPage.isInformationErrorDisplayed("First Name is required"));
    }

    @Test
    public void testLastNameRequiredErrorIsDisplayed() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillFirstName("First name");
        checkoutPage.fillAddress("Address");
        checkoutPage.clickContinueCheckoutButton();
        Assert.assertTrue(checkoutPage.isInformationErrorDisplayed("Last Name is required"));
    }

    @Test
    public void testAddressRequiredErrorIsDisplayed() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillFirstName("First name");
        checkoutPage.fillLastName("Last name");
        checkoutPage.clickContinueCheckoutButton();
        Assert.assertTrue(checkoutPage.isInformationErrorDisplayed("Address is required"));
    }

    @Test
    public void testAllCheckoutFieldsAreFilledInCorrectly() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillFirstName("First name");
        checkoutPage.fillLastName("Last name");
        checkoutPage.fillAddress("Address");
        checkoutPage.clickContinueCheckoutButton();
        Assert.assertFalse(checkoutPage.isErrorDisplayed());
    }
}
