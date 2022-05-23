package controller;

import db.Storage;

import java.io.IOException;
import java.util.Scanner;

public class Handler {
    public static void hand() throws IOException {
        boolean keyout = true;
        Scanner scanner = new Scanner(System.in);
        while (keyout) {
            System.out.println("Выбирете номер и нажмите Enter:");
            System.out.println("\u001B[1;32m" + "1.ввести данные 2.показать все данные 3.показать по номеру (№п/п) 4.удалить по номеру (№п/п) 5.выгрузить в Excel 6.выход(или другой)" + "\u001B[0m");
            switch (scanner.next()) {
                case "1" : {
                    MenuHandlerCreat.mileage();
                    break;
                }
                case "2" : {
                    MenuHandlerDemo.mileageDemo();
                    break;
                }
                case "3" : {
                    MenuHandlerDemoIndex.mileageDemoIndex();
                    break;
                }
                case "4" : {
                    MenuHandlerDeleteIndex.mileageDeleteIndex();
                    break;
                }
                case "5" : {
                    MenuHandlerExcel.createExcel();

                    break;
                }
                default: {
                    keyout = false;
                }
            }
        }
        scanner.close();
    }
}
