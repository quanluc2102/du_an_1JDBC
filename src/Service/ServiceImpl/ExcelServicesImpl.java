/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChucVu;
import Service.ExcelServices;
import com.barcodelib.barcode.Linear;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
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

    @Override
    public String barCode(String nhap, String link) {
        try {
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128B);
            barcode.setData(nhap);//nội dung cần chuyển
            barcode.setI(11.0f);
            barcode.renderBarcode(link);//vị trí xuất ảnh ra

        } catch (Exception e) {
            e.printStackTrace();
            return "Xuất thất bại";
        }

        return "xuất thành công";
    }

    @Override
    public String barCodeIMEI(String link) {
        String xuat = "";
        try {
            InputStream barInput = new FileInputStream(link);
            BufferedImage barRead = ImageIO.read(barInput);
            LuminanceSource source = new BufferedImageLuminanceSource(barRead);
            BinaryBitmap bitMap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            Result res = reader.decode(bitMap);
            xuat = res.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xuat;
    }

    @Override
    public String exFileexcel(String link, List<ChucVu> vc) {

        System.out.println("Create file excel");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("ChucVu_Info");
        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("List of ChucVu");

        for (ChucVu customer : vc) { // tạo model excel
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(customer.getId());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(customer.getMa());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(customer.getTen());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("source\\24.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "xuất thất bại";
        } catch (IOException e) {
            e.printStackTrace();
            return "xuất thất bại";
        }

        return "xuất thành công";

    }

}
