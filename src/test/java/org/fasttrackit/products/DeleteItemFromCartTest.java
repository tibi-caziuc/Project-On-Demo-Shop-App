package org.fasttrackit.products;

import org.fasttrackit.*;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemFromCartTest extends BaseTestConfig {

    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        this.page = new DemoShopPage();
        page.openDemoShopApp();

        Product metalMagicMouse = new Product("7", "Practical Metal Mouse", "9.99");
        metalMagicMouse.clickOnTheProductLink();
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        Footer footer = new Footer();
        footer.resetPage();
    }

    @Test
    public void testDeleteItemFromCart() {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();

        page.getHeader().clickOnTheCartIcon();
        CartPage cartPage = new CartPage();
        cartPage.clickDeleteItemButton();
        Assert.assertTrue(cartPage.isNoProductsInCartMessageDisplayed());
    }
}
