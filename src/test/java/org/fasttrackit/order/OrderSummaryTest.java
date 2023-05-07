package org.fasttrackit.order;

import org.fasttrackit.*;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderSummaryTest extends BaseTestConfig {

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

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillFirstName("First name");
        checkoutPage.fillLastName("Last name");
        checkoutPage.fillAddress("Address");
        checkoutPage.clickContinueCheckoutButton();
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        Footer footer = new Footer();
        footer.resetPage();
    }
    @Test
    public void testNavigateToOrderSummaryPage() {
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
        Assert.assertTrue(orderSummaryPage.isOrderSummaryTitleDisplayed());
    }

    @Test
    public void testTotalCostIsCorrectlyDisplayed() {
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
        Assert.assertEquals(orderSummaryPage.getTotalOrderAmount(), 9.99);
    }
}
