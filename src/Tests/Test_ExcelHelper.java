package Tests;

import Helpers.ExcelHelper;

public class Test_ExcelHelper {

    private String path;

    public Test_ExcelHelper(String path) {
        this.path = path;
    }

    public void test_readAndPrintFromDesiredSheet(int sheetIndex) {
        ExcelHelper helper = new ExcelHelper(this.path); // making an object of
        helper.readExcelFile();
        // getting row count...
        int totalRows = helper.getRowCount(sheetIndex); // sheet with index 0, first sheet...
        Object[][] rowsData = new Object[totalRows][5]; // columns count = 5, indicating total fields...(known to prior)

        for(int i=0; i<totalRows; i++) {
            rowsData[i][0] = helper.getInfoAt(0, i, 0);
            rowsData[i][1] = helper.getInfoAt(0, i, 1);
            rowsData[i][2] = helper.getInfoAt(0, i, 2);
            rowsData[i][3] = helper.getInfoAt(0, i, 3);
            rowsData[i][4] = helper.getInfoAt(0, i, 4);
        }

        PrintData(rowsData);
    }

    public void test_rowCountFromDesiredSheet(int sheetIndex) {
        ExcelHelper helper = new ExcelHelper(this.path);
        helper.readExcelFile();

        // get row count in sheet with index 0...
        int totalRows = helper.getRowCount(sheetIndex);
        System.out.println("Total Rows : "+totalRows);

    }

    private void PrintData(Object[][] data) {
        for (Object[] datum : data) {
            String rowInfo = "";
            for (Object o : datum) {
                rowInfo = rowInfo.concat(String.format("%10s", (String) o)).concat("  ");
            }
            System.out.println(rowInfo);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) {

        Test_ExcelHelper tester = new Test_ExcelHelper("/Users/henil/Downloads/Test_CharusatResultRandomData.xlsx");
        tester.test_rowCountFromDesiredSheet(0);
        tester.test_rowCountFromDesiredSheet(1);

        tester.test_readAndPrintFromDesiredSheet(0);
    }

}
