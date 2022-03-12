import java.time.LocalTime;
import java.util.Date;

public class User {
    private int age;
    private String name, email, gender, origin, destination, phoneNumber;
    private Date date;
    private String departureTime;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDate() {
        return date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

}
