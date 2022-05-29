package controller.readFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadPokazaniya {
    public static String readSpeedometer() throws FileNotFoundException {

        File fili2 = new File("pokazanija");    // создали обьект fili2 класса File с путем в корневом каталоге программы "pokazanija"
        Scanner scanFile2 = new Scanner(fili2);          // создали обект scanFile2 класса Scanner для чтения из файла fili2
        String pokazanijaReadSpeedometer = scanFile2.nextLine(); // считали строку с показаниями спидометра
        scanFile2.close();
        return pokazanijaReadSpeedometer;
    }
}
