module uni.makarov.uni_lab1_v1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires org.antlr.antlr4.runtime;

    opens uni.makarov.lab1 to javafx.fxml;
    exports uni.makarov.lab1;
}