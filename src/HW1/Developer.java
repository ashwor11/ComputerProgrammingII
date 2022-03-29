package HW1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Developer extends RegularEmployee{

    private ArrayList<Project> projects;
    public static int numberOfDevelopers;

    public Developer(int id, String firstname, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore, ArrayList<Project> p) throws Exception {
        super(id, firstname, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, performanceScore);
        this.projects = p;
        numberOfDevelopers++;
    }

    public Developer(RegularEmployee re, ArrayList<Project> projects) throws Exception{
        super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.isHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
        this.projects = projects;
        numberOfDevelopers++;
    }

    public boolean addProject( Project s){
        projects.add(s);
        return true;
    }

    public boolean removeProject(Project s){
        projects.remove(s);
        return true;
    }

    public String toString(){
        Date date = getHireDate().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM//yyyy");
        String strDate = dateFormat.format(date);

        String lastString = super.toString() +
                "\t\t\t\t\t[";
        String strProject = "";
        for (Project project: projects
        ) {
            String strDate1 = project.getStartDateAsString();
            strProject += "Project [projectName=" + project.getProjectName() + ", startDate=" + strDate1 + ", state=" + project.isState() + "]";
            lastString += strProject + ", ";
        }
        lastString += "\b]\n";
        return lastString;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public static int getNumberOfDevelopers() {
        return numberOfDevelopers;
    }

    public static void setNumberOfDevelopers(int numberOfDevelopers) throws Exception{
        if (numberOfDevelopers <= 0)
            throw new Exception("Value must be greater than zero.");
        Developer.numberOfDevelopers = numberOfDevelopers;
    }
}
