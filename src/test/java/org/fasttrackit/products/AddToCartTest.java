package org.fasttrackit.products;

import org.fasttrackit.*;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;

public class AddToCartTest extends BaseTestConfig {

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
    public void addPracticalMetalMouseProductInCartNumberOfProductsInCartIsOne() {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();

        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();
        assertEquals(numberOfProductsInCart, "1", "Adding one product to cart, the cart badge is 1");
    }

    @Test
    public void addTwoPracticalMetalMouseProductsInCart() {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();
        detailsPage.clickOnTheAddToBasketButton();

        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();
        assertEquals(numberOfProductsInCart, "2", "Adding two products to cart, the cart badge is 2");
    }

    @Test
    public void addMetalMouseToCartTotalCostIsCorrectlyAdded() {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();

        page.getHeader().clickOnTheCartIcon();
        CartPage cartPage = new CartPage();
        double totalCartCost = cartPage.getTotalCartCostBasedOnProducts();
        double totalCartAmount = cartPage.getTotalCartAmount();
        assertEquals(totalCartCost, 9.99, "The total products is 9.99");
        assertEquals(totalCartAmount, 9.99, "The cart total is 9.99");
    }

    @Test
    public void addTwoPracticalMetalMouseToCartTotalCostIsCorrectlyAdded() {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();
        detailsPage.clickOnTheAddToBasketButton();

        page.getHeader().clickOnTheCartIcon();
        CartPage cartPage = new CartPage();
        double totalCartCost = cartPage.getTotalCartCostBasedOnProducts();
        double totalCartAmount = cartPage.getTotalCartAmount();
        sleep(2 * 1000);
        assertEquals(totalCartAmount, 19.98, "The cart total is 19.98");
        assertEquals(totalCartCost, 19.98, "The total products is 19.98");
    }
}
