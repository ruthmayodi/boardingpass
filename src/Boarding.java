
import java.time.LocalTime;
import java.util.*;

public class Boarding {

    // Attributes

    private int passNumber;
    private Date date;
    private String origin;
    private String destination;
    private Date eta;
    private LocalTime departureTime;

    // Constructor

    public Boarding(int passNumber, Date date, String origin, String destination, Date eta, LocalTime departureTime){
        this.passNumber = passNumber;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.eta = eta;
        this.departureTime = departureTime;
    }

    public Boarding() {

    }

    // Getters/Setters

    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    // Override method, don't know if we need it.

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Boarding Pass Number: ").append(this.passNumber).append("\n");
        sb.append("Date: ").append(this.date).append("\n");
        sb.append("Origin: ").append(this.origin).append("\n");
        sb.append("Destination: ").append(this.destination).append("\n");
        sb.append("ETA: ").append(this.eta).append("\n");
        sb.append("Departure Time: ").append(this.departureTime).append("\n");
        return sb.toString();
    }
}
