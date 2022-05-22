package controller;

import db.Storage;

import java.util.Scanner;

public class MenuHandlerDeleteIndex {
    public static void mileageDeleteIndex() {
        Scanner scannerDelet = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите номер записи для удаления № п/п :");
                if (scannerDelet.hasNextInt()) {
                    int i = scannerDelet.nextInt();
                    System.out.println("\u001B[1;31m" + "Запись :");
                    System.out.print(i + ", спидометр выезд: " + Storage.petrols.get(i).getSpeedometerExit() + " км., спидометр возврат: ");
                    System.out.print(Storage.petrols.get(i).getSpeedometerEntry() + " км., пробег: " + Storage.petrols.get(i).getDictance() + " км., бензин остаток начало: ");
                    System.out.println(Storage.petrols.get(i).getRemainingFuelExit() + " л., бензина расход: " + Storage.petrols.get(i).getFuelUsed() + " л., бензин остаток конец: " + Storage.petrols.get(i).getRemainingFuelEntry() + " л.");
                    System.out.println("Была удалена" + "\u001B[0m");
                    Storage.petrols.remove(i);
                    break;
                } else {
                    System.out.println("Номер введен неправильно, пожайлуста повторите");
                    scannerDelet.nextLine();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\u001B[1;31m" + "Такого номера №п/п: нет" + "\u001B[0m");
            } finally {
                if (Storage.petrols.size() == 0) {
                    System.out.println("Список данных пуст");
                    break;
                }
            }
        }

    }
}
