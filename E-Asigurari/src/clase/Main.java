package clase;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import interfata.SelectiaMasinilor;


public class Main {
    public static void main(String[] args) {
        SelectiaMasinilor carSelectionUI = new SelectiaMasinilor();
        carSelectionUI.setVisible(true);
        ArrayList<CarInsurance> carInsuranceList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("carsDatabase.txt"));
            boolean isHeader = true;
            while (sc.hasNextLine()) {
                if (isHeader) {
                    sc.nextLine();
                    isHeader = false;
                } else {
                    String[] carDetails = sc.nextLine().split(",");
                    CarInsurance carInsurance = new CarInsurance(carDetails[0], carDetails[1], carDetails[2], carDetails[3], carDetails[4], Integer.parseInt(carDetails[5]), carDetails[6]);
                    carInsuranceList.add(carInsurance);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
