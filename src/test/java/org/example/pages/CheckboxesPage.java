package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class CheckboxesPage {

    private final ElementsCollection checkboxes = $$("#checkboxes input");

    public SelenideElement firstCheckbox() {
        return checkboxes.get(0);
    }

    public ElementsCollection checkboxes() {
        return checkboxes;
    }
}
