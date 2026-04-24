package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.example.pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxSteps {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Step("Open text box page: {url}")
    public TextBoxSteps openTextBoxPage(String url) {
        open(url);
        return this;
    }

    @Step("Fill text box form with fullname: {fullName}, email: {email}")
    public TextBoxSteps fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        textBoxPage.fullNameInput().setValue(fullName);
        textBoxPage.emailInput().setValue(email);
        textBoxPage.currentAddressInput().setValue(currentAddress);
        textBoxPage.permanentAddressInput().setValue(permanentAddress);
        return this;
    }

    @Step("Submit text box form")
    public TextBoxSteps submitForm() {
        executeJavaScript("arguments[0].scrollIntoView(true);", textBoxPage.submitButton());
        textBoxPage.submitButton().click();
        return this;
    }

    @Step("Validate output data using collection assertion")
    public TextBoxSteps validateOutput(String fullName, String email, String currentAddress, String permanentAddress) {
        textBoxPage.outputRows().shouldHave(CollectionCondition.exactTexts(
                "Name:" + fullName,
                "Email:" + email,
                "Current Address :" + currentAddress,
                "Permananet Address :" + permanentAddress
        ));
        return this;
    }
}
