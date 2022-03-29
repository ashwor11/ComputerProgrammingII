package HW1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SalesEmployee extends RegularEmployee{
    private ArrayList<Product> sales;
    public static int numberOfSalesEmployees;

    public SalesEmployee(int id, String firstname, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore, ArrayList<Product> sales) throws Exception {
        super(id, firstname, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, performanceScore);
        this.sales = sales;
        numberOfSalesEmployees++;
    }

    public SalesEmployee(RegularEmployee re, ArrayList<Product> sales) throws Exception{
        super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.isHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
        this.sales = sales;
        numberOfSalesEmployees++;
    }

    public boolean addSale(Product s){
        sales.add(s);
        return true;
    }

    public boolean removeSale(Product s){
        sales.remove(s);
        return true;
    }

    public String toString(){


        String lastString = super.toString() +
                "\t\t\t\t\t[";
        String strProject = "";
        for (Product product: sales
        ) {
            String strDate1 = product.getSaleDateAsString();
            strProject += "Product [productName=" + product.getProductName() + ", saleDate=" + strDate1 + ", price=" + product.getPrice() + "]";
            lastString += strProject + ", ";
        }
        lastString += "\b]\n";
        return lastString;
    }

    public ArrayList<Product> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Product> sales) {
        this.sales = sales;
    }

    public static int getNumberOfSalesEmployees() {
        return numberOfSalesEmployees;
    }

    public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) throws Exception{
        if (numberOfSalesEmployees <= 0)
            throw new Exception("Value must be greater than 0.");
        SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
    }

}
