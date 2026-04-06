package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.*;

public class DropdownTest {

    @Test
    void testDropdown() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;

        // 1. გახსენით ბრაუზერი და გადადით გვერდზე
        open("http://the-internet.herokuapp.com/dropdown");
        Thread.sleep(1000);

        // 2. დაავალიდირეთ რომ მონიშნულია 'Please select an option'
        $("#dropdown option[value='']").shouldBe(selected);
        Thread.sleep(2000);

        // 3. მონიშნეთ 'Option 2'
        $("#dropdown").selectOption("Option 2");
        Thread.sleep(2000);

        // 4. დაავალიდირეთ რომ მონიშნულია 'Option 2'
        $("#dropdown option[value='2']").shouldBe(selected);
        Thread.sleep(2000);

        // 5. დახურეთ ბრაუზერი
        closeWebDriver();
    }
}
