/*  Class Company
    Author: Harman Suri
    Oct 8, 2020
    Description:    Has a Boss, HourlyWorker, and CommissionWorker. Has methods
                    to ask the user for the various data in each of the
                    Employee style objects. Can also set default data for each
                    object
    Methods:        main (String[] args)                                                                - runs basic commands to prompt the user for input and use that input,
                                                                                                          uses the other class methods
                    enterBossInfo (Boss boss)                                                           - asks the user for the respective data for a Boss
                    enterHourlyWorkerInfo (HourlyWorker hourlyWorker)                                   - asks the user for the respective data for an HourlyWorker
                    enterCommissionWorkerInfo (CommissionWorker commissionWorker)                       - asks the user for the respective data for a CommissionWorker
                    displayBossInfo (Boss boss, NumberFormat money)                                     - displays the data of the given Boss
                    displayHourlyWorkerInfo (HourlyWorker hourlyWorker, NumberFormat money)             - displays the data of the given HourlyWorker
                    displayCommissionWorkerInfo (CommissionWorker commissionWorker, NumberFormat money) - displays the data of the given CommissionWorker
 */

import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Company {

    public static void main(String[] args) {
        // NumberFormat object to format numbers a currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // creating each object for the workers in a company
        Boss bigBoss = new Boss();
        HourlyWorker secretary = new HourlyWorker();
        CommissionWorker salesperson = new CommissionWorker();

        // variables to hold user input
        String ansStr;
        int ansNum;

        // asking the user if they want to enter their own info
        ansNum = JOptionPane.showConfirmDialog(null, "Would you like to input your own data for each of the workers (y/n)?");

        // if no
        if (ansNum == 1) {
            // sets test information for each object
            bigBoss = new Boss("Bill", "Jobs", "P0654918", 500000000, 1000000);
            secretary = new HourlyWorker("Jimmy", "Wright", "P0547163", 43, 20.00);
            salesperson = new CommissionWorker("Robert", "Smith", "P0868537", .25, 540000, 417000);
        }
        // if yes
        else if (ansNum == 0) {
            // a do loop that asks the user for which objects info they want to change
            do {
                // askes the user for which object they want to enter information for
                ansStr = JOptionPane.showInputDialog("Who would you like to enter information for?\n(B - Boss, H - Hourly Worker, C - Commission Worker)");
                // sets ansStr to upper case to avoid any issues with the below decision structure
                ansStr = ansStr.toUpperCase();

                // a switch case that takes in ansStr
                switch (ansStr) {
                    // if B is entered
                    case "B":
                        // enterBossInfo is called passing in bigBoss
                        enterBossInfo(bigBoss);
                        break;
                    // if H is entered
                    case "H":
                        // enterHourlyWorker is called passing in secretary
                        enterHourlyWorkerInfo(secretary);
                        break;
                    // if C is entered
                    case "C":
                        // enterCommissionWorkInfo is called passing in salesperson
                        enterCommissionWorkerInfo(salesperson);
                        break;
                    // if none of the above where entered
                    default:
                        // the user is told they entered an incorrect value
                        JOptionPane.showMessageDialog(null, "The character you entered wasn't B, H, or C.\nPlease enter a correct character for the program to work.");
                        break;
                }

                // the user is asked if they would like to continue adding information to other workers or changing old information
                ansNum = JOptionPane.showConfirmDialog(null, "Would you like to enter information for another worker or change old information?");

            } while (ansNum == 0); // loop continues when the user clicks yes (which is equal to 0) in the showConfirmDialog box
        }

        // the display methods for each of the objects is called passing in their respective objects and currency
        displayBossInfo(bigBoss, currency);
        displayHourlyWorkerInfo(secretary, currency);
        displayCommissionWorkerInfo(salesperson, currency);
    }

    public static void enterBossInfo(Boss boss) {
        // variables to hold user input
        String strValue;
        double numValue;

        // the below if statements ask the user for the respective date needed by a Boss object
        // to keep String values the same as before they can enter no, and to keep numerical values the same they can enter -1
        strValue = JOptionPane.showInputDialog("Enter the first name of your boss (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            boss.setFirstName(strValue);
        }

        strValue = JOptionPane.showInputDialog("Enter the last name of your boss (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            boss.setLastName(strValue);
        }

        strValue = JOptionPane.showInputDialog("Enter your boss's employee ID (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            boss.setID(strValue);
        }

        numValue = Double.parseDouble(JOptionPane.showInputDialog("Enter your boss's salary (to avoid changes enter '-1'): "));
        if (!(numValue == -1)) {
            boss.setSalary(numValue);
        }

        numValue = Double.parseDouble(JOptionPane.showInputDialog("Enter your boss's bonus (to avoid changes enter '-1'): "));
        if (!(numValue == -1)) {
            boss.setBonus(numValue);
        }
    }

    public static void enterHourlyWorkerInfo(HourlyWorker hourlyWorker) {
        // variables to hold user input
        String strValue;
        double numValue;

        // the below if statements ask the user for the respective date needed by an HourlyWorker object
        // to keep String values the same as before they can enter no, and to keep numerical values the same they can enter -1
        strValue = JOptionPane.showInputDialog("Enter the first name of your hourly worker (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            hourlyWorker.setFirstName(strValue);
        }

        strValue = JOptionPane.showInputDialog("Enter the last name of your hourly worker (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            hourlyWorker.setLastName(strValue);
        }

        strValue = JOptionPane.showInputDialog("Enter your hourly worker's employee ID (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            hourlyWorker.setID(strValue);
        }

        numValue = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount of hours your hourly worker worked (to avoid changes enter '-1'): "));
        if (!(numValue == -1)) {
            hourlyWorker.setHours(numValue);
        }

        numValue = Double.parseDouble(JOptionPane.showInputDialog("Enter your hourly worker's hourly pay (to avoid changes enter '-1'): "));
        if (!(numValue == -1)) {
            hourlyWorker.setHourlyRate(numValue);
        }
    }

    public static void enterCommissionWorkerInfo(CommissionWorker commissionWorker) {
        // variables to hold user input
        String strValue;
        double numValue;

        // the below if statements ask the user for the respective date needed by a CommissionWorker object
        // to keep String values the same as before they can enter no, and to keep numerical values the same they can enter -1
        strValue = JOptionPane.showInputDialog("Enter the first name of your commission worker (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            commissionWorker.setFirstName(strValue);
        }

        strValue = JOptionPane.showInputDialog("Enter the last name of your commission worker (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            commissionWorker.setLastName(strValue);
        }

        strValue = JOptionPane.showInputDialog("Enter your commission worker's employee ID (to avoid changes enter 'no'): ");
        if (!strValue.equalsIgnoreCase("no")) {
            commissionWorker.setID(strValue);
        }

        numValue = Double.parseDouble(JOptionPane.showInputDialog("Enter the commission rate of your commission worker as a decimal (15% - 0.15) (to avoid changes enter '-1'): "));
        if (!(numValue == -1)) {
            commissionWorker.setCommissionRate(numValue);
        }

        numValue = Double.parseDouble(JOptionPane.showInputDialog("Enter the dollar amount of your sales (to avoid changes enter '-1'): "));
        if (!(numValue == -1)) {
            commissionWorker.setSales(numValue);
        }

        numValue = Double.parseDouble(JOptionPane.showInputDialog("Enter your commission worker's salary (to avoid changes enter '-1'): "));
        if (!(numValue == -1)) {
            commissionWorker.setSalary(numValue);
        }
    }

    /*
        displayBossInfo takes in a Boss object and a NumberFormat object, and displays all of the variable values in the Boss object
     */
    public static void displayBossInfo (Boss boss, NumberFormat money) {
        // base string to hold the data that needs to be displayed
        String display = "Boss:\n";

        // gets all of the data from the boss object
        display += "First Name: " + boss.getFirstName() + "\n";
        display += "Last Name: " + boss.getLastName() + "\n";
        display += "Employee ID: " + boss.getID() + "\n";
        display += "Bonus: " + money.format(boss.getBonus()) + "\n";
        display += "Salary: " + money.format(boss.getSalary()) + "\n";
        display += "Earnings: " + money.format(boss.getEarnings()) + "\n";

        JOptionPane.showMessageDialog(null, display);
    }

    /*
        displayHourlyWorkerInfo takes in a HourlyWorker object and a NumberFormat object,
        and displays all of the variable values in the HourlyWorker object
     */
    public static void displayHourlyWorkerInfo (HourlyWorker hourlyWorker, NumberFormat money) {
        // base string to hold the data that needs to be displayed
        String display = "Hourly Worker:\n";

        // gets all of the data from the hourlyWorker object
        display += "First Name: " + hourlyWorker.getFirstName() + "\n";
        display += "Last Name: " + hourlyWorker.getLastName() + "\n";
        display += "Employee ID: " + hourlyWorker.getID() + "\n";
        display += "Hours: " + hourlyWorker.getHours() + "\n";
        display += "Hourly Rate: " + money.format(hourlyWorker.getHourlyRate()) + "\n";
        display += "Salary: " + money.format(hourlyWorker.getSalary()) + "\n";
        display += "Earnings: " + money.format(hourlyWorker.earnings()) + "\n";

        JOptionPane.showMessageDialog(null, display);
    }

    /*
        displayCommissionWorkerInfo takes in a CommissionWorker object and a NumberFormat object,
        and displays all of the variable values in the CommissionWorker object
     */
    public static void displayCommissionWorkerInfo (CommissionWorker commissionWorker, NumberFormat money) {
        // base string to hold the data that needs to be displayed
        String display = "Commission Worker:\n";

        // gets all of the data from the commissionWorker object
        display += "First Name: " + commissionWorker.getFirstName() + "\n";
        display += "Last Name: " + commissionWorker.getLastName() + "\n";
        display += "Employee ID: " + commissionWorker.getID() + "\n";
        display += "Commission Rate: " + commissionWorker.getCommissionRate() + "\n";
        display += "Sales: " + money.format(commissionWorker.getSales()) + "\n";
        display += "Salary: " + money.format(commissionWorker.getSalary()) + "\n";
        display += "Commission: " + money.format(commissionWorker.getCommission()) + "\n";
        display += "Earnings: " + money.format(commissionWorker.earnings()) + "\n";

        JOptionPane.showMessageDialog(null, display);
    }
}
