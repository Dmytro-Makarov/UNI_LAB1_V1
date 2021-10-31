package uni.makarov.lab1;

public class CellID {
    String name;
    int row;
    int column;

    CellID(String name){
        this.name = name;
        getRowColFromName();
    }

    CellID(int row, int column){
        this.row = row;
        this.column = column;
    }

    void getRowColFromName(){
        String[] split = name.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        row = Integer.parseInt(split[1]);
        char[] columnCharArr = split[0].toCharArray();
        column = 0;
        for(int character = 0; character <= columnCharArr.length - 1; ++character){
            column += (columnCharArr[character] - 65) + Math.pow(26, character);
        }
        row--;
        column--;
    }
}
