package controller;

import controller.readFile.ReadPokazaniya;
import controller.writeFile.WritePokazaniya;
import db.Storage;
import models.Petrol;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuHandlerCreat {
    public static void mileage() {
        int speedometerExitBuffer = 0;
        double remainingFuelExitBuffer = 0;
        double standardFuelConsumptionBuffer = 0;
        int zapravka = 0;
        boolean keyOutZapravka = true;
        Scanner scanZapravka = new Scanner(System.in);
        while (keyOutZapravka) {
            try {
                String polychStrokaPokazaniy = ReadPokazaniya.readSpeedometer();     // метод для чтения файла с показаниями
                String[] stringsPokazanija = polychStrokaPokazaniy.split(" ");  // показания полученые в String разделяем на массив для извлечения соответствующих показаний
                speedometerExitBuffer = Integer.parseInt(stringsPokazanija[0]);       // записываем показания из массива
                remainingFuelExitBuffer = Double.parseDouble(stringsPokazanija[1]);
                standardFuelConsumptionBuffer = Double.parseDouble(stringsPokazanija[2]);
            } catch (Exception e) {
                System.out.println("Файл с показаниями спидометра не был считан, возможно он открыт");
            }
            System.out.println("Останні данні");
            System.out.println("Показання спідометра       : " + speedometerExitBuffer + " км.");
            if (zapravka == 0) {
                System.out.println("Залишок палива             : " + remainingFuelExitBuffer + " л.");
            } else {
                System.out.println("Залишок палива             : " + (remainingFuelExitBuffer + zapravka) + " л., з них заправлено: " + zapravka + " л., залишок на початок: " + remainingFuelExitBuffer + " л.");
            }
            System.out.println("Норма расходу на л/100 км. : " + standardFuelConsumptionBuffer + " л/100 км.");
            System.out.println("Скільки л. палива було заправлено? Віддіть дані, кількість заправлених л. / 0 - заправки не було");
            int zapravkaBuffer = scanZapravka.nextInt();
            if (zapravkaBuffer == 0) {
                keyOutZapravka = false;
            } else {
                zapravka = zapravkaBuffer;
            }


        }
        //scanZapravka.close();


        int dictanceBuffer = 1;
        Date dataNow = new Date();                                                // Создадим обект класса дата для определения текущего времени
        SimpleDateFormat formatData = new SimpleDateFormat("dd.MM.yyyy");  // сформатируем дату конструктором в формат dd.MM.yyyy
        String formatedDataNow = formatData.format(dataNow);                      // парсим дату в стринг для ее дальнейшего корректного отображения

        Scanner scanMileage = new Scanner(System.in);

        while (dictanceBuffer != 0) {

            Petrol objpetrol = new Petrol();
            System.out.print("Введите пробег за день в км.: ");
            dictanceBuffer = scanMileage.nextInt();
            if (dictanceBuffer != 0) {
                objpetrol.setData(formatedDataNow);
                objpetrol.setDictance(dictanceBuffer);
                objpetrol.setSpeedometerExit(speedometerExitBuffer);
                objpetrol.setRemainingFuelExit(remainingFuelExitBuffer);
                objpetrol.setStandardFuelConsumption(standardFuelConsumptionBuffer);
                objpetrol.setFuelUsed(Math.round(objpetrol.getStandardFuelConsumption() * objpetrol.getDictance()) / (double) 100);  // Метод округления: double roundOff = Math.round(a * 100.0) / (double)100.0; O utput is: 123.14
                System.out.println("расход бензина: " + objpetrol.getFuelUsed() + " л.");
                objpetrol.setSpeedometerEntry(objpetrol.getSpeedometerExit() + objpetrol.getDictance());
                objpetrol.setRemainingFuelEntry(Math.round((objpetrol.getRemainingFuelExit() - objpetrol.getFuelUsed() + zapravka) * 100) / (double) 100);   // Метод округления: double roundOff = Math.round(a * 100.0) / (double)100.0; O utput is: 123.14
                objpetrol.setIssuedFuel(zapravka);
                zapravka = 0;
                System.out.println("спидометр выезд: " + objpetrol.getSpeedometerExit() + " км., спидометр возврат: " + objpetrol.getSpeedometerEntry() + " км., пробег: " + objpetrol.getDictance() + " км., бензин остаток начало: " + objpetrol.getRemainingFuelExit() + " л., бензина расход: " + objpetrol.getFuelUsed() + " л., бензин остаток конец: " + objpetrol.getRemainingFuelEntry() + " л.");
                Storage.petrols.add(objpetrol);

                speedometerExitBuffer = objpetrol.getSpeedometerEntry();
                remainingFuelExitBuffer = objpetrol.getRemainingFuelEntry();
            }
        }
        try {
            WritePokazaniya.writeSpeedometer(speedometerExitBuffer, remainingFuelExitBuffer, standardFuelConsumptionBuffer);// метод для записи файла с показаниями
        } catch (Exception e) {
            System.out.println("Файл с конечнымми показаниями спидометра не был записан, возможно файл уже был открыт");
        }
        // String pokazanijaDlaZapisiFile = speedometerExitBuffer + " " + remainingFuelExitBuffer + " " + standardFuelConsumptionBuffer;
//        scanMileage.nextLine();
//        scanMileage.close();
    }
}
