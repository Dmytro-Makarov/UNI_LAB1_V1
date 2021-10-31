package uni.makarov.lab1;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParseCellsTest {
    @Test
    public void testParseTextWithCellsAndEvaluate(){
        //A workaround to start JavaFX Runtime
        JFXPanel jfxPanel = new JFXPanel();
        String text = "mmin(A1, B2) * C3";
        ApplicationModel testModel = new ApplicationModel();

        testModel.initGrids(10,10);
        testModel.setCellValue(0,0,true, "3");
        testModel.setCellValue(1,1,true, "7");
        testModel.setCellValue(2,2,true, "2");

        Assertions.assertEquals("6", testModel.parse(text));

    }

}
