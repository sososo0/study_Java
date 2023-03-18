package table;

import javax.swing.table.DefaultTableModel;

public class PersonTableModel extends DefaultTableModel{

    private static final Object [] header = {"First Name","Last Name","Sport","# of Years","Vegetarian"};
    private static Object [][] contents = {
            {"Kathy","Smith","Snow Boarding","5","false"},
            {"John","Doe","Rowing","3","true"},
            {"Sue","Black","Knitting","2","false"},
            {"Jane","White","Speed reading","20","true"},
            {"Joe","Brown","Pool","10","false"}
    };

    public PersonTableModel(){
        super(contents,header);
    }

}
