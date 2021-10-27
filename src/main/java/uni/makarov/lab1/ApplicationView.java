package uni.makarov.lab1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;


///Window Hierarchy///
/*
VBox
	MenuBar
		*Menu panels*
	SplitPane (Vertical)
		AnchorPane (VBox?)
			*Buttons, Toggles, etc.*
		SplitPane(Horizontal)
				TextField
				SpreadsheetView
	HBox

*/

///Toolbox///
/*
Add/Remove a column/row
Toggle Function/Value view
Maybe: Zoom slider
*/

/*
TODO:   Idea: Make a big GridBase and hide all of the unnessessary rows and columns
        Make buttons hide and show next rows and columns
*/
//UI
public class ApplicationView {
    private VBox root;

    private MenuBar menuBar;
    private Menu menu1;

    private ToggleSwitch toggleSwitchFV;
    private Button buttonRowM;
    private Button buttonRowP;
    private Button buttonColM;
    private Button buttonColP;

    private GridBase grid;
    private SpreadsheetView spv;
    private TextField textField;

    private ApplicationController controller;
    private ApplicationModel model;

    public ApplicationView(ApplicationController controller, ApplicationModel model){
        this.controller = controller;
        this.model = model;

        initUI();
    }

    private void initUI(){
        root = new VBox();
        root.setFillWidth(true);

        menuBar = new MenuBar();

        menu1 = new Menu("Placeholder");
        menuBar.getMenus().add(menu1);
        root.getChildren().add(menuBar);

        initMain();
        initEventHandler();
    }

    private void setAnchors(Node node, double topAnchor, double bottomAnchor, double leftAnchor, double rightAnchor){
        if (topAnchor != 0){
            AnchorPane.setTopAnchor(node, topAnchor);
        }
        if (bottomAnchor != 0) {
            AnchorPane.setBottomAnchor(node, bottomAnchor);
        }
        if (leftAnchor != 0) {
            AnchorPane.setLeftAnchor(node, leftAnchor);
        }
        if (rightAnchor != 0){
            AnchorPane.setRightAnchor(node, rightAnchor);
        }
    }

    private void initMain(){
        //SPLIT_PANE HORIZONTAL
        SplitPane splitPaneHOR = new SplitPane();

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

        vboxSPH1.getChildren().add(anchorPaneVB1);
        vboxSPH1.getChildren().add(anchorPaneVB2);
        vboxSPH1.getChildren().add(anchorPaneVB3);

        splitPaneHOR.getItems().add(vboxSPH1);
        vboxSPH1.maxWidthProperty().bind(splitPaneHOR.widthProperty().multiply(0.225));
        vboxSPH1.minWidth(250);

        SplitPane splitPaneVER = new SplitPane();
        splitPaneVER.setOrientation(Orientation.VERTICAL);

        //TEXT FIELD for functions
        textField = new TextField("Функція тут");

        //Create Spreadsheet
        grid = model.initGrids(10,15);
        spv = new SpreadsheetView(grid);
        hideRowsColumns();

        spv.setEditable(false);

        //SPLIT_PANE VERTICAL
        splitPaneVER.getItems().add(textField);
        splitPaneVER.getItems().add(spv);

        splitPaneHOR.getItems().add(splitPaneVER);
        splitPaneHOR.setDividerPositions(0.25);

        root.getChildren().add(splitPaneHOR);
    }

    private boolean hideRowsColumns(){
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
            } catch (IndexOutOfBoundsException e){
                System.err.print("ROW/COLUMN INDEX OUT OF BOUNDS!\nSetting default values...\n");
                textField.setText("ERR:ROW/COLUMN INDEX OUT OF BOUNDS!");
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

    private void initEventHandler(){
            textField.setOnKeyPressed(event -> {
                if(event.getCode().equals(KeyCode.ENTER)){
                    String result = controller.receiveText(textField.getText());
                    int column = spv.getSelectionModel().getFocusedCell().getColumn();
                    int row = spv.getSelectionModel().getFocusedCell().getRow();
                    grid.setCellValue(row, column, textField.getText());
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
                System.out.println(model.getCellValue(0,0, false));
                spv.getSelectionModel().clearSelection();
                //TODO:Maybe send selected cell to parse anyway

                updSpreadsheet();

                if (switchValue){
                    textField.setDisable(true);
                    buttonColM.setDisable(true);
                    buttonColP.setDisable(true);
                    buttonRowM.setDisable(true);
                    buttonRowP.setDisable(true);

                    //Toogle for Spreadsheet access
                    //Default - false
                    //spv.setEditable(false);
                } else {
                    textField.setDisable(false);
                    buttonColM.setDisable(false);
                    buttonColP.setDisable(false);
                    buttonRowM.setDisable(false);
                    buttonRowP.setDisable(false);

                    //Toogle for Spreadsheet access
                    //Default - false
                    //spv.setEditable(true);
                }


            });
    }

    public Parent asParent(){
        return root;
    }

}
