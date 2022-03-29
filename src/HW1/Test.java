package HW1;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Test {

    static ArrayList<Department> departments = new ArrayList<Department>();
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static ArrayList<SalesEmployee> salesEmployees = new ArrayList<SalesEmployee>();
    static ArrayList<Developer> developers = new ArrayList<>();
    static ArrayList<Manager> managers = new ArrayList<Manager>();
    static ArrayList<Project> projects = new ArrayList<Project>();
    static ArrayList<Person> persons = new ArrayList<Person>();
    static ArrayList<Product> products = new ArrayList<Product>();
    static ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();



    public static void main(String[] args) throws Exception{

        String filename = "input.txt";

        getInput(filename);

        addEmployees();

        distributeBonusBudgetes();
        raiseSalaryManagers(0.2);
        raiseSalaryRegularEmployees(0.3);
        raiseSalaryDevelopers(0.18);
        raiseSalarySalesEmployees(0.18);
        rewardBestSalesEmployee(1000);







        String output = "output.txt";

        printOut(output);


    }


    public static void getInput(String fileName) throws Exception {
        String path = new File(".").getAbsolutePath();
        File file = new File(fileName);
        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String values[] = line.split(" ");
                String key = values[0];
                switch (key){
                    case "Department":
                        newDepartment(values);
                    case "Project":
                        newProject(values);
                    case "Product":
                        newProduct(values);
                    case "Person":
                        newPerson(values);
                    case "Employee":
                        newEmployee(values);
                    case "Manager":
                        newManager(values);
                    case "RegularEmployee":
                        newRegularEmployee(values);
                    case "Developer":
                        newDeveloper(values);
                    case "SalesEmployee":
                        newSalesEmployee(values);
                    case "Customer":
                        newCustomer(values);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Department newDepartment(String[] keys){
        if (!keys[0].equals("Department"))
            return null;
        Department department = new Department(Integer.parseInt(keys[1]), keys[2]);
        departments.add(department);
        return department;
    }

    public static Project newProject(String[] keys) throws Exception {
        if(!keys[0].equals("Project"))
            return null;
        Calendar calendar = Calendar.getInstance();

        String date[] = keys[2].split("/");
        calendar.set(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        Project project = new Project(keys[1],calendar,keys[3]);
        projects.add(project);
        return project;
    }

    public static Product newProduct(String[] keys){
        if(!keys[0].equals("Product"))
            return null;
        Calendar calendar = Calendar.getInstance();

        String date[] = keys[2].split("/");
        calendar.set(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        Product product = new Product(keys[1],calendar,Double.parseDouble(keys[3]));
        products.add(product);
        return product;
    }

    public static Person newPerson(String[] keys) throws Exception {
        if(!keys[0].equals("Person"))
            return null;
        Calendar calendar = Calendar.getInstance();

        String date[] = keys[5].split("/");
        calendar.set(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        Person person = new Person(Integer.parseInt(keys[3]),keys[1], keys[2],keys[4], calendar, keys[6], keys[7]);
        persons.add(person);
        return person;
    }

    public static Employee newEmployee(String[] keys) throws Exception {
        if (!keys[0].equals("Employee"))
            return null;
        Calendar calendar = Calendar.getInstance();

        String date[] = keys[3].split("/");
        calendar.set(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        Person person = null;
        for (Person p: persons
        ) {
            if (Integer.parseInt(keys[1]) == p.getId()){
                person = p;
                break;
            }

        }
        Department department = null;
        for (Department department1: departments
        ) {
            if (keys[4].equals(department1.getDepartmentName())){
                department = department1;
                break;
            }
        }
        Employee employee = new Employee(person,Double.parseDouble(keys[2]),calendar,department);
        employees.add(employee);
        return employee;

    }

    public static Manager  newManager(String[] keys) throws Exception {
        if (!keys[0].equals("Manager"))
            return null;
        Employee employee = null;
        for (Employee e: employees
        ) {
            if (Integer.parseInt(keys[1]) == e.getId()){
                employee = e;
                break;
            }
        }
        Manager manager = new Manager(employee,Double.parseDouble(keys[2]));
        managers.add(manager);
        return manager;

    }

    public static RegularEmployee newRegularEmployee(String keys[]) throws Exception {
        if (!keys[0].equals("RegularEmployee"))
            return null;
        Employee employee = null;
        for (Employee e: employees
        ) {
            if (Integer.parseInt(keys[1]) == e.getId()){
                employee = e;
                break;
            }
        }
        RegularEmployee regularEmployee = new RegularEmployee(employee,Double.parseDouble(keys[2]));
        regularEmployees.add(regularEmployee);
        return regularEmployee;
    }

    public static Developer newDeveloper (String keys[]) throws Exception {
        if (!keys[0].equals("Developer"))
            return null;
        RegularEmployee regularEmployee = null;
        for (RegularEmployee e: regularEmployees
        ) {
            if (Integer.parseInt(keys[1]) == e.getId()){
                regularEmployee = e;
                break;
            }
        }
        ArrayList<Project> projects1 = new ArrayList<Project>();
        for (int i = 2; i< keys.length; i++){
            for (Project p: projects
            ) {
                if (keys[i].equals(p.getProjectName())){
                    projects1.add(p);
                    break;
                }
            }
        }
        Developer developer = new Developer(regularEmployee,projects1);
        developers.add(developer);
        return developer;
    }

    public static SalesEmployee newSalesEmployee(String[] keys) throws Exception {
        if (!keys[0].equals("SalesEmployee"))
            return null;
        RegularEmployee regularEmployee = null;
        for (RegularEmployee e: regularEmployees
        ) {
            if (Integer.parseInt(keys[1]) == e.getId()){
                regularEmployee = e;
                break;
            }
        }
        ArrayList<Product> products1 = new ArrayList<Product>();
        for (int i = 2; i< keys.length; i++){
            for (Product p: products
            ) {
                if (keys[i].equals(p.getProductName())){
                    products1.add(p);
                    break;
                }
            }
        }
        SalesEmployee salesEmployee = new SalesEmployee(regularEmployee,products1);
        salesEmployees.add(salesEmployee);
        return salesEmployee;
    }

    public static Customer newCustomer (String[] keys) throws Exception {
        if (!keys[0].equals("Customer"))
            return null;

        Person person = null;
        for (Person p: persons
        ) {
            if (Integer.parseInt(keys[1]) == p.getId()){
                person = p;
                break;
            }
        }

        ArrayList<Product> products1 = new ArrayList<Product>();
        for (int i = 2; i< keys.length; i++){
            for (Product p: products
            ) {
                if (keys[i].equals(p.getProductName())){
                    products1.add(p);
                    break;
                }
            }
        }

        Customer customer = new Customer(person, products1);
        customers.add(customer);
        return customer;
    }

    public static void addEmployees (){

        for (Department department: departments
        ) {
            for (Manager manager: managers
            ) {
                if (department == manager.getDepartment()){
                    for (RegularEmployee regularEmployee: regularEmployees
                    ) {
                        if (department == regularEmployee.getDepartment()){
                            manager.addEmployee(regularEmployee);
                        }

                    }
                }

            }
        }
    }

    public static void distributeBonusBudgetes () throws Exception {

        for (Manager manager: managers
             ) {
            manager.distributeBonusBudget();
        }
        for (RegularEmployee regularEmployee: salesEmployees){
            for (RegularEmployee regularEmployee1: regularEmployees){
                if (regularEmployee.getId() == regularEmployee1.getId())
                    regularEmployee.setBonus(regularEmployee1.getBonus());
            }
        }
        for (RegularEmployee regularEmployee: developers){
            for (RegularEmployee regularEmployee1: regularEmployees){
                if (regularEmployee.getId() == regularEmployee1.getId())
                    regularEmployee.setBonus(regularEmployee1.getBonus());
            }
        }
    }

    public static void raiseSalaryManagers (double percent) throws Exception {
        for (Manager manager: managers
             ) {
            manager.raiseSalary(percent);
        }
    }

    public static void raiseSalaryManagers (int amount) throws Exception {
        for (Manager manager: managers
        ) {
            manager.raiseSalary(amount);
        }
    }

    public static void raiseSalaryRegularEmployees (double percent) throws Exception {
        for (RegularEmployee regularEmployee: regularEmployees
        ) {
            regularEmployee.raiseSalary(percent);
        }
    }

    public static void raiseSalaryRegularEmployees (int amount) throws Exception {
        for (RegularEmployee regularEmployee: regularEmployees
        ) {
            regularEmployee.raiseSalary(amount);
        }
    }

    public static void raiseSalaryDevelopers (double percent) throws Exception {
        for (Developer developer: developers
        ) {
            developer.raiseSalary(percent);
        }
    }

    public static void raiseSalaryDevelopers (int amount) throws Exception {
        for (Developer developer: developers
        ) {
            developer.raiseSalary(amount);
        }
    }

    public static void raiseSalarySalesEmployees (double percent) throws Exception {
        for (SalesEmployee salesEmployee: salesEmployees
        ) {
            salesEmployee.raiseSalary(percent);
        }
    }

    public static void raiseSalarySalesEmployees (int amount) throws Exception {
        for (SalesEmployee salesEmployee: salesEmployees
        ) {
            salesEmployee.raiseSalary(amount);
        }
    }

    public static void rewardBestSalesEmployee (int amount) throws Exception {

        SalesEmployee salesEmployee = null;
        int max = 0;
        for (SalesEmployee e: salesEmployees
             ) {
            int current = 0;
            for (Product product: e.getSales()){
                current += product.getPrice();
            }
            if (current >= max)
                salesEmployee = e;
            
        }
        
        salesEmployee.raiseSalary(amount);
    }


    public static void printOut(String fileName){
        String lastString = "";
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (Department department: departments
             ) {
            int i = 0;
            lastString += department.toString();
            boolean mngfound = false;
            String employeeStr = "";
            for (Manager manager: managers
                 ) {

                for (Developer developer: developers
                     ) {
                    if (developer.getDepartment() == department && !ids.contains(developer.getId())){
                        i++;
                        ids.add(developer.getId());
                        employeeStr += "\t\t\t\t " + i +". Developer\n" + developer.toString();

                    }

                }
                for (SalesEmployee salesEmployee: salesEmployees
                ) {
                    if (salesEmployee.getDepartment() == department && !ids.contains(salesEmployee.getId())){
                        i++;
                        ids.add(salesEmployee.getId());
                        employeeStr += "\t\t\t\t " + i +". SalesEmployee\n" +  salesEmployee.toString();
                    }

                }
                for (RegularEmployee regularEmployee: regularEmployees
                ) {
                    if (regularEmployee.getDepartment() == department && !ids.contains(regularEmployee.getId())){
                        i++;
                        ids.add(regularEmployee.getId());
                        employeeStr += "\t\t\t\t " + i +". SalesEmployee\n" +  regularEmployee.toString();
                    }

                }
                    if(manager.getDepartment() == department && !ids.contains(manager.getId())){
                        ids.add(manager.getId());
                        lastString += manager.toString(i);
                        lastString += employeeStr;
                        mngfound = true;
                        break;
                    }

            }
            if (!mngfound){
                lastString += employeeStr;
            }

        }
        lastString += "\n**********************CUSTOMERS************************\n";
        for (Customer customer: customers
             ) {
            if(!ids.contains(customer.getId())){
                lastString += customer.toString();
                ids.add(customer.getId());
            }

        }

        lastString += "\n**********************PEOPLE************************\n";
        for(Person person: persons){
            if(!ids.contains(person.getId())){
                ids.add(person.getId());
                lastString += person.toString();
            }

        }

        String path = new File(".").getAbsolutePath();
        File file = new File(fileName);
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.print(lastString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;

    }



}
