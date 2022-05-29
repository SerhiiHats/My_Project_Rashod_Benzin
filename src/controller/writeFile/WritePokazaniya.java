package controller.writeFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WritePokazaniya {
    public static void writeSpeedometer(int speedometerExitBuffer, double remainingFuelExitBuffer, double standardFuelConsumptionBuffer) throws FileNotFoundException {
        String pokazanijaDlaZapisiFile = speedometerExitBuffer + " " + remainingFuelExitBuffer + " " + standardFuelConsumptionBuffer;
        File file1 = new File("pokazanija");      // создали обьект класса File с путем в корневом каталоге программы "pokazanija"
        PrintWriter pwFile1 = new PrintWriter(file1);  // создали обьект класса PrintWriter для записи созданого обьекта файла - file1
        pwFile1.print(pokazanijaDlaZapisiFile);
        pwFile1.close();
    }
}
