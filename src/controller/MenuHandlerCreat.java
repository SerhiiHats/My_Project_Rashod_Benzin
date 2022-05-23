package controller;

import db.Storage;
import models.Petrol;

import java.util.Scanner;

public class MenuHandlerCreat {
    public static void mileage() {
        int speedometerExitBuffer = 91509;
        double remainingFuelExitBuffer = 153.99;
        double standardFuelConsumptionBuffer = 9.46;
        int dictanceBuffer = 1;
        Scanner scanMileage = new Scanner(System.in);

        while (dictanceBuffer != 0) {

            Petrol objpetrol = new Petrol();
            System.out.print("Введите пробег за день в км.: ");
            dictanceBuffer = scanMileage.nextInt();
            if (dictanceBuffer != 0) {
                objpetrol.setDictance(dictanceBuffer);
                objpetrol.setSpeedometerExit(speedometerExitBuffer);
                objpetrol.setRemainingFuelExit(remainingFuelExitBuffer);
                objpetrol.setStandardFuelConsumption(standardFuelConsumptionBuffer);
                objpetrol.setFuelUsed(Math.round(objpetrol.getStandardFuelConsumption() * objpetrol.getDictance()) / (double) 100);  // Метод округления: double roundOff = Math.round(a * 100.0) / (double)100.0; O utput is: 123.14
                System.out.println("расход бензина: " + objpetrol.getFuelUsed() + " л.");
                objpetrol.setSpeedometerEntry(objpetrol.getSpeedometerExit() + objpetrol.getDictance());
                objpetrol.setRemainingFuelEntry(Math.round((objpetrol.getRemainingFuelExit() - objpetrol.getFuelUsed()) * 100) / (double) 100);   // Метод округления: double roundOff = Math.round(a * 100.0) / (double)100.0; O utput is: 123.14

                System.out.println("спидометр выезд: " + objpetrol.getSpeedometerExit() + " км., спидометр возврат: " + objpetrol.getSpeedometerEntry() + " км., пробег: " + objpetrol.getDictance() + " км., бензин остаток начало: " + objpetrol.getRemainingFuelExit() + " л., бензина расход: " + objpetrol.getFuelUsed() + " л., бензин остаток конец: " + objpetrol.getRemainingFuelEntry() + " л.");
                Storage.petrols.add(objpetrol);

                speedometerExitBuffer = objpetrol.getSpeedometerEntry();
                remainingFuelExitBuffer = objpetrol.getRemainingFuelEntry();
            }
        }
//        scanMileage.nextLine();
//        scanMileage.close();
    }
}
