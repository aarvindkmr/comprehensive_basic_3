package comprehensiveAssignment;

import java.util.Scanner;

public class IT_Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create variables
        double taxableIncome;
        double taxPaidPerYear;
        double taxPayablePerMonth;

        // Read TaxableIncome using Scanner
        System.out.print("Enter Taxable Income: $");
        taxableIncome = scanner.nextDouble();

        // Calculate taxPaidPerYear based on tax rate
        if (taxableIncome <= 25000) {
            taxPaidPerYear = 0;
        } else if (taxableIncome <= 50000) {
            taxPaidPerYear = taxableIncome * 0.10;
        } else if (taxableIncome <= 75000) {
            taxPaidPerYear = taxableIncome * 0.20;
        } else {
            taxPaidPerYear = taxableIncome * 0.30;
        }

        // Calculate taxPayablePerMonth
        taxPayablePerMonth = taxPaidPerYear / 12;

        // Print results
        System.out.println("Tax Paid Per Year: $" + taxPaidPerYear);
        System.out.println("Tax Payable Per Month: $" + taxPayablePerMonth);

        // Close the scanner
        scanner.close();
    }
}
