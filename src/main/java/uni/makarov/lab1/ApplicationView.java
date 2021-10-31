package uni.makarov.lab1;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;


///Window Hierarchy///
/*
VBox
	MenuBar
		MenuFile
		    MenuSave
		    MenuOpen
		MenuHelp
		    MenuFunctions
		    MenuErrors
	SplitPane (Vertical)
		VBOX
			AnchorPane1
			    Toggle
			AnchorPane2
			    LabelRow
			    ButtonM
			    ButtonP
			AnchorPane3
			    LabelColumn
			    ButtonM
			    ButtonP
		SplitPane(Horizontal)
				TextField
				SpreadsheetView
	HBox

*/

//UI
public class ApplicationView {
    private VBox root;

    private MenuItem menuISave;
    private MenuItem menuIOpen;
    private MenuItem menuIFunctions;
    private MenuItem menuIErrors;

    private ToggleSwitch toggleSwitchFV;
    private Button buttonRowM;
    private Button buttonRowP;
    private Button buttonColM;
    private Button buttonColP;

    private GridBase grid;
    private SpreadsheetView spv;
    private TextField textFieldSPV;


    private final ApplicationController controller;
    private final ApplicationModel model;

    public ApplicationView(ApplicationController controller, ApplicationModel model) {
        this.controller = controller;
        this.model = model;

        initUI();
    }


    private void initUI() {
        root = new VBox();
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("Файл");
        Menu menuHelp = new Menu("Інформація");

        menuISave = new MenuItem("Зберегти...");
        menuIOpen = new MenuItem("Відкрити...");
        menuFile.getItems().addAll(menuISave, menuIOpen);

        menuIFunctions = new MenuItem("Функціонал");
        menuIErrors = new MenuItem("Помилки");
        menuHelp.getItems().addAll(menuIFunctions, menuIErrors);

        menuBar.getMenus().addAll(menuFile, menuHelp);
        root.getChildren().add(menuBar);

        initMain();
        initEventHandler();
    }

    private void setAnchors(Node node, double topAnchor, double bottomAnchor, double leftAnchor, double rightAnchor) {
        if (topAnchor != 0) {
            AnchorPane.setTopAnchor(node, topAnchor);
        }
        if (bottomAnchor != 0) {
            AnchorPane.setBottomAnchor(node, bottomAnchor);
        }
        if (leftAnchor != 0) {
            AnchorPane.setLeftAnchor(node, leftAnchor);
        }
        if (rightAnchor != 0) {
            AnchorPane.setRightAnchor(node, rightAnchor);
        }
    }

