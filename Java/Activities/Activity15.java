package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Activity15 {
    private static String FILE_NAME = "resources/TestSheet.xlsx";
    public static void main(String[] args) throws IOException
    {

        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Data types in java");

        Object[][] datatypes = {
                {"DataType" ,"Type" ,"Size(Bytes)"},
                {"int" ,"primitive" ,"2"},
                {"float" ,"primitive" ,"4"},
                {"double" ,"primitive" ,"8"},
                {"char" ,"primitive" ,"1"},
                {"string" ,"non primitive" ,"No Fixed size"}


        };

        int rownum = 0;
        System.out.println("Creating excel sheet");
        for (Object[] datatype:datatypes)
        {
            Row row = sheet.createRow(rownum++);

            int cellnum = 0;
            for (Object obj : datatypes)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(FILE_NAME));
            workbook.write(out);
            out.close();
            System.out.println("written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
