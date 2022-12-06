/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Service.ExcelServices;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author haha
 */
public class ExcelServicesImpl implements ExcelServices {

    @Override
    public List<String> getFile(String link) {
        List<String> ix = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(link);
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet xs = wb.getSheetAt(0);
            FormulaEvaluator formula = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : xs) {
                String Imei = "";
                for (Cell cell : row) {
                    if (cell.getAddress().getColumn() == 0) {
                        DecimalFormat df = new DecimalFormat("######################");
                        Imei = df.format(cell.getNumericCellValue());

                    }

                }
                ix.add(Imei);
            }
            wb.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return ix;
    }

}
