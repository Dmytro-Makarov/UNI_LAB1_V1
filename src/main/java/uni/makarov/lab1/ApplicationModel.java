package uni.makarov.lab1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;
import uni.makarov.parser.GrammarLexer;
import uni.makarov.parser.GrammarParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;


//Inner Logic
public class ApplicationModel {
    static GridBase gridFunc;
    static GridBase gridValue;
    final int realRowCount = 100;
    final int realColumnCount = 100;
    int rowCount;
    int columnCount;

    ApplicationModel() {
    }

    static public Object getCellValue(int row, int column, boolean gridType) {
        SpreadsheetView gridAccess;
        if (gridType) {
            gridAccess = new SpreadsheetView(gridValue);
        } else {
            gridAccess = new SpreadsheetView(gridFunc);
        }
        ObservableList accessRows = gridAccess.getItems();
        ObservableList accessColumns = (ObservableList) accessRows.get(row);
        SpreadsheetCell cell = (SpreadsheetCell) accessColumns.get(column);
        return cell.getText();
    }

    //Initializes two grids: function and value grids
    GridBase initGrids(int rows, int columns) {
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
                listV.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1, ""));
                listF.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1, ""));
            }
            rowsV.add(listV);
            rowsF.add(listF);
        }
        //Set the rows in the grid.
        gridValue.setRows(rowsV);
        gridFunc.setRows(rowsF);

        return gridFunc;
    }

    GridBase getGrid(boolean gridType) {
        System.out.println(gridType);
        if (gridType) {
            return gridValue;
        } else return gridFunc;
    }

    void incRowCount() {
        ++rowCount;
    }

    void incColumnCount() {
        ++columnCount;
    }

    void decRowCount() {
        --rowCount;
    }

    void decColumnCount() {
        --columnCount;
    }

    int getRowCount() {
        return rowCount;
    }

    void setRowCount(int value) {
        rowCount = value;
    }

    int getColumnCount() {
        return columnCount;
    }

    void setColumnCount(int value) {
        columnCount = value;
    }

    int getRealRowCount() {
        return realRowCount;
    }

    int getRealColumnCount() {
        return realColumnCount;
    }

    public void setCellValue(int row, int column, boolean gridType, Object value) {
        if (gridType) {
            gridValue.setCellValue(row, column, value);
        } else {
            gridFunc.setCellValue(row, column, value);
        }
    }

    String parse(String string) {
        String result;

        CharStream input = CharStreams.fromString(string);
        GrammarLexer lexer = new GrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);

        ParseTree tree = parser.parse();

        GrammarVisitor visitor = new GrammarVisitor();

        try {
            result = String.valueOf(visitor.visit(tree));
        } catch (NullPointerException e) {
            return "NullPointerException";
        } catch (ArithmeticException e) {
            return "Division by zero!";
        }
        System.out.println(tree.toStringTree(parser));
        System.out.println(result);

        return result;
    }

    public void saveSpreadsheet(String fileName) throws Exception {
        if (!fileName.contains(".txt")) {
            fileName = fileName.trim() + ".txt";
        }
        BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName));

        bfw.write(getRowCount() + ";");
        bfw.write(getColumnCount() + ";\n");
        for (int row = 0; row < getRowCount(); row++) {
            for (int column = 0; column < getColumnCount(); column++) {
                if (getCellValue(row, column, false) != "" && getCellValue(row, column, false) != null) {
                    bfw.write(row + ";");
                    bfw.write(column + ";");
                    bfw.write(getCellValue(row, column, false) + ";");
                    bfw.write(getCellValue(row, column, true) + ";");
                    bfw.write("\n");
                    bfw.flush();
                }
            }
        }
    }

    public void loadSpreadsheet(String fileName) throws FileNotFoundException {
        if (!fileName.contains(".txt")) {
            fileName = fileName.trim() + ".txt";
        }

        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter(";");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?|(\n)?");

        int row = Integer.parseInt(scanner.next());
        int column = Integer.parseInt(scanner.next());
        scanner.nextLine();
        setRowCount(row);
        setColumnCount(column);

        initGrids(row, column);

        while (scanner.hasNext()) {
            int r = Integer.parseInt(scanner.next());
            int c = Integer.parseInt(scanner.next());
            setCellValue(r, c, false, scanner.next());
            setCellValue(r, c, true, scanner.next());
            scanner.nextLine();
        }


    }

}
