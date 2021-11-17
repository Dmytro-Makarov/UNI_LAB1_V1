package uni.makarov.lab1;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParseCellsAndNumbersTest {

    @Test
    public void testParseCellWithNumberAndGetException(){
        //A workaround to start JavaFX Runtime
        JFXPanel jfxPanel = new JFXPanel();
        String text = "A1 ^ 2";
        ApplicationModel testModel = new ApplicationModel();

        String expectedMessage = "100";

        testModel.initGrids(10,10);
        testModel.setCellValue(0,0,true, "10");

        String receivedMessage = testModel.parse(text);

        Assertions.assertTrue(receivedMessage.contains(expectedMessage));
    }
}
