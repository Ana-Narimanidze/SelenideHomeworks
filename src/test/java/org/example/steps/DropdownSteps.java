package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.DropdownPage;

import static com.codeborne.selenide.Condition.selectedText;
import static com.codeborne.selenide.Selenide.open;

public class DropdownSteps {

    private final DropdownPage dropdownPage = new DropdownPage();

    @Step("Open dropdown page: {url}")
    public DropdownSteps openDropdownPage(String url) {
        open(url);
        return this;
    }

    @Step("Validate selected option is: {expectedOption}")
    public DropdownSteps validateSelectedOption(String expectedOption) {
        dropdownPage.dropdown().shouldHave(selectedText(expectedOption));
        return this;
    }

    @Step("Select dropdown option: {option}")
    public DropdownSteps selectOption(String option) {
        dropdownPage.dropdown().selectOption(option);
        return this;
    }
}
