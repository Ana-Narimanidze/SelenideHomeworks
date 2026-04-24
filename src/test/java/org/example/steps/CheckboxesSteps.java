package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.example.pages.CheckboxesPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxesSteps {

    private final CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Step("Open checkboxes page: {url}")
    public CheckboxesSteps openCheckboxesPage(String url) {
        open(url);
        return this;
    }

    @Step("Select first checkbox")
    public CheckboxesSteps selectFirstCheckbox() {
        checkboxesPage.firstCheckbox().setSelected(true);
        return this;
    }

    @Step("Validate that both checkboxes have type checkbox")
    public CheckboxesSteps validateCheckboxTypes() {
        checkboxesPage.checkboxes().shouldHave(CollectionCondition.size(2));
        checkboxesPage.checkboxes().get(0).shouldHave(attribute("type", "checkbox"));
        checkboxesPage.checkboxes().get(1).shouldHave(attribute("type", "checkbox"));
        return this;
    }
}
