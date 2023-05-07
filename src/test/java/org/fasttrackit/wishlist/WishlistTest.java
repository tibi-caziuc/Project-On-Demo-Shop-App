package org.fasttrackit.wishlist;

import org.fasttrackit.*;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTestConfig {
    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        this.page = new DemoShopPage();
        page.openDemoShopApp();
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        Footer footer = new Footer();
        footer.resetPage();
    }

    @Test
    public void testNavigateToWishlistPage() {
        Header header = new Header();
        header.clickOnTheWishlist();
        WishlistPage wishlistPage = new WishlistPage();
        Assert.assertTrue(wishlistPage.isWishlistTitleDisplayed());
    }

    @Test
    public void addProductToWishlistFromHomePage() {
        Product metalMagicMouse = new Product("7", "Practical Metal Mouse", "9.99");
        metalMagicMouse.addToWishlist();
        WishlistPage wishlistPage = new WishlistPage();
        Header header = new Header();
        header.clickOnTheWishlist();
        Assert.assertTrue(wishlistPage.isUnwishlistIconDisplayed());
    }

    @Test
    public void addProductToWishlistFromProductDetails() {
        Product incredibleConcreteHat = new Product("2", "Incredible Concrete Hat", "7.99");
        incredibleConcreteHat.clickOnTheProductLink();
        WishlistPage wishlistPage = new WishlistPage();
        Header header = new Header();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.clickWishlistButtonFromProductDetails();
        header.clickOnTheWishlist();
        Assert.assertTrue(wishlistPage.isUnwishlistIconDisplayed());
    }
}