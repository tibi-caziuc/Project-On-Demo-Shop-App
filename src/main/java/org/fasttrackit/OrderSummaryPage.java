package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OrderSummaryPage {

    private final SelenideElement orderSummaryTitle = $("small[class='text-muted']");
    private SelenideElement totalOrderAmount = $(".amount-total .amount");

    private SelenideElement completeOrderButton = $("a[href='#/checkout-complete']");

    public boolean isOrderSummaryTitleDisplayed() {
        return orderSummaryTitle.text().contains("Order summary");
    }
    public double getTotalOrderAmount() {
        String totalWithoutCurrency = totalOrderAmount.text().replace("$", "");
        return Double.parseDouble(totalWithoutCurrency);
    }

    public void clickCompleteOrderButton() {
        completeOrderButton.click();
    }
}
