package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OrderCompletePage {
    private final SelenideElement orderCompleteTitle = $("small[class='text-muted']");

    private final SelenideElement orderCompleteMessage = $("div[class='text-center']");

    private final SelenideElement continueShoppingButton = $("a[href='#/products']");

    public boolean isOrderCompleteMessageDisplayed() {
        return orderCompleteMessage.text().contains("Thank you for your order!");
    }
    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }
}
