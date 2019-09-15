package DDT;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


//This class reads a given *.xlsx file and a given spreadsheet
public class ExcelSheetReader {

    private XSSFWorkbook excelWBook;
    private XSSFSheet excelWSheet;

    //Reading a spreadsheet with a given name *.xlsx
    public void setExcelFileSheet(String excelFileLocation, String sheetName) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(excelFileLocation);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        if (excelWSheet == null) {
            throw new RuntimeException("Excel Sheet was null! Please check name of the excel sheet!");
        }
    }

    public XSSFSheet getExcelSheet() {
        return excelWSheet;
    }

}
