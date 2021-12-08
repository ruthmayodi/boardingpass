
import java.util.*;

public class Passenger {

    // Attributes

    private String name;
    private String email;
    private int phone;
    private String gender;
    private int age;

    // Constructor

    public Passenger(String name, String email, int phone, String gender, int age){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
    }

    // Getters/Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Override method, don't know if we need it.

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passenger Name: ").append(this.name).append("\n");
        sb.append("Passenger Email: ").append(this.email).append("\n");
        sb.append("Passenger Phone Number: ").append(this.phone).append("\n");
        sb.append("Passenger Gender: ").append(this.gender).append("\n");
        sb.append("Passenger Age: ").append(this.age).append("\n");
        return sb.toString();
    }
}
