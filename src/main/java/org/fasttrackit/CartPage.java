package org.fasttrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage extends Page {

    private List<Product> productsInCart = new ArrayList<>();
    private final ElementsCollection distinctProducts = $$(".row a");
    private final SelenideElement cartTotalAmount = $(".amount-total .amount");

    private final SelenideElement checkoutButton = $("a[href='#/checkout-info']");

    private final SelenideElement deleteItemButton = $(".fa-trash");

    private final SelenideElement noProductsInCartMessage = $("div[class='text-center container']");

    public double getTotalCartCostBasedOnProducts() {
        double totalCartCost = 0.0;
        for (SelenideElement product : distinctProducts) {
            SelenideElement row = product.parent().parent();

            String productPrice = row.$(".col-md-auto", 1).text().replace("$", "");
            double pricePerProduct = Double.parseDouble(productPrice);

            String numberOfProductsFromType = row.$("div").text().replace("$", "");
            double productsFromType = Double.parseDouble(numberOfProductsFromType);

            totalCartCost += (productsFromType * pricePerProduct);
        }
        NumberFormat format = new DecimalFormat("#0.00");
        return Double.parseDouble(format.format(totalCartCost));
    }

    public double getTotalCartAmount() {
        String totalWithoutCurrency = cartTotalAmount.text().replace("$", "");
        return Double.parseDouble(totalWithoutCurrency);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void clickDeleteItemButton() {
        deleteItemButton.click();
    }

    public boolean isNoProductsInCartMessageDisplayed() {
        return noProductsInCartMessage.text().contains("How about adding some products in your cart?");
    }
}
