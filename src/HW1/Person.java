package HW1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private byte gender;
    private java.util.Calendar birthDate;
    private byte maritalStatus;
    private boolean hasDriverLicence;



    public Person (int id, String firstname, String lastName, String gender,
                   Calendar birthDate, String maritalStatus, String hasDriverLicence) throws Exception{
        setBirthDate(birthDate);
        setFirstName(firstname);
        setGender(gender);
        setId(id);
        setHasDriverLicence(hasDriverLicence);
        setLastName(lastName);
        setMaritalStatus(maritalStatus);
    }

    public String toString(){
        Date date1 = getBirthDate().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(date1);
        return "Person [id="+id+ ", firstName="+firstName+", lastName=" + lastName +", gender=" +getGender()+", birthDate=" + date +", maritalStatus=" + getMaritalStatus() + ", hasDriverLicence=" + isHasDriverLicence() + "]\n";
    }




    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception{
        if (id < 1)
            throw new Exception("Value must be greater than zero.");
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception{
        if (firstName.length() < 3)
            throw new Exception("Value's length must be greater than 3.");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception{
        if (lastName.length() < 3)
            throw new Exception("Value's length must be greater than 3.");
        this.lastName = lastName;
    }

    public String getGender() {
        if (gender == 1)
            return "Woman";
        else
            return "Man";
    }

    public void setGender(String gender) throws Exception{
        if (gender.length() < 3)
            throw new Exception("Value's length must be greater than 3.");
        if (gender.equals("Woman"))
            this.gender = 1;
        else if (gender.equals("Man"))
            this.gender = 2;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        if (maritalStatus == 1)
            return "Single";
        else
            return "Married";
    }

    public void setMaritalStatus(String maritalStatus) throws Exception{
        if (maritalStatus.length() < 3)
            throw new Exception("Value's length must be greater than 3.");
        if (maritalStatus.equals("Married"))
            this.maritalStatus = 2;
        else if (maritalStatus.equals("Single"))
            this.maritalStatus = 1;
    }

    public String isHasDriverLicence() {
        if (hasDriverLicence)
            return "Yes";
        else
            return "No";

    }

    public void setHasDriverLicence(String hasDriverLicence) throws Exception{

        if (hasDriverLicence.equals("Yes"))
            this.hasDriverLicence = true;
        else if (hasDriverLicence.equals("No"))
            this.hasDriverLicence = false;
    }
}
