/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import DomainModel.ChucVu;
import Service.ExcelServices;
import ViewModel.ChucVuViewModel;
import ViewModel.ThongKeViewModel;
import ViewModel.ThongSoViewModel;
import com.barcodelib.barcode.Linear;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
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
            barcode.setData(nhap);//n???i dung c???n chuy???n
            barcode.setI(11.0f);
            barcode.renderBarcode(link);//v??? tr?? xu???t ???nh ra

        } catch (Exception e) {
            e.printStackTrace();
            return "Xu???t th???t b???i";
        }

        return "xu???t th??nh c??ng";
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

//    @Override
//    public String xuatExecl( List<ChucVuViewModel> vc) {
//
//        System.out.println("Create file excel");
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("ChucVu_Info");
//        int rowNum = 0;
//        Row firstRow = sheet.createRow(rowNum++);
//        Cell firstCell = firstRow.createCell(0);
//        firstCell.setCellValue("List of ChucVu");
//
//        for (ChucVuViewModel customer : cv) { // t???o model excel
//            Row row = sheet.createRow(rowNum++);
//            Cell cell1 = row.createCell(0);
//            cell1.setCellValue(customer.getId());
//            Cell cell2 = row.createCell(1);
//            cell2.setCellValue(customer.getMa());
//            Cell cell3 = row.createCell(2);
//            cell3.setCellValue(customer.getTen());
//        }
//          
//        try {
//            FileOutputStream outputStream = new FileOutputStream("C:\\Apps\\chuc vug.xlsx");
//            workbook.write(outputStream);
//            workbook.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return "xu???t th???t b???i";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "xu???t th???t b???i";
//        }
//
//        return "xu???t th??nh c??ng";
//
//    }


    @Override
    public void xuatExecl(List<ThongKeViewModel> tkk, String file) {
            System.out.println("Create File Excel");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("List of Bill");
        int rowNum = 3;
        Row firstRow = sheet.createRow(rowNum++);

        // tao dinh dang 
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // font color

        // tao cell style: nen xanh, dinh dang border duoi
        CellStyle cellstyle = sheet.getWorkbook().createCellStyle();
        cellstyle.setFont(font);
        cellstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellstyle.setBorderBottom(BorderStyle.THIN);

        Cell CellIM = firstRow.createCell(0);
        CellIM.setCellStyle(cellstyle);
        CellIM.setCellValue("IMEI");

        Cell cellMHD = firstRow.createCell(1);
        cellMHD.setCellStyle(cellstyle);
        cellMHD.setCellValue("M?? h??a ????n");

        Cell cellGiaBan = firstRow.createCell(2);
        cellGiaBan.setCellStyle(cellstyle);
        cellGiaBan.setCellValue("Gi?? b??n");

        Cell cellNgayTao = firstRow.createCell(3);
        cellNgayTao.setCellStyle(cellstyle);
        cellNgayTao.setCellValue("Ng??y t???o");

        Cell cellGiaGiam = firstRow.createCell(4);
        cellGiaGiam.setCellStyle(cellstyle);
        cellGiaGiam.setCellValue("Gi?? gi???m");
        Cell cellGiaNhap = firstRow.createCell(5);
        cellGiaNhap.setCellStyle(cellstyle);
        cellGiaNhap.setCellValue("Gi?? nh???p");
        Cell cellLai = firstRow.createCell(6);
        cellLai.setCellStyle(cellstyle);
        cellLai.setCellValue("L??i");



        for (ThongKeViewModel view : tkk) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(view.getImei());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(view.getMaHD());

            Cell cell3 = row.createCell(2);
            cell3.setCellValue(view.getGiaBan());

            Cell cell4 = row.createCell(3);
            cell4.setCellValue(String.valueOf(view.getNgayTao()));

            Cell cell5 = row.createCell(4);
            cell5.setCellValue(view.giaGiam());
            Cell cell6 = row.createCell(5);
           cell6.setCellValue(view.getGiaNhap());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(view.getGiaBan() - (view.giaGiam())-(view.getGiaNhap()));

           
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            workbook.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   

}
