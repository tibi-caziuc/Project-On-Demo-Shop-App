package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {

    private final SelenideElement addToBasketButton = $(".fa-cart-plus");

    private final SelenideElement wishlistButtonFromProductDetails = $("svg[class='svg-inline--fa fa-heart fa-w-16 fa-3x ']");

    public void clickOnTheAddToBasketButton() {
        this.addToBasketButton.click();
    }

    public void clickWishlistButtonFromProductDetails() {
        wishlistButtonFromProductDetails.click();
    }
}
