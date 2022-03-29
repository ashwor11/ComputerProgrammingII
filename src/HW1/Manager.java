package HW1;

import java.util.ArrayList;
import java.util.Calendar;

public class Manager extends Employee{
    private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
    private double bonusBudget;


    public Manager(int id, String firstname, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) throws Exception{
        super(id, firstname, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
        this.bonusBudget = bonusBudget;
    }

    public Manager (Employee employee, double bonusBudget) throws Exception{
        super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.isHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
        this.bonusBudget = bonusBudget;

    }
    
    public void addEmployee(RegularEmployee e){
        regularEmployees.add(e);
    }
    
    public void removeEmployee(RegularEmployee e){
        regularEmployees.remove(e);
    }
    
    public void distributeBonusBudget() throws Exception{
        double unit = 0;
        for (RegularEmployee regularEmployee: regularEmployees
             ) {
            unit += regularEmployee.getSalary() * regularEmployee.getPerformanceScore();
        }
        unit = bonusBudget / unit;

        for (RegularEmployee regularEmployee : regularEmployees
             ) {
            regularEmployee.setBonus((int)(unit * regularEmployee.getSalary() * regularEmployee.getPerformanceScore() * 100)/100.0);
        }
    }

    public String toString(int employees){
        return "\tManager [id: "+getId() +", "+ getFirstName() +" " + getLastName() + "\n" +
                "\t\t# of Employees: "+ employees + "]\n";
    }
    public String toString(){
        return "\tManager [id: "+getId() +", "+ getFirstName() + getLastName() + "\n";
    }


    public ArrayList<RegularEmployee> getRegularEmployees() {
        return regularEmployees;
    }

    public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
        this.regularEmployees = regularEmployees;
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void setBonusBudget(double bonusBudget) throws Exception{
        if (bonusBudget <= 0)
            throw new Exception("Value must be greater than zero.");
        this.bonusBudget = bonusBudget;
    }
}