    private void initMain() {
        //SPLIT_PANE HORIZONTAL
        SplitPane splitPaneHOR = new SplitPane();

        VBox.setVgrow(splitPaneHOR, Priority.ALWAYS);

        //VBOX for controls
        VBox vboxSPH1 = new VBox();

        //Function/Value Toggle
        AnchorPane anchorPaneVB1 = new AnchorPane();
        anchorPaneVB1.setMinHeight(85.0);
        toggleSwitchFV = new ToggleSwitch("Функція/Значення:");
        toggleSwitchFV.setAlignment(Pos.CENTER);
        anchorPaneVB1.getChildren().add(toggleSwitchFV);
        AnchorPane.setLeftAnchor(toggleSwitchFV, 10.0);
        setAnchors(toggleSwitchFV, 25.0, 25.0, 0, 0);

        // +/- rows
        AnchorPane anchorPaneVB2 = new AnchorPane();
        anchorPaneVB2.setMinHeight(85.0);
        Label labelRows = new Label("Рядки");
        labelRows.setAlignment(Pos.CENTER);
        setAnchors(labelRows, 10.0, 0, 25.0, 25.0);
        anchorPaneVB2.getChildren().add(labelRows);

        buttonRowM = new Button("-");
        buttonRowP = new Button("+");
        buttonRowM.setAlignment(Pos.CENTER);
        buttonRowP.setAlignment(Pos.CENTER);
        setAnchors(buttonRowM, 0, 25.0, 50.0, 0);
        setAnchors(buttonRowP, 0, 25.0, 0, 50.0);
        anchorPaneVB2.getChildren().add(buttonRowM);
        anchorPaneVB2.getChildren().add(buttonRowP);

        // +/- columns
        AnchorPane anchorPaneVB3 = new AnchorPane();
        anchorPaneVB3.setMinHeight(85.0);
        Label labelColumns = new Label("Колонки");
        labelColumns.setAlignment(Pos.CENTER);
        setAnchors(labelColumns, 10.0, 0, 25.0, 25.0);

        anchorPaneVB3.getChildren().add(labelColumns);
        buttonColM = new Button("-");
        buttonColP = new Button("+");
        buttonColM.setAlignment(Pos.CENTER);
        buttonColP.setAlignment(Pos.CENTER);
        setAnchors(buttonColM, 0, 25.0, 50.0, 0);
        setAnchors(buttonColP, 0, 25.0, 0, 50.0);
        anchorPaneVB3.getChildren().add(buttonColM);
        anchorPaneVB3.getChildren().add(buttonColP);

        vboxSPH1.getChildren().addAll(anchorPaneVB1, anchorPaneVB2, anchorPaneVB3);

        splitPaneHOR.getItems().add(vboxSPH1);
        vboxSPH1.maxWidthProperty().bind(splitPaneHOR.widthProperty().multiply(0.225));
        vboxSPH1.minWidth(250);

        SplitPane splitPaneVER = new SplitPane();
        splitPaneVER.setOrientation(Orientation.VERTICAL);

        //TEXT FIELD for functions
        textFieldSPV = new TextField("Функція тут");

        //Create Spreadsheet
        grid = model.initGrids(10, 15);
        spv = new SpreadsheetView(grid);
        hideRowsColumns();

        spv.setEditable(false);

        //SPLIT_PANE VERTICAL
        splitPaneVER.getItems().add(textFieldSPV);
        splitPaneVER.getItems().add(spv);

        splitPaneHOR.getItems().add(splitPaneVER);
        splitPaneHOR.setDividerPositions(0.25);

        root.getChildren().add(splitPaneHOR);
    }

