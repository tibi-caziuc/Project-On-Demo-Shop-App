package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    private final SelenideElement checkoutTitle = $("small[class='text-muted']");

    private final SelenideElement firstNameField = $("#first-name");

    private final SelenideElement lastNameField =  $("#last-name");

    private final SelenideElement addressField = $("#address");

    private final SelenideElement continueCheckoutButton = $("button[type='submit']");

    private final SelenideElement informationErrorMessage = $("p[class='error']");

    public boolean isCheckoutTitleDisplayed() {
        return checkoutTitle.text().contains("Your information");
    }

    public void fillFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void fillAddress(String address) {
        addressField.sendKeys(address);
    }
    public void clickContinueCheckoutButton() {
        continueCheckoutButton.click();
    }

    public boolean isInformationErrorDisplayed(String errorMessage) {
        return informationErrorMessage.text().contains(errorMessage);
    }

    public boolean isErrorDisplayed() {
        return informationErrorMessage.isDisplayed();
    }
}
