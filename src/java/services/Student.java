package services;

/**
 *
 * @author shelc
 */
public class Student {

    protected int id;
    protected String fname;
    protected String lname;
    protected String email;
    protected String address;

    public Student(int id, String fname, String lname, String email, String address) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
    }

    public Student(String fname, String lname, String email, String address) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
