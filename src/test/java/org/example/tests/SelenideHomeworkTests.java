package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.example.steps.CheckboxesSteps;
import org.example.steps.DropdownSteps;
import org.example.steps.TextBoxSteps;
import org.testng.annotations.Test;

@Epic("Selenide Homeworks")
@Feature("POM and Allure Refactoring")
public class SelenideHomeworkTests extends BaseTest {

    private final CheckboxesSteps checkboxesSteps = new CheckboxesSteps();
    private final DropdownSteps dropdownSteps = new DropdownSteps();
    private final TextBoxSteps textBoxSteps = new TextBoxSteps();

    @Test(description = "Validate checkboxes functionality")
    @Story("Checkboxes page")
    @Description("Open checkboxes page, select first checkbox and validate that both inputs have checkbox type.")
    @Severity(SeverityLevel.NORMAL)
    public void checkboxesTest() {
        checkboxesSteps
                .openCheckboxesPage("http://the-internet.herokuapp.com/checkboxes")
                .selectFirstCheckbox()
                .validateCheckboxTypes();
    }

    @Test(description = "Validate dropdown functionality")
    @Story("Dropdown page")
    @Description("Validate default dropdown option, select Option 2 and validate selected option again.")
    @Severity(SeverityLevel.CRITICAL)
    public void dropdownTest() {
        dropdownSteps
                .openDropdownPage("http://the-internet.herokuapp.com/dropdown")
                .validateSelectedOption("Please select an option")
                .selectOption("Option 2")
                .validateSelectedOption("Option 2");
    }

    @Test(description = "Validate text box form using collection assertion")
    @Story("DemoQA text box page")
    @Description("Fill fullname, valid email, current and permanent addresses using different selectors and validate output with CollectionCondition.exactTexts.")
    @Severity(SeverityLevel.BLOCKER)
    public void textBoxTest() {
        String fullName = "Ana Narimanidze";
        String email = "ana@example.com";
        String currentAddress = "Tbilisi, Georgia";
        String permanentAddress = "Batumi, Georgia";

        textBoxSteps
                .openTextBoxPage("https://demoqa.com/text-box")
                .fillForm(fullName, email, currentAddress, permanentAddress)
                .submitForm()
                .validateOutput(fullName, email, currentAddress, permanentAddress);
    }
}
