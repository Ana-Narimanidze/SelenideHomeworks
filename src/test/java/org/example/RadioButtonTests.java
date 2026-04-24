package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RadioButtonTests {

    @Test(groups = "Backend")
    public void testRadioButtons() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        open("https://demoqa.com/radio-button");
        Thread.sleep(2000);

        executeJavaScript("window.scrollBy(0,300)");
        Thread.sleep(1000);

        $("label[for='yesRadio']").click();
        Thread.sleep(2000);

        $(".text-success").shouldHave(text("Yes"));
    }
}