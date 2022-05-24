package models;

public class Petrol {
    private String data;             // дата, текущая или устанавливаемая
    private int speedometerExit;            // показания спидометра при выезде, км
    private int speedometerEntry;                   // показания спидометра при возвращении на базу, км
    private int dictance;                           // пробег за день, растояние, км.
    private double remainingFuelExit;      // остаток топлива при выезде, л.
    private double issuedFuel;                      // выдано топлива, л.
    private double filledFuel;                      // заправлено топлива, л.
    private double remainingFuelEntry;              // остаток топлива при возвращении на базу, л.
    private double fuelUsed;                        // израсходовано топлива, л.
    private double standardFuelConsumption;  // нормативный расход топлива, л

    public Petrol(String data, int speedometerExit, int speedometerEntry, int dictance, double remainingFuelExit, double issuedFuel, double filledFuel, double remainingFuelEntry, double fuelUsed, double standardFuelConsumption) {
        this.data = data;
        this.speedometerExit = speedometerExit;
        this.speedometerEntry = speedometerEntry;
        this.dictance = dictance;
        this.remainingFuelExit = remainingFuelExit;
        this.issuedFuel = issuedFuel;
        this.filledFuel = filledFuel;
        this.remainingFuelEntry = remainingFuelEntry;
        this.fuelUsed = fuelUsed;
        this.standardFuelConsumption = standardFuelConsumption;
    }

    public Petrol() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getSpeedometerExit() {
        return speedometerExit;
    }

    public void setSpeedometerExit(int speedometerExit) {
        this.speedometerExit = speedometerExit;
    }

    public int getSpeedometerEntry() {
        return speedometerEntry;
    }

    public void setSpeedometerEntry(int speedometerEntry) {
        this.speedometerEntry = speedometerEntry;
    }

    public int getDictance() {
        return dictance;
    }

    public void setDictance(int dictance) {
        this.dictance = dictance;
    }

    public double getRemainingFuelExit() {
        return remainingFuelExit;
    }

    public void setRemainingFuelExit(double remainingFuelExit) {
        this.remainingFuelExit = remainingFuelExit;
    }

    public double getIssuedFuel() {
        return issuedFuel;
    }

    public void setIssuedFuel(double issuedFuel) {
        this.issuedFuel = issuedFuel;
    }

    public double getFilledFuel() {
        return filledFuel;
    }

    public void setFilledFuel(double filledFuel) {
        this.filledFuel = filledFuel;
    }

    public double getRemainingFuelEntry() {
        return remainingFuelEntry;
    }

    public void setRemainingFuelEntry(double remainingFuelEntry) {
        this.remainingFuelEntry = remainingFuelEntry;
    }

    public double getFuelUsed() {
        return fuelUsed;
    }

    public void setFuelUsed(double filledFuel) {
        this.fuelUsed = filledFuel;
    }

    public double getStandardFuelConsumption() {
        return standardFuelConsumption;
    }

    public void setStandardFuelConsumption(double standardFuelConsumption) {
        this.standardFuelConsumption = standardFuelConsumption;
    }

}
