package controller;

import models.Petrol;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static db.Storage.petrols;

public class MenuHandlerExcel {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {          // создание стиля для заголовка таблицы
        HSSFFont font = workbook.createFont();
        font.setBold(true);// установление шрифта - Bold - жирный шрифт(true)
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);                                 // установление шрифта в ячейку
        style.setWrapText(true);                             // устанавливаем перенос слов
        style.setAlignment(HorizontalAlignment.CENTER);      // устанавливаем размещение в ячейках по центру
        style.setVerticalAlignment(VerticalAlignment.CENTER); // устанавливаем размещение в ячейках относительно вертикали по центру
        style.setBorderBottom(BorderStyle.THIN);              //устанавливаем границу прорисовки ячейки setBorderBottom(BorderStyle.THIN); - Нижняя граница
        style.setBorderTop(BorderStyle.THIN);                //устанавливаем границу прорисовки ячейки setBorderTop(BorderStyle.THIN); - Верхняя граница
        style.setBorderRight(BorderStyle.THIN);              //устанавливаем границу прорисовки ячейки setBorderRight(BorderStyle.THIN); - Правая граница
        style.setBorderLeft(BorderStyle.THIN);               //устанавливаем границу прорисовки ячейки setBorderLeft(BorderStyle.THIN); - Левая граница
        return style;
    }

    private static HSSFCellStyle createStyleForTitle1(HSSFWorkbook workbook) {          // создание стиля для текста вокрук таблицы
        HSSFFont font = workbook.createFont();
        font.setBold(true);// установление шрифта - Bold - жирный шрифт(true)
        HSSFCellStyle style1 = workbook.createCellStyle();
        style1.setFont(font);                                 // установление шрифта в ячейку
        return style1;
    }

    private static HSSFCellStyle createStyleForTitle2(HSSFWorkbook workbook) {          // создание стиля для таблицы кроме её заголовка
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setBorderBottom(BorderStyle.THIN);              //устанавливаем границу прорисовки ячейки setBorderBottom(BorderStyle.THIN); - Нижняя граница
        style2.setBorderTop(BorderStyle.THIN);                //устанавливаем границу прорисовки ячейки setBorderTop(BorderStyle.THIN); - Верхняя граница
        style2.setBorderRight(BorderStyle.THIN);              //устанавливаем границу прорисовки ячейки setBorderRight(BorderStyle.THIN); - Правая граница
        style2.setBorderLeft(BorderStyle.THIN);               //устанавливаем границу прорисовки ячейки setBorderLeft(BorderStyle.THIN); - Левая граница
        return style2;
    }

    public static void createExcel() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();    //создаем книгу
        HSSFSheet sheet = workbook.createSheet("Reestr benzin");    //создаем страницу в книге с именем "Reestr benzin"

        Row row;             // Row - строка, обьявляем строку с именем row
        Cell cell;           // Cell - ячейка, обьявляем ячейку с именем cell

        HSSFCellStyle style = createStyleForTitle(workbook);
        HSSFCellStyle style1 = createStyleForTitle1(workbook);
        HSSFCellStyle style2 = createStyleForTitle2(workbook);

        row = sheet.createRow(0);              // row - строка, rownum - порядковый номер строки как в массиве
        cell = row.createCell(7, CellType.STRING);  // i - столбец в строке - row с порядковым номером - rownum
        cell.setCellValue("       \"Затверджую \"");
        cell.setCellStyle(style1);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 9));    //обьединение ячеек
//         Параметр 1: номер начальной строки Параметр 2: номер конечной начального ст

        row = sheet.createRow(1);              // row - строка, rownum - порядковый номер строки как в массиве
        cell = row.createCell(7, CellType.STRING);  // i - столбец в строке - row с порядковым номером - rownum
        cell.setCellValue("Начальник відділу");
        cell.setCellStyle(style1);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 7, 9));    //обьединение ячеек
