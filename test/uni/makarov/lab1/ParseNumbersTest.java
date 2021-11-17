package uni.makarov.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParseNumbersTest {
    @Test
    public void testParseTextWithNumbersAndEvaluate(){
        String text = "(3 + 7) * (17 mod 5) ^ (mmax((-3 - 7), 2))";

        ApplicationModel testModel = new ApplicationModel();
        Assertions.assertEquals("40", testModel.parse(text));
    }
}
