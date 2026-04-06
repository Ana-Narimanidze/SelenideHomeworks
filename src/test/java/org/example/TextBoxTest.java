package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @Test
    void testTextBox() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;

        // ბრაუზერის გახსნა და გვერდზე გადასვლა
        open("https://demoqa.com/text-box");
        Thread.sleep(2000);

        // Full Name - id selector
        $("#userName").setValue("Ana Narimanidze");
        Thread.sleep(1000);

        // Email - name selector
        $("[placeholder='name@example.com']").setValue("ana.narimanidze@gmail.com");
        Thread.sleep(1000);

        // Current Address - id selector
        $("#currentAddress").setValue("Tbilisi, Georgia");
        Thread.sleep(1000);

        // Permanent Address - css selector
        $("#permanentAddress").setValue("bilisi, Georgia");
        Thread.sleep(1000);

        // Submit ღილაკზე გადასასვლელად ოდნავ ქვემოთ ჩასქროლვა
        executeJavaScript("window.scrollBy(0,300)");
        Thread.sleep(1000);

        // Submit
        $("#submit").click();
        Thread.sleep(2000);

        // შედეგის ვალიდაცია Collection Assertion-ით
        $$("#output div p").shouldHave(exactTexts(
                "Name:Ana Narimanidze",
                "Email:ana.narimanidze@gmail.com",
                "Current Address :Tbilisi, Georgia",
                "Permananet Address :Batumi, Georgia"
        ));

        // ბრაუზერის დახურვა
        closeWebDriver();
    }
}
