package local.bubblegum.ApachePOI.xl;

import org.apache.poi.ss.formula.functions.Code;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class XLProcessor {


    public void readXLFile() {
        try (InputStream inp = new FileInputStream("d:\\inf\\work\\03RS0001_BarcodeScanner.xls")) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheet("Barcode");
            int max = sheet.getLastRowNum();
            sheet.forEach(crow -> {
                crow.forEach(ccol -> {
                    System.out.print("[" + ccol.getStringCellValue() + "]");
                });
                System.out.println();
            });

            System.out.println(max);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
