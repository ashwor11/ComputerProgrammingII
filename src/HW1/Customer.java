package HW1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Customer extends Person{

    private ArrayList<Product> products;

    public Customer(Person person, ArrayList<Product> products) throws Exception {
        super(person.getId(), person.getFirstName(), person.getFirstName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.isHasDriverLicence()) ;
        this.products = products;
    }

    public Customer(int id, String firstname, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, ArrayList<Product> products) throws Exception{
        super(id, firstname, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
        this.products = products;
    }

    public String toString(){
        String lastString = "Customer [id: " + getId() + "products=[";
        String strProject = "";
        for (Product product: products
        ) {
            Date date1 = product.getSaleDate().getTime();
            DateFormat dateFormat1 = new SimpleDateFormat("dd/MM//yyyy");
            String strDate1 = dateFormat1.format(date1);
            strProject += "Product [productName=" + product.getProductName() + ", transactionDate=" + strDate1 + ", price=" + product.getPrice() + "]";
            lastString += strProject + ", ";
        }
        lastString += "\b]\n";
        return lastString;
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
