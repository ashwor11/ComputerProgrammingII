package HW1;

import java.util.Calendar;


public class RegularEmployee extends Employee{
    private double performanceScore;
    private double bonus;

    public RegularEmployee(int id, String firstname, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore) throws Exception{
        super(id, firstname, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
        this.performanceScore = performanceScore;
    }
    public RegularEmployee(Employee employee, double performanceScore) throws Exception{
        super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.isHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
        this.performanceScore = performanceScore;
    }

    public String toString(){

        return super.toString() + "\t\t\t\t\tRegularEmployee Info [performanceScore=" + getPerformanceScore()+ ", bonus=" + getBonus() +"]\n";

    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) throws Exception{
        if (performanceScore <= 0)
            throw new Exception("Value must be greater than 0.");
        this.performanceScore = performanceScore;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) throws Exception{
        if (bonus <= 0)
            throw new Exception("Value must be greater than 0.");
        this.bonus = bonus;
    }
}
