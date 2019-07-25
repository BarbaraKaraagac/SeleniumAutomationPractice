package DDT;

import java.io.IOException;
import java.util.List;

public class ExcelFileReader {

    public static void main(String[] args) {

        //Input column index
        int queryColumn = 0;

        //Expected Result index in the Spreadsheet
        int expectedResultColumn = 1;

        ExcelSheetReader excelSheetReader = new ExcelSheetReader();

        try {
            //Reading from the file
            String excelFileLocation = "C:\\Users\\Basia\\Desktop\\seleniumintro2\\src\\main\\resources\\DDT_FILE.xlsx";
            excelSheetReader.setExcelFileSheet(excelFileLocation, "GoogleSearch");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SheetDataReader sheetDataReader = new SheetDataReader(excelSheetReader.getExcelSheet());

        List<String> searchQueryList = sheetDataReader.getDataForColumn(queryColumn);

        List<String> expectedResultList = sheetDataReader.getDataForColumn(expectedResultColumn);

        System.out.println(searchQueryList.toString());
        System.out.println(expectedResultList.toString());
    }

}
