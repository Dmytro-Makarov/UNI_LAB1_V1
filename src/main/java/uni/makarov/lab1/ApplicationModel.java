package uni.makarov.lab1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.controlsfx.control.spreadsheet.*;
import uni.makarov.parser.GrammarLexer;
import uni.makarov.parser.GrammarParser;


//Inner Logic
public class ApplicationModel {
    //TODO: Connect Parser
    static GridBase gridFunc;
    static GridBase gridValue;
    int rowCount;
    int columnCount;
    final int realRowCount = 100;
    final int realColumnCount = 100;

    ApplicationModel(){}

    //Initializes two grids: function and value grids
    GridBase initGrids(int rows, int columns){
        rowCount = rows;
        columnCount = columns;
        gridFunc = new GridBase(realRowCount, realColumnCount);
        gridValue = new GridBase(realRowCount, realColumnCount);

        ObservableList<ObservableList<SpreadsheetCell>> rowsF = FXCollections.observableArrayList();
        ObservableList<ObservableList<SpreadsheetCell>> rowsV = FXCollections.observableArrayList();
        for (int row = 0; row < gridFunc.getRowCount(); ++row) {
            ObservableList<SpreadsheetCell> listV = FXCollections.observableArrayList();
            ObservableList<SpreadsheetCell> listF = FXCollections.observableArrayList();
            for (int column = 0; column < gridValue.getColumnCount(); ++column) {
                listV.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1,""));
                listF.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1,""));
            }
            rowsV.add(listV);
            rowsF.add(listF);
        }
        //Set the rows in the grid.
        gridValue.setRows(rowsV);
        gridFunc.setRows(rowsF);

        return gridFunc;
    }

    GridBase getGrid(boolean gridType){
        System.out.println(gridType);
        if(gridType){
            return gridValue;
        }
        else return gridFunc;
    }

    void setRowCount(int value){
        rowCount = value;
    }

    void setColumnCount(int value){
        columnCount = value;
    }

    void incRowCount(){
         ++rowCount;
    }
    void incColumnCount(){
        ++columnCount;
    }
    void decRowCount(){
        --rowCount;
    }
    void decColumnCount(){
        --columnCount;
    }

    int getRowCount(){
        return rowCount;
    }

    int getColumnCount(){
        return columnCount;
    }

    int getRealRowCount(){
        return realRowCount;
    }

    int getRealColumnCount(){
        return realColumnCount;
    }

    public void setCellValue(int row, int column, boolean gridType, Object value){
        if (gridType){
            gridValue.setCellValue(row, column, value);
        } else {
            gridValue.setCellValue(row, column, value);
        }
    }

    static public Object getCellValue(int row, int column, boolean gridType){
        SpreadsheetView gridAccess;
        if(gridType){ gridAccess = new SpreadsheetView(gridValue);}
        else {gridAccess = new SpreadsheetView(gridFunc);}
        ObservableList accessRows = gridAccess.getItems();
        ObservableList accessColumns = (ObservableList) accessRows.get(row);
        SpreadsheetCell cell = (SpreadsheetCell) accessColumns.get(column);
        String result = cell.getText();
        return result;
    }

    String parse(String string){

        CharStream input = CharStreams.fromString(string);
        GrammarLexer lexer = new GrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);

        ParseTree tree = parser.parse();

        GrammarVisitor visitor = new GrammarVisitor();
        String result = String.valueOf(visitor.visit(tree));

        System.out.println(tree.toStringTree(parser));
        System.out.println(result);

        return result;
    }

}
