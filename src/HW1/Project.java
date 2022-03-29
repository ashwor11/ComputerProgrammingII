package HW1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Project {
    private String projectName;
    private java.util.Calendar startDate;
    private boolean state;

    public Project(String projectName, Calendar startDate, String state) throws Exception{
        this.projectName = projectName;
        this.startDate = startDate;
        setState(state);
    }

    public void close(){
        if (state)
            state = false;
    }

    public String toString(){
        return "";
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) throws Exception{
        if (projectName.length() < 3)
            throw new Exception("Value's length must be greater than 3.");
        this.projectName = projectName;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public String isState() {
        if (state)
            return "Open";
        else
            return "Close";
    }

    public void setState(String state) throws Exception{
        if (state.length() < 3)
            throw new Exception("Value's length must be greater than 3.");
        if (state.equals("Open"))
            this.state = true;
        else if (state.equals("Close"))
            this.state = false;
    }

    public String getStartDateAsString(){
        Date date1 = getStartDate().getTime();
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM//yyyy");
        String strDate1 = dateFormat1.format(date1);
        return strDate1;
    }
}
