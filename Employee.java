/*  Class Employee
	Updated by P.Wray
	Sept 26th, 2013. Updated Oct 8, 2020 by Harman Suri
	Description: Class to create an employee object.
	             Contains first name, last name and ID. It
				 contains methods to access the data.
	Data: 		fName, lName, empID
	Methods:	String getFName() 	       - returns first name
				String getLName()	       - returns last name
				String getID()             - returns employee ID
				String toString()          - returns string representation of Employee
				setFirstName (String nm)   - sets first name
				setLastName (String nm)    - sets last name
				setEmpID (String ID)       - sets employee ID
*/

public class Employee
{
    private String lName, fName;  //private class data for names and id.
    private String empID;
    private double salary;

    /*
        default constructor that takes in nothing and set default values for every variable.
        Added by Harman.
     */
    public Employee () {
        lName = "NO LAST NAME";
        fName = "NO FIRST NAME";
        empID = "NO EMPLOYEE ID";
        salary = -1;
    }

    public Employee(String fName, String lName, String ID)//meaningful cosntructor
    {
        this.fName = fName;
        this.lName = lName;
        this.empID = ID;
    }

    public String getFirstName()
    //gets first name
    {
        return fName;
    }

    public String getLastName()
    //gets last name
    {
        return lName;
    }

    public String getID()
    //gets employee ID
    {
        return empID;
    }

    public void setFirstName(String fn)
    //sets first name
    {
        fName = fn;
    }

    public void setLastName(String ln)
    //sets last name
    {
        lName = ln;
    }

    public void setID(String ID)
    //sets employee ID
    {
        empID = ID;
    }

    public void setSalary(double sal)
    //gets salary
    {
        salary = sal;
    }

    public double getSalary()
    //gets salary
    {
        return salary;
    }
    public String toString()
    // returns a string representation of Employee
    {
        return "Employee: " + fName + ", " + lName + ", " + empID;
    }

    public static void main (String[] args) //self testing main method
    {
        // create employee object and test all methods
        Employee emp = new Employee ("John", "Smith", "P0444444");
        System.out.println(emp.toString());
        System.out.println(emp.getFirstName());
        System.out.println(emp.getLastName());
        System.out.println(emp.getID());
        // change employee information
        emp.setFirstName("Joanne");
        emp.setLastName("Johnson");
        emp.setID("P0123456");
        // display again
        System.out.println(emp.toString());
    }

}//Employee Class