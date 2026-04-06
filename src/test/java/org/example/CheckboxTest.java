package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxTest {

    @Test
    void testCheckboxes() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        // გახსენით გვერდი
        open("http://the-internet.herokuapp.com/checkboxes");

        // მონიშნეთ პირველი checkbox
        $$("input[type='checkbox']").get(0).setSelected(true);

        // შეამოწმეთ რომ ორივე checkbox-ის type არის checkbox
        $$("input[type='checkbox']")
                .forEach(cb -> cb.shouldHave(attribute("type", "checkbox")));

        // დახურეთ ბრაუზერი
        closeWebDriver();
    }
}