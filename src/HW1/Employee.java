package HW1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Employee extends Person{
    private double salary;
    private java.util.Calendar hireDate;
    private Department department;
    public static int numberOfEmployees;



    public Employee(int id, String firstname, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department) throws Exception{
        super(id, firstname, lastName, gender, birthDate, maritalStatus, hasDriverLicence) ;
        this.hireDate = hireDate;
        this.salary = salary;
        this.department = department;
        numberOfEmployees++;
    }
    public Employee (Person person, double salary, Calendar hireDate, Department department) throws Exception{
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.isHasDriverLicence()) ;
        this.hireDate = hireDate;
        this.salary = salary;
        this.department = department;
        numberOfEmployees++;
    }

    public double raiseSalary (double percent){
        this.salary += percent  * this.salary;
        return this.salary;
    }

    public double raiseSalary (int amount){
        this.salary += amount;
        return this.salary;
    }

    public String toString(){
        String strDate = getHireDateAsString();
        return "\t\t\t\t\t" + super.toString() + "\t\t\t\t\tEmployee Info [salary="+getSalary() + ", hireDate=" + strDate +"]\n";
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws Exception{
        if (salary < 1)
            throw new Exception("Value must be greater than zero.");
        this.salary = salary;
    }

    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) throws Exception{
        this.department = department;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public static void setNumberOfEmployees(int numberOfEmployees) throws Exception{
        if (numberOfEmployees <= 0)
            throw new Exception("Value must be greater than zero.");
        Employee.numberOfEmployees = numberOfEmployees;
    }

    private String getHireDateAsString(){
        Date date = getHireDate().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM//yyyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