//         Параметр 1: номер начальной строки Параметр 2: номер конечной начального ст

        row = sheet.createRow(2);
        cell = row.createCell(7, CellType.STRING);
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 7, 9));
        cell.setCellValue("       _________  ПІБ");
        cell.setCellStyle(style1);

        row = sheet.createRow(5);
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("РЕЕСТР");
        cell.setCellStyle(style1);

        int rownum = 7;      // простой счетчик, обьявляем и инициализируем его, отвечает за позицию строки где начинается шапка таблицы

        row = sheet.createRow(rownum);
        row.setHeight((short) 1300);  // установка высоты строки под номером кот. в переменной- rownum (= 7), значение (short) 1300 - высота строки

        // ячейка 0
        cell = row.createCell(0, CellType.STRING);           //  можно использовать укороченную запись - row.createCell(0).setCellValue("№ з/п")
        cell.setCellValue("№ з/п");
        cell.setCellStyle(style);
        sheet.setColumnWidth(0, 1050);     // установка ширины ячейки, 0 - позиция ячейки в строке, 1500 - ширина ячейки
        // ячейка 1
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Дата");
        cell.setCellStyle(style);
        sheet.setColumnWidth(1, 2550);
        // ячейка 2
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Показання спідометра при виїзді (км.)");
        cell.setCellStyle(style);
        sheet.setColumnWidth(2, 2850);
        // ячейка 3
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Показання спідометра при поверненні (км.)");
        cell.setCellStyle(style);
        sheet.setColumnWidth(3, 2850);
        // ячейка 4
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Пробіг (км.)");
        cell.setCellStyle(style);
        sheet.setColumnWidth(4, 1800);
        // ячейка 5
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Залишок при виїзді з гаражу (л.)");
        cell.setCellStyle(style);
        sheet.setColumnWidth(5, 2250);
        // ячейка 6
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Видано (л.)");
        cell.setCellStyle(style);
        sheet.setColumnWidth(6, 2100);
        // ячейка 7
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Витрати пального (л.)");
        cell.setCellStyle(style);
        sheet.setColumnWidth(7, 2100);
        // ячейка 8
        cell = row.createCell(8, CellType.STRING);

        cell.setCellValue("Залишок при поверненні в гараж (л.)");
        cell.setCellStyle(style);
        sheet.setColumnWidth(8, 2700);

        // ячейка 9
        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("Примітки");
        cell.setCellStyle(style);
        sheet.setColumnWidth(8, 2400);

        int beginnum = rownum;                  //   запоминаем в переменную beginnum положение строки rownum в которой напечатали шапку таблицы


        for (Petrol p : petrols) {
            rownum++;
            row = sheet.createRow(rownum);

            // ячейка 0 - A
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(rownum - beginnum);
            cell.setCellStyle(style2);

            // ячейка 1 - B
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(p.getData());          //   если использовать индекс ArrayList то команда получить эти данные такая: Storage.petrols.get(i).getData()
            cell.setCellStyle(style2);
            // ячейка 2 - C
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(p.getSpeedometerExit());
            cell.setCellStyle(style2);
            // ячейка 3 - D
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(p.getSpeedometerEntry());
            cell.setCellStyle(style2);
            // ячейка 4 - E
            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(p.getDictance());
            cell.setCellStyle(style2);
            // ячейка 5 - F
            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue(p.getRemainingFuelExit());
            cell.setCellStyle(style2);
            // ячейка 6 - G
            cell = row.createCell(6, CellType.STRING);
            if (p.getIssuedFuel() == 0) {
                cell.setCellValue("");
            } else {
                cell.setCellValue(p.getIssuedFuel());
            }
            cell.setCellStyle(style2);
            // ячейка 7 - H
            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(p.getFuelUsed());
            cell.setCellStyle(style2);
            // ячейка 8 - I
            cell = row.createCell(8, CellType.NUMERIC);
            cell.setCellValue(p.getRemainingFuelEntry());
            cell.setCellStyle(style2);
            sheet.setColumnWidth(8, 2700);
            // ячейка 9 - J
//            String formula = "E:" + rownum + "*H:" + rownum;
//            cell = row.createCell(9, CellType.FORMULA);
//            cell.setCellValue(formula);
            // ячейка 9 - J
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("по району");
            cell.setCellStyle(style2);
        }
        row = sheet.createRow(++rownum);
        String formula = "SUM(E" + (beginnum + 1) + ":E" + rownum + ")";     // создаем переменную с записаной формулой
        cell = row.createCell(4, CellType.FORMULA);         // создаем ячейку куда вставим формулу
        cell.setCellFormula(formula);                            // вставляем в ячейку формулу

        String formula0 = "SUM(G" + (beginnum + 1) + ":G" + rownum + ")";     // создаем переменную с записаной формулой
        cell = row.createCell(6, CellType.FORMULA);         // создаем ячейку куда вставим формулу
        cell.setCellFormula(formula0);                            // вставляем в ячейку формулу

        String formula1 = "SUM(H" + (beginnum + 1) + ":H" + rownum + ")";
        cell = row.createCell(7, CellType.FORMULA);      // укороченная версия кода - row.createCell(7).setCellFormula(formula1);
        cell.setCellFormula(formula1);

        rownum = rownum + 3;
        row = sheet.createRow(rownum);              // создаем строку ниже последней на 3
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Спеціаліст відділу");
        cell.setCellStyle(style1);
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 3));    //обьединение ячеек


        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("ПІБ");
        cell.setCellStyle(style1);
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 7, 9));    //обьединение ячеек
//         Параметр 1: номер начальной строки Параметр 2: номер конечной начального ст


        File file = new File("C:/demo/benzin.xls");
        file.getParentFile().mkdirs();                       // создаем каталог файлу

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("\u001B[1;32m" + "Был создан Excel файл: " + file.getAbsolutePath() + "\u001B[0m");


    }
}
