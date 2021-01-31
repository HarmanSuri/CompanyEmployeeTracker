/*  Class HourlyWorker
    Author: Harman Suri
    Oct 8, 2020
    Description:    Inherits from Employee, so it is an Employee.
                    but creates an HourlyWorker.
                    Contains first name, last name, employee ID, hours,
                    hourly rate, and salary. It contains methods to access
                    this data, as well as methods to change this data.
    Data:           hours, hourlyRate, salary
    Methods:        setHours (double hours)             - sets hours
                    setHourlyRate (double hourlyRate)   - sets hourlyRate
                    calculateSalary ()                  - calculates the salary with the hours and hourlyRate
                    getHours ()                         - returns hours
                    getHourlyRate ()                    - returns hourlyRate
                    getSalary ()                        - returns salary
                    toString ()                         - returns string representation of HourlyWorker, with any data from Employee
                    main (String[] args)                - self testing main
 */

public class HourlyWorker extends Employee{

    private double hours;
    private double hourlyRate;
    private double salary;

    /*
        default constructor that takes in nothing and set default values for every variable.
     */
    public HourlyWorker () {
        super ();
        hours = -1;
        hourlyRate = -1;
        salary = -1;
    }

    /*
        a constructor that takes in and sets fName, lName, empID, hours, and hourlyRate.
     */
    public HourlyWorker (String fName, String lName, String empID, double hours, double hourlyRate) {
        super (fName, lName, empID);
        setHours(hours);
        setHourlyRate(hourlyRate);
        calculateSalary();
    }

    /*
        setHours takes in a number of hours and changes the value in this class.
     */
    public void setHours(double hours) {
        // if hours is negative, hours is 0
        if (hours < 0) {
            this.hours = 0;
        }
        else {
            this.hours = hours;
        }
        // calls calculateSalary to update the salary once hours is changed
        calculateSalary();
    }

    /*
        setHourlyRate takes in an hourlyRate and changes the value in this class.
     */
    public void setHourlyRate (double hourlyRate) {
        // if hourlyRate is negative, hourlyRate is 0
        if (hourlyRate < 0) {
            this.hourlyRate = 0;
        }
        else {
            this.hourlyRate = hourlyRate;
        }
        // calls calculateSalary to update the salary once hourlyRate is changed
        calculateSalary();
    }

    public void calculateSalary() {
        // calculates the salary
        // if hours or hourlyRate is negative (default constructor sets numerical values as -1) salary is set to -1
        if (hours < 0 || hourlyRate < 0) {
            salary = -1;
        }
        else if (hours > 40) {
            salary = 40 * hourlyRate;
        }
        else {
            salary = hours * hourlyRate;
        }
    }

    /*
        getHours returns hours.
    */
    public double getHours() {
        return hours;
    }

    /*
        getHourlyRate returns hourlyRate.
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /*
        getSalary returns salary.
     */
    @Override
    public double getSalary() {
        return salary;
    }

    /*
        earnings returns a sum of the total pay for every hour, plus any overtime pay.
    */
    public double earnings() {
        double earnings;
        double overtime;
        double overtimeRate = hourlyRate * 1.5;

        // if hours, hourlyRate, or salary is negative (default numerical values are -1) earnings is -1
        if (hours < 0 || hourlyRate < 0 || salary < 0) {
            earnings = -1;
        }
        else if (hours > 40) {
            overtime = (hours - 40) * overtimeRate;
            earnings = overtime + salary;
        }
        else {
            earnings = salary;
        }

        return earnings;
    }

    /*
        toString returns a string of all the variable values associated with an HourlyWorker
     */
    @Override
    public String toString () {
        return "HourlyWorker: " + hours + ", " + hourlyRate + ", " + salary + ", " + super.toString();
    }

    public static void main(String[] args) {
        // creating 2 hourly workers each with different constructor
        HourlyWorker worker1 = new HourlyWorker("Adam", "G", "P0489951", 30, 15.00);
        HourlyWorker worker2 = new HourlyWorker();

        // testing all getters on worker1
        System.out.println("first name: " + worker1.getFirstName());
        System.out.println("last name: " + worker1.getLastName());
        System.out.println("employee ID: " + worker1.getID());
        System.out.println("hours: " + worker1.getHours());
        System.out.println("hourly rate: " + worker1.getHourlyRate());
        System.out.println("salary: " + worker1.getSalary());
        System.out.println("earnings: " + worker1.earnings());
        System.out.println(worker1.toString());
        System.out.println();

        // testing all setters on worker2
        System.out.println(worker2.toString());
        worker2.setFirstName("Erica");
        worker2.setLastName("Erikson");
        worker2.setID("P0626585");
        worker2.setHours(55);
        worker2.setHourlyRate(13.15);
        worker2.calculateSalary();
        System.out.println("earnings: " + worker2.earnings());
        System.out.println(worker2.toString());
        System.out.println();

        // testing incorrect input
        worker1.setHours(-2443);
        worker1.setHourlyRate(-2323);
        worker1.calculateSalary();
        System.out.println(worker1.toString());

    }
}