    private boolean hideRowsColumns() {
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        int realRowCount = model.getRealRowCount();
        int realColumnCount = model.getRealColumnCount();
        try {
            if (rowCount > realRowCount || columnCount > realColumnCount) {
                return false;
            }
            for (int row = rowCount; row < realRowCount; ++row) {
                if (!spv.isRowHidden(row)) {
                    spv.hideRow(row);
                }
            }
            for (int row = 0; row <= rowCount; ++row) {
                if (spv.isRowHidden(row)) {
                    spv.showRow(row);
                }
            }
            for (int column = columnCount; column < realColumnCount; ++column) {
                if (!spv.isColumnHidden(column)) {
                    spv.hideColumn(spv.getColumns().get(column));
                }
            }
            for (int column = 0; column <= columnCount; ++column) {
                if (spv.isColumnHidden(column)) {
                    spv.showColumn(spv.getColumns().get(column));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.print("ROW/COLUMN INDEX OUT OF BOUNDS!\nSetting default values...\n");
            textFieldSPV.setText("ERR:ROW/COLUMN INDEX OUT OF BOUNDS!");
            model.setRowCount(5);
            model.setColumnCount(5);
            hideRowsColumns();
        }
        return true;
    }

    private void updSpreadsheet() {
        spv.setGrid(grid);
        hideRowsColumns();
    }

    protected void stageCloseRequest() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Закінчується сеанс");
        alert.setHeaderText("Ви хочете зберегти таблицю?");

        ButtonType buttonTypeYes = new ButtonType("Так", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("Ні", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> saveResult = alert.showAndWait();

        if (saveResult.get() == buttonTypeYes) {

            TextInputDialog textInputDialog = new TextInputDialog();

            textInputDialog.setTitle("Зберегти таблицю");
            textInputDialog.setHeaderText("Введіть назву таблиці");
            textInputDialog.setContentText("Name: ");
            Optional<String> result = textInputDialog.showAndWait();
            result.ifPresent(name -> {
                try {
                    controller.saveSpreadsheetCall(name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            updSpreadsheet();
        }
    }

    private void initEventHandler() {
        textFieldSPV.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                String result = controller.receiveText(textFieldSPV.getText());
                int column = spv.getSelectionModel().getFocusedCell().getColumn();
                int row = spv.getSelectionModel().getFocusedCell().getRow();
                grid.setCellValue(row, column, textFieldSPV.getText());
                model.setCellValue(row, column, true, result);
            }
        });

        buttonRowM.setOnAction(actionEvent -> {
            controller.decRow();
            hideRowsColumns();
        });

        buttonRowP.setOnAction(actionEvent -> {
            controller.incRow();
            hideRowsColumns();
        });

        buttonColM.setOnAction(actionEvent -> {
            controller.decCol();
            hideRowsColumns();
        });

        buttonColP.setOnAction(actionEvent -> {
            controller.incCol();
            hideRowsColumns();
        });

        toggleSwitchFV.setOnMouseClicked(mouseEvent -> {
            boolean switchValue = toggleSwitchFV.isSelected();
            grid = controller.toggleSwitched(switchValue);
            System.out.println(ApplicationModel.getCellValue(0, 0, false));
            spv.getSelectionModel().clearSelection();

            updSpreadsheet();

            if (switchValue) {
                textFieldSPV.setDisable(true);
                buttonColM.setDisable(true);
                buttonColP.setDisable(true);
                buttonRowM.setDisable(true);
                buttonRowP.setDisable(true);

                //Toggle for Spreadsheet access
                //Default - false
                //spv.setEditable(false);
            } else {
                textFieldSPV.setDisable(false);
                buttonColM.setDisable(false);
                buttonColP.setDisable(false);
                buttonRowM.setDisable(false);
                buttonRowP.setDisable(false);

                //Toggle for Spreadsheet access
                //Default - false
                //spv.setEditable(true);
            }
        });

        menuISave.setOnAction(actionEvent -> {
            TextInputDialog textInputDialog = new TextInputDialog();

            textInputDialog.setTitle("Зберегти таблицю");
            textInputDialog.setHeaderText("Введіть назву таблиці");
            textInputDialog.setContentText("Name: ");
            Optional<String> result = textInputDialog.showAndWait();
            result.ifPresent(name -> {
                try {
                    controller.saveSpreadsheetCall(name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            updSpreadsheet();
        });

        menuIOpen.setOnAction(actionEvent -> {
            TextInputDialog textInputDialog = new TextInputDialog();

            textInputDialog.setTitle("Відкрити таблицю");
            textInputDialog.setHeaderText("Введіть назву таблиці");
            textInputDialog.setContentText("Name: ");
            Optional<String> result = textInputDialog.showAndWait();
            result.ifPresent(name -> {
                try {
                    controller.openSpreadsheetCall(name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            //using a method for a toggle switch when it wasn't switched
            grid = controller.toggleSwitched(toggleSwitchFV.isSelected());
            updSpreadsheet();
        });

        menuIFunctions.setOnAction(actionEvent -> {
            Stage popupStage = new Stage();
            Label popupText = new Label();
            popupText.setTextAlignment(TextAlignment.LEFT);
            popupText.setWrapText(true);

            String line;
            String message = "";
            String txtPath = "src\\main\\resources\\uni\\makarov\\lab1\\functions.txt";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(txtPath));
                while ((line = bufferedReader.readLine()) != null) {
                    message += (line + "\n");
                }
                popupText.setText(message);
            } catch (FileNotFoundException e) {
                popupText.setText("ERROR: UNABLE TO GET TEXT");
            } catch (IOException e) {
                popupText.setText("ERROR: UNABLE TO GET TEXT");
            }
            popupStage.setTitle("Функціонал");
            popupStage.setScene(new Scene(popupText, 300, 500));
            //popupStage.setResizable(false);
            popupStage.show();
        });

        menuIErrors.setOnAction(actionEvent -> {
            Stage popupStage = new Stage();
            Label popupText = new Label();
            popupText.setTextAlignment(TextAlignment.LEFT);
            popupText.setWrapText(true);


            String line;
            String message = "";
            String txtPath = "src\\main\\resources\\uni\\makarov\\lab1\\errors.txt";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(txtPath));
                while ((line = bufferedReader.readLine()) != null) {
                    message += (line + "\n");
                }
                popupText.setText(message);
            } catch (FileNotFoundException e) {
                popupText.setText("ERROR: UNABLE TO GET TEXT");
            } catch (IOException e) {
                popupText.setText("ERROR: UNABLE TO GET TEXT");
            }
            popupStage.setTitle("Помилки");
            popupStage.setScene(new Scene(popupText, 300, 500));
            //popupStage.setResizable(false);
            popupStage.show();
        });

    }

    public Parent asParent() {
        return root;
    }

}
