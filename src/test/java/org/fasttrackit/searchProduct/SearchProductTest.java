package org.fasttrackit.searchProduct;

import org.fasttrackit.*;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class    SearchProductTest extends BaseTestConfig {
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
    public void testSearchProduct() {
        SearchProduct searchProduct = new SearchProduct();
        searchProduct.searchProduct("refined");
        searchProduct.clickSearchButton();
        Assert.assertEquals(searchProduct.getNumberOfSearchedProducts(), 1);
    }

    @Test
    public void testSearchProductNotExist() {
        SearchProduct searchProduct = new SearchProduct();
        searchProduct.searchProduct("laptop");
        searchProduct.clickSearchButton();
        Assert.assertEquals(searchProduct.getNumberOfSearchedProducts(), 0);
    }

    @Test
    public void testEmptySearchProduct() {
        SearchProduct searchProduct = new SearchProduct();
        searchProduct.searchProduct("");
        searchProduct.clickSearchButton();
        Assert.assertEquals(searchProduct.getNumberOfSearchedProducts(), 10);
    }

    @Test
    public void testThreeResultSearchProduct() {
        SearchProduct searchProduct = new SearchProduct();
        searchProduct.searchProduct("awesome");
        searchProduct.clickSearchButton();
        Assert.assertEquals(searchProduct.getNumberOfSearchedProducts(), 3);
    }
}
