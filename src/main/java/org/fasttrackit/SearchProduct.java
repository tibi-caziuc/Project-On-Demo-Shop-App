package org.fasttrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchProduct {

    private final SelenideElement searchField = $("#input-search");
    private final SelenideElement searchButton = $("button[class='btn btn-light btn-sm']");
    private final ElementsCollection searchedProducts = $$("div[class='card']");

    public int getNumberOfSearchedProducts() {
        return searchedProducts.size();
    }

    public void searchProduct(String product) {
        searchField.sendKeys(product);
    }
    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isSearchButtonDisplayed() {
        return searchButton.isDisplayed();
    }

}
