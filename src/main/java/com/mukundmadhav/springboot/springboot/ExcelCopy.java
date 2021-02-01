package com.mukundmadhav.springboot.springboot;


import cn.hutool.poi.excel.ExcelBase;
import cn.hutool.poi.excel.ExcelFileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExcelCopy {
    public static void excel() {
        ExcelReader reader = ExcelUtil.getReader("L:\\1.xls");
        Workbook sheets1 =reader.getWorkbook();
//        Workbook sheets1 = ExcelUtil.loadBook("L:\\1.xls");
        Sheet sheetAt = sheets1.getSheetAt(0);
//        sheetAt.getPhysicalNumberOfRows();
//        sheetAt.createRow(1);
//        sheetAt.addMergedRegion(null);//.createDrawingPatriarch();
        Row row1 = sheetAt.getRow(1);
        Cell cell1 = row1.getCell(3);


        Workbook book2 = ExcelUtil.getReader("L:\\2.xls").getWorkbook();//ExcelUtil.loadBook("L:\\2.xls");
        Sheet sheetAt2 = book2.getSheetAt(0);
//        sheetAt.getPhysicalNumberOfRows();
//        sheetAt.createRow(1);
//        sheetAt.addMergedRegion(null);//.createDrawingPatriarch();
        Row row2 = sheetAt2.getRow(1);

        Cell cell = row2.createCell(15);
        cell.setCellType(cell1.getCellType());
        cell.setCellValue(cell1.getStringCellValue());

//        Workbook book = ExcelUtil.createBook("L:\\asdf1.xlsx");
        try {
//            ExcelUtil.writeBook(book2, new FileOutputStream(new File("L:\\3.xlsx")));
            ExcelWriter writer = ExcelUtil.getWriter("L:\\3.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }


//        ExcelWriter writer = ExcelUtil.getWriter("asdf.xlsx");
//        writer.
//        ExcelWriter write = writer.write(sheets);
//        write.flush();
    }
}
