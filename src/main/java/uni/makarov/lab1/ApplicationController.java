package uni.makarov.lab1;

import org.controlsfx.control.spreadsheet.GridBase;

//Process Data from UI
public class ApplicationController {
    ApplicationModel model;

    ApplicationController(ApplicationModel model){
        this.model = model;
    }

    protected void incCol(){
        model.incColumnCount();
    }
    protected void decCol(){
        model.decColumnCount();
    }
    protected void incRow(){
        model.incRowCount();
    }
    protected void decRow(){
        model.decRowCount();
    }

    protected String receiveText(String text){
        //Parse text
        return model.parse(text);
    }

    protected void saveSpreadsheetCall(String name) throws Exception {
        model.saveSpreadsheet(name);
    }

    protected void openSpreadsheetCall(String name) throws Exception {
        model.loadSpreadsheet(name);
    }

    protected GridBase toggleSwitched(boolean switchValue){
        return model.getGrid(switchValue);
    }
}