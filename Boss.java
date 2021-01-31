/* 	Class Boss
    Author: T. Campos
	August, 2005. Updated Sept. 2007. New update Oct 8, 2020 by Harman Suri
	Description: Inherits from Employee, so it is an Employee.
				 but creates a Boss.
				 Contains first name, last name, salary andbonus. It
				 contains methods to access the data.
	Data: 		 salary, bonus
	Methods:	 setSalary(double salary)  - sets salary
				 getSalary() - returns salary
				 getEarnings() - gets employee total getEarnings
				 setBonus(double bonus) - sets bonus
				 getBonus() 	- returns bonus
				 toString()  - returns string representation of Employee
*/

public class Boss extends Employee
{

    private double bonus; // class data for bonus and annual salary
    private double salary;

    /*
        default constructor that takes in nothing and set default values for every variable.
        Added by Harman.
     */
    public Boss () {
        super ();
        bonus = -1;
        salary = -1;
    }

    public Boss(String FName, String LName, String ID, double salary, double bonus)
    //meaningful constructor. Sets name, bonus and salary
    {
        super (FName, LName, ID);
        setBonus(bonus);
        setSalary(salary);
    }

    public void setSalary(double salary)
    {
        // sets salary. If negative is provided
        // salary is 0
        if (salary < 0)
        {
            this.salary = 0;
        }
        else
        {
            this.salary = salary;
        }
    }

    public double getSalary()
    // gets salary
    {
        return salary;
    }

    public double getEarnings()
    // calculates and returns earnings
    {
        // if salary or bonus is negative (default constructor sets numerical values as -1) -1 is returned
        // added by Harman
        if (salary < 0 || bonus < 0) {
            return -1;
        }
        else {
            return this.getSalary() + bonus;
        }
    }

    public void setBonus( double bonus)
    // sets bonus. If negative is provided
    // bonus is 0
    {
        if (bonus < 0)
            this.bonus = 0;
        else
            this.bonus = bonus;
    }

    public double getBonus()
    //gets bonus
    {
        return bonus;
    }

    public String toString()
    // string representation of Boss
    {
        return "Boss " + super.toString();
    }

    public static void main (String[] args) //self testing main
    {
        // create boss employee
        Boss emp = new Boss ("Sally", "Fields","P0022222", 150000, 2000);
        System.out.println(emp.toString());
        System.out.println("Salary: "+  emp.getSalary());
        System.out.println("Bonus: "+  emp.getBonus());
        System.out.println("Earnings: "+  emp.getEarnings());
        //change employee information and display again
        emp.setFirstName("Joe");
        emp.setLastName("Shmoe");
        emp.setID("p000665");
        emp.setSalary(100000);
        emp.setBonus(3500);
        //Display again
        System.out.println(emp.toString());
        System.out.println("Salary: "+  emp.getSalary());
        System.out.println("Bonus: "+  emp.getBonus());
        System.out.println("Earnings: "+  emp.getEarnings());
        // test for incorrect input
        emp.setSalary(-100000);
        emp.setBonus(-3500);
        System.out.println("Earnings: "+ emp.getEarnings());
    }
}