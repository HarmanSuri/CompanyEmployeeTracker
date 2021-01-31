/*  Class CommissionWorker
    Author: Harman Suri
    Oct 8, 2020
    Description:    Inherits from Employee, so it is an Employee.
                    but creates a CommissionWorker.
                    Contains first name, last name, employee ID, commission rate,
                    commission, sales, and salary. It contains methods to access
                    this data, as well as methods to change this data.
    Data:           commRate, commission, sales, salary
    Methods:        setCommissionRate (double commRate) - sets commRate
                    setSales (double sales)             - sets sales
                    calculateCommission ()              - calculates the salary with the hours and hourlyRate
                    setSalary (double salary)           - sets salary
                    getCommissionRate ()                - returns commRate
                    getCommission ()                    - returns commission
                    getSales ()                         - returns sales
                    getSalary ()                        - returns salary
                    toString ()                         - returns string representation of CommissionWorker, with any data from Employee
                    main (String[] args)                - self testing main
 */

public class CommissionWorker extends Employee{

    private double commRate;
    private double commission;
    private double sales;
    private double salary;

    /*
        default constructor that takes in nothing and set default values for every variable.
    */
    public CommissionWorker () {
        super ();
        commRate = -1;
        commission = -1;
        sales = -1;
        salary = -1;
    }

    /*
        a constructor that takes in and sets fName, lName, empID, commRate, sales, and salary.
    */
     public CommissionWorker (String fName, String lName, String empID, double commRate, double sales, double salary) {
        super(fName, lName, empID);
        setCommissionRate(commRate);
        setSales(sales);
        setSalary(salary);
        calculateCommission();
     }

     /*
        setCommissionRate takes in a number to change commRate in this class
    */
    public void setCommissionRate(double commRate) {
        // if commRate is negative, commRate is 0
        if (commRate < 0) {
            this.commRate = 0;
        }
        else {
            this.commRate = commRate;
        }
        // calls calculateCommission to update the commission once commRate is changed
        calculateCommission();
    }

    /*
        setSales takes in a number to change sales in this class
    */
    public void setSales (double sales) {
        // if sales is negative, sales is 0
        if (sales < 0) {
            this.sales = 0;
        }
        else {
            this.sales = sales;
        }
        // calls calculateCommission to update the commission once sales is changed
        calculateCommission();
    }

    /*
        calculateCommission uses sales and commRate to calculate the amount of money made from commission
    */
    public void calculateCommission () {
        // calculates the commission
        // if commRate or sales is negative (default constructor sets numerical values as -1) commission is set to -1
        if (commRate < 0 || sales < 0) {
            commission = -1;
        }
        else {
            commission = sales * commRate;
        }
    }

    /*
        setSalary takes in a number to change salary in this class
    */
    @Override
    public void setSalary(double salary) {
        // if salary is negative, salary is 0
        if (salary < 0) {
            this.salary = 0;
        }
        else {
            this.salary = salary;
        }
    }

    /*
        getCommissionRate returns commRate.
    */
    public double getCommissionRate () {
        return commRate;
    }

    /*
        getCommission returns commission.
    */
    public double getCommission() {
        return commission;
    }

    /*
        getSales returns sales.
    */
    public double getSales() {
        return sales;
    }

    /*
        getSalary returns salary.
    */
    @Override
    public double getSalary() {
        return salary;
    }

    /*
        earnings returns a sum of the salary and commission.
    */
    public double earnings() {
        // if salary or commission is negative (default constructor sets numerical values as -1) -1 is returned
        if (salary < 0 || commission < 0) {
            return -1;
        }
        else {
            return commission + salary;
        }
    }

    /*
        toString returns a string of all the variable values associated with an CommissionWorker
     */
    @Override
    public String toString() {
        return "CommissionWorker: " + commRate + ", " + commission + ", " + sales + ", " + salary + ", " + super.toString();
    }

    public static void main(String[] args) {
        // creating 2 CommissionWorker each with different constructors
        CommissionWorker worker1 = new CommissionWorker("Louis", "H", "P0796317", .5, 20500, 950000);
        CommissionWorker worker2 = new CommissionWorker();

        // test all getters on worker1
        System.out.println("first name: " + worker1.getFirstName());
        System.out.println("last name: " + worker1.getLastName());
        System.out.println("employee ID: " + worker1.getID());
        System.out.println("commission rate: " + worker1.getCommissionRate());
        System.out.println("commission: " + worker1.getCommission());
        System.out.println("sales: " + worker1.getSales());
        System.out.println("salary: " + worker1.getSalary());
        System.out.println("earnings: " + worker1.earnings());
        System.out.println(worker1.toString());
        System.out.println();

        // test all setters on worker2
        System.out.println(worker2.toString());
        worker2.setFirstName("Marvin");
        worker2.setLastName("Wilson");
        worker2.setID("P0671697");
        worker2.setCommissionRate(.15);
        worker2.setSales(864475);
        worker2.setSalary(501000);
        worker2.calculateCommission();
        System.out.println("earnings: " + worker2.earnings());
        System.out.println(worker2.toString());
        System.out.println();

        // testing incorrect input
        worker1.setCommissionRate(-.42);
        worker1.setSales(-5278);
        worker1.setSalary(-4277425);
        worker1.calculateCommission();
        System.out.println(worker1.toString());
    }
}
