package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class CheckboxTests {

    @Test
    public void testCheckboxes() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        open("http://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);

        for (SelenideElement checkbox : $$("input[type='checkbox']")) {
            if (checkbox.isSelected()) {
                checkbox.click();
                Thread.sleep(1000);
            }
        }

        Assert.fail("Test failed intentionally");
    }
}