package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity15Read {
    private static String FILE_NAME = "resources/TestSheet.xlsx";
        public static void main(String[] args)
        {
            try
            {
                FileInputStream file = new FileInputStream(new File(FILE_NAME));

                //Create Workbook instance holding reference to .xlsx file
                XSSFWorkbook workbook = new XSSFWorkbook(file);

                //Get first/desired sheet from the workbook
                XSSFSheet sheet = workbook.getSheetAt(0);

                //Iterate through each rows one by one
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext())
                {
                    List<String> rowdata=new ArrayList<String>();
                    Row row = rowIterator.next();
                    //For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext())
                    {
                        Cell cell = cellIterator.next();
                        //Check the cell type and format accordingly
                        if(cell.getCellType()== CellType.STRING){
                            System.out.print(cell.getNumericCellValue() + "t");
                            rowdata.add(cell.getStringCellValue());
                        }
                        else if(cell.getCellType()== CellType.NUMERIC){
                            System.out.print(cell.getStringCellValue() + "t");
                    }
                    }
                    System.out.println("");
                }
                file.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

}
