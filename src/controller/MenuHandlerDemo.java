package controller;

import db.Storage;

public class MenuHandlerDemo {
    public static void mileageDemo() {
        if (Storage.petrols.size() == 0) {
            System.out.println("Список данных пуст");
        } else {
            for (int i = 0; i < Storage.petrols.size(); i++) {
                System.out.print("№ п/п: " + i + ", спидометр выезд: " + Storage.petrols.get(i).getSpeedometerExit() + " км., спидометр возврат: ");
                System.out.print(Storage.petrols.get(i).getSpeedometerEntry() + " км., пробег: " + Storage.petrols.get(i).getDictance() + " км., бензин остаток начало: ");
                System.out.println(Storage.petrols.get(i).getRemainingFuelExit() + " л., бензина расход: " + Storage.petrols.get(i).getFuelUsed() + " л., бензин остаток конец: " + Storage.petrols.get(i).getRemainingFuelEntry() + " л.");
            }
        }
    }
}
