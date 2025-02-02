package clase;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Asigurare {
    public static void main(String[] args) throws IOException {
        ArrayList<CarInsurance> carInsurances = new ArrayList<>();
        ArrayList<Double> insurancePrices = new ArrayList<>();

        // Citim fisierul carsDatabase
        BufferedReader reader = new BufferedReader(new FileReader("carsDatabase.txt"));
        String line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] attributes = line.split(",");
            CarInsurance carInsurance = new CarInsurance(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], Integer.parseInt(attributes[5]), attributes[6]);
            carInsurances.add(carInsurance);
        }
        reader.close();

        // Calculam asigurarea
        for (CarInsurance carInsurance : carInsurances) {
            double insurance = 100;
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int carAge = Calendar.getInstance().get(Calendar.YEAR) - carInsurance.fabricatie;

            // Luam in calcul varsta masinii
            if (carAge > 10) {
                insurance *= 0.9;
            } else {
                insurance *= 1.1;
            }

            // Luam in calcul norma de poluare
            if (carInsurance.poluare.equals("Euro 6")) {
                insurance *= 0.9;
            } else if (carInsurance.poluare.equals("Euro 5")) {
                insurance *= 1.0;
            } else if (carInsurance.poluare.equals("Euro 4")) {
                insurance *= 1.1;
            } else if (carInsurance.poluare.equals("Euro 3")) {
                insurance *= 1.2;
            } else if (carInsurance.poluare.equals("Euro 2")) {
                insurance *= 1.3;
            } else if (carInsurance.poluare.equals("Euro 1")) {
                insurance *= 1.4;
            } else if (carInsurance.poluare.equals("Non Euro")) {
                insurance *= 0.5;
            }

            // Luam in calcul tipul de combustibil
            if (carInsurance.combustibil.equals("Motorina")) {
                insurance *= 1.3;
            } else if (carInsurance.combustibil.equals("Benzina")) {
                insurance *= 1.2;
            } else if (carInsurance.combustibil.equals("Electric")) {
                insurance *= 1.0;
            } else if (carInsurance.combustibil.equals("Hibrid")) {
                insurance *= 1.1;
            }

            insurancePrices.add(insurance);
        }

        // Scriem intr-un fisier pretul asigurarii impreuna cu detaliile masniii

        BufferedWriter writer = new BufferedWriter(new FileWriter("insurancePrices.txt"));
        for (int i = 0; i < carInsurances.size(); i++) {
            CarInsurance carInsurance = carInsurances.get(i);
            double price = insurancePrices.get(i);
            writer.write(carInsurance.toString() + "," + price);
            writer.newLine();

        }
        writer.close();


    }
}

class CarInsurance {
    String name, marca, model, tip, poluare, combustibil;
    int fabricatie;

    public CarInsurance(String name, String marca, String model, String tip, String poluare, int fabricatie, String combustibil) {
        this.name = name;
        this.marca = marca;
        this.model = model;
        this.tip = tip;
        this.poluare = poluare;
        this.fabricatie = fabricatie;
        this.combustibil = combustibil;
    }

    @Override
    public String toString() {
        return name + "," + marca + "," + model + "," + tip + "," + poluare + "," + fabricatie + "," + combustibil;
    }
}

