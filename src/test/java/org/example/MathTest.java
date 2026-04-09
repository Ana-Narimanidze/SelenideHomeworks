package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathTest {

    @Test
    public void testMathMethods() {
        Math math = new Math();

        int additionResult = math.addition(10, 5);
        int substractResult = math.substract(10, 5);

        Assert.assertEquals(additionResult, 15, "Addition result is incorrect");
        Assert.assertEquals(substractResult, 5, "Substract result is incorrect");
    }
}
