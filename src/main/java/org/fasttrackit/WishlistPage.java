package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WishlistPage {
    private final SelenideElement wishlistTitle = $("small[class='text-muted']");
    private final SelenideElement unwishlistIcon = $(".fa-heart-broken");

    public boolean isWishlistTitleDisplayed() {
        return wishlistTitle.text().contains("Wishlist");
    }
    public boolean isUnwishlistIconDisplayed() {
        return unwishlistIcon.isDisplayed();
    }
}
