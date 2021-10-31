package uni.makarov.lab1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SpreadsheetApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ApplicationModel applicationModel = new ApplicationModel();
        ApplicationController applicationController = new ApplicationController(applicationModel);
        ApplicationView applicationView = new ApplicationView(applicationController, applicationModel);

        Scene scene = new Scene(applicationView.asParent(), 800, 400);

        primaryStage.setOnCloseRequest(event -> applicationView.stageCloseRequest());

        //STAGE
        primaryStage.setTitle("Laboratory No.1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}