package interfata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class PretAsigurare {
    private static final int MONTHS_6 = 6;
    private static final int MONTHS_12 = 12;
    private static final double DISCOUNT_5_PERCENT = 0.05;
    private static final double DISCOUNT_10_PERCENT = 0.10;

    public static void main(String[] args) {
        String fileName = "insurancePrices.txt";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                double price = Double.parseDouble(parts[6]);
                double price6Months = price * MONTHS_6;
                double price6MonthsDiscount = price6Months * (1 - DISCOUNT_5_PERCENT);
                double price12Months = price * MONTHS_12;
                double price12MonthsDiscount = price12Months * (1 - DISCOUNT_10_PERCENT);
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println("Price for 6 months: " + df.format(price6Months) + " with a discount of " + DISCOUNT_5_PERCENT * 100 + "%: " + df.format(price6MonthsDiscount));
                System.out.println("Price for 12 months: " + df.format(price12Months) + " with a discount of " + DISCOUNT_10_PERCENT * 100 + "%: " + df.format(price12MonthsDiscount));
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
