package Helpers;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class will help you in reading the Excel files,
 * you can directly pass the file path and all the methods
 * are here to help you in reading and all that stuff!
 * */
public class ExcelHelper {

    protected XSSFWorkbook workBook;
    protected XSSFSheet sheetInWorkBook;
    protected String path;

    public ExcelHelper(String path) {
        this.path = path;
    }

    public void readExcelFile() {
        this.readExcelFile(this.path);
    }

    public void readExcelFile(String path) {
        this.path = path;
        File sourceFile = new File(path);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(sourceFile);
            workBook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getInfoAt (int sheetNumber, int row, int column) {
        sheetInWorkBook = workBook.getSheetAt(sheetNumber);
        return sheetInWorkBook.getRow(row).getCell(column).getStringCellValue();
    }
    public int getRowCount(int sheetNumber) {
        return workBook.getSheetAt(sheetNumber).getLastRowNum() + 1;
    }

}
