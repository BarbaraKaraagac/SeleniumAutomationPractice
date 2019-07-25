package DDT;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Reading rows of a given column
public class SheetDataReader {

    private static final int HEADER_COLUMN_INDEX = 0;
    private XSSFSheet excelWSheet;

    public SheetDataReader(XSSFSheet excelWSheet) {
        this.excelWSheet = excelWSheet;
    }

    public List<String> getDataForColumn(int columnIndex) {
        List<String> listOfData = new ArrayList<>();
        Iterator<Row> rowIterator = excelWSheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (row.getRowNum() > HEADER_COLUMN_INDEX) {
                    if (cell.getColumnIndex() == columnIndex) {
                        String stringCellValue = cell.getStringCellValue();
                        listOfData.add(stringCellValue);
                    }
                }
            }
        }
        return listOfData;
    }
}