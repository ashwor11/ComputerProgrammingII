package HW1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Product {
    private String productName;
    private java.util.Calendar saleDate;
    private double price;

    public Product(String productName, Calendar saleDate, double price) {
        this.productName = productName;
        this.saleDate = saleDate;
        this.price = price;
    }

    public String toString(){
        return "";
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) throws Exception{
        if (productName.length() < 3)
            throw new Exception("Value's length must be greater than 3.");
        this.productName = productName;
    }

    public Calendar getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Calendar saleDate) {
        this.saleDate = saleDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception{
        if (price <= 0)
            throw new Exception("Value must be greater than 0.");
        this.price = price;
    }

    public String getSaleDateAsString(){
        Date date1 = getSaleDate().getTime();
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM//yyyy");
        String strDate1 = dateFormat1.format(date1);
        return strDate1;
    }
}
