package controller;

import db.Storage;
import models.Petrol;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static db.Storage.petrols;

public class MenuHandlerExcel {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {          // создание стиля для заголовка
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void createExcel() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();    //создаем книгу
        HSSFSheet sheet = workbook.createSheet("Reestr benzin");    //создаем страницу в книге с именем "Reestr benzin"

       // int rownum = 0;      // простой счетчик, обьявляем и инициализируем его
        Row row;             // Row - строка, обьявляем строку с именем row
        Cell cell;           // Cell - ячейка, обьявляем ячейку с именем cell

        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(0);              // row - строка, rownum - порядковый номер строки как в массиве
        cell = row.createCell(8, CellType.STRING);  // i - столбец в строке - row с порядковым номером - rownum
        cell.setCellValue("Затверджую");
        cell.setCellStyle(style);

        row = sheet.createRow(2);
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("_________");
        cell.setCellStyle(style);
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("ПІБ");
        cell.setCellStyle(style);


        row = sheet.createRow(5);
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("РЕЕСТР");
        cell.setCellStyle(style);

        int rownum = 7;      // простой счетчик, обьявляем и инициализируем его

        row = sheet.createRow(rownum);

        // ячейка 0
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("№ з/п");
        cell.setCellStyle(style);
        // ячейка 1
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Дата");
        cell.setCellStyle(style);
        // ячейка 2
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Показання спідометра при виїзді (км.)");
        cell.setCellStyle(style);
        // ячейка 3
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Показання спідометра при поверненні (км.)");
        cell.setCellStyle(style);
        // ячейка 4
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Пробіг (км.)");
        cell.setCellStyle(style);
        // ячейка 5
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Залишок при виїзді з гаражу (л.)");
        cell.setCellStyle(style);
        // ячейка 6
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Видано (л.)");
        cell.setCellStyle(style);
        // ячейка 7
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Витрати пального (л.)");
        cell.setCellStyle(style);
        // ячейка 8
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("Залишок при поверненні в гараж (л.)");
        cell.setCellStyle(style);
        // ячейка 9
        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("Примітки");
        cell.setCellStyle(style);

        for (Petrol p : petrols) {
            rownum++;
            row = sheet.createRow(rownum);
            // ячейка 0 - A
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(rownum);
            // ячейка 1 - B
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(p.getData());          //   если использовать индекс ArrayList то команда получить эти данные такая: Storage.petrols.get(i).getData()
            // ячейка 2 - C
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(p.getSpeedometerExit());
            // ячейка 3 - D
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(p.getSpeedometerEntry());
            // ячейка 4 - E
            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(p.getDictance());
            // ячейка 5 - F
            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue(p.getRemainingFuelExit());
            // ячейка 6 - G
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(" ");
            // ячейка 7 - H
            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(p.getFuelUsed());
            // ячейка 8 - I
            cell = row.createCell(8, CellType.NUMERIC);
            cell.setCellValue(p.getRemainingFuelEntry());
            // ячейка 9 - J
//            String formula = "E*H";
//            cell = row.createCell(9, CellType.FORMULA);
//            cell.setCellValue(formula);
//            // ячейка 9 - J
//            cell = row.createCell(9, CellType.STRING);
//            cell.setCellValue("   ");
        }
        row = sheet.createRow(++rownum);
        String formula = "SUM(E8:E" + (rownum) + ")";     // создаем переменную с записаной формулой
        cell = row.createCell(4, CellType.FORMULA);         // создаем ячейку куда вставим формулу
        cell.setCellFormula(formula);                            // вставляем в ячейку формулу

        String formula1 = "SUM(H8:H" + (rownum) + ")";
        cell = row.createCell(7, CellType.FORMULA);
        cell.setCellFormula(formula1);

        rownum = rownum + 3;
        row = sheet.createRow(rownum);              // создаем строку ниже последней на 3
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Спеціаліст");
        cell.setCellStyle(style);

        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("ПІБ");
        cell.setCellStyle(style);


        File file = new File("C:/demo/benzin.xls");
        file.getParentFile().mkdirs();                       // создаем каталог файлу

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("\u001B[1;32m" + "Был создан Excel файл: " + file.getAbsolutePath() + "\u001B[0m");


    }
}
