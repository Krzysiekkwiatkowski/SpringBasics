package pl.coderslab.day1homework.beans;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String nickName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
