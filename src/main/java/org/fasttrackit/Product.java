package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Product {

    private final SelenideElement productCard;
    private final SelenideElement productLink;
    private final SelenideElement addToBasketButton;
    private final SelenideElement addWishlistButton;
    private String name;
    private String price;

    public Product(String productId, String name, String price) {
        String selector = "[href='#/product/" + productId + "']";
        String productSelector = String.format("[href='#/product/%s']", productId);
        this.productLink = $(productSelector);
        this.productCard = this.productLink.parent().parent();
        this.addToBasketButton = productCard.$(".fa-cart-plus");
        this.addWishlistButton = productCard.$(".fa-heart");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void clickOnTheProductLink() {
        productLink.click();
    }

    public void addToWishlist() {
        this.addWishlistButton.scrollTo();
        this.addWishlistButton.click();
    }

    @Override
    public String toString() {
        return name;
    }
}
