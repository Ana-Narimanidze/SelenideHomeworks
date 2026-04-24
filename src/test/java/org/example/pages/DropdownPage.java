package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DropdownPage {

    private final SelenideElement dropdown = $("#dropdown");

    public SelenideElement dropdown() {
        return dropdown;
    }
}
