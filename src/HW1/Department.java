package HW1;

public class Department {
    private int departmentId;
    private String departmentName;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String toString(){
        return "************************************************\n" +
                "Department [departmentId=" + departmentId +", departmentName=" +departmentName + "]\n";
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) throws Exception{
        if (departmentId <= 0) {
            throw new Exception("Value must be greater than zero.");
        }
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) throws Exception {
        if (departmentName.length() < 3)
            throw new Exception("Value's length must be greater than 2.");
        this.departmentName = departmentName;
    }
}
