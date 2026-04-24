package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TextBoxPage {

    public SelenideElement fullNameInput() {
        return $("#userName");
    }

    public SelenideElement emailInput() {
        return $("input[type='email']");
    }

    public SelenideElement currentAddressInput() {
        return $("textarea#currentAddress");
    }

    public SelenideElement permanentAddressInput() {
        return $("#permanentAddress");
    }

    public SelenideElement submitButton() {
        return $("#submit");
    }

    public ElementsCollection outputRows() {
        return $$("#output p");
    }
}
