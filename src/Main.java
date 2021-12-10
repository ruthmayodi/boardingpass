
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private int basePrice = 1000;
    private String ticketFilename;

    Passenger human = new Passenger();

    Boarding pass = new Boarding();

    public static void main(String[] args) throws IOException {

    }

   /* public void Construct (){

        Passenger human = new Passenger();
        getPassengerInfo(human);

        Boarding pass = new Boarding();
        getBoardingInfo(pass);
    } */

    public void setPassengerInfo() {

        // Ask user to enter name
        System.out.print("Enter Name: ");
        human.setName(sc.nextLine());

        // Ask user to enter email
        System.out.print("Enter Email: ");
        human.setEmail(sc.nextLine());

        // Ask user to enter phone
        System.out.print("Enter Phone Number: ");
        human.setPhone(sc.nextLine());

        // Ask user to enter gender
        System.out.print("Enter Gender: ");
        human.setGender(sc.nextLine());

        // Ask user to enter age
        System.out.print("Enter Age: ");
        human.setAge(Integer.parseInt(sc.nextLine()));

        System.out.println();
    }

    public void setBoardingInfo() {

        // Ask user to enter date
        System.out.print("Enter Date (DD/MM/YYY): ");
        try {
            pass.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
        } catch (ParseException e) {
            System.out.println("Invalid Date format !!!");
        }

        // Ask user to enter origin
        System.out.print("Enter Origin: ");
        pass.setOrigin(sc.nextLine());

        // Ask user to enter destination
        System.out.print("Enter Destination: ");
        pass.setDestination(sc.nextLine());

        // Ask user to enter departure time
        System.out.print("Enter Departure Time (HH:MM): ");
        String time = sc.next();
        LocalTime lt = LocalTime.parse(time);
        pass.setDepartureTime(lt);

        // Generate random ticket number
        pass.setPassNumber((int) Math.random());
    }
    
    public String getETA() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(pass.getDate());
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int h = Integer.parseInt(pass.getDepartureTime().split(":")[0]);
        int min = Integer.parseInt(pass.getDepartureTime().split(":")[1]);

        return LocalDateTime.of(y, m, d, h, min).minusMinutes(5)
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    
    public String getDepartureTimeString() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(pass.getDate());
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int h = Integer.parseInt(pass.getDepartureTime().split(":")[0]);
        int min = Integer.parseInt(pass.getDepartureTime().split(":")[1]);

        return LocalDateTime.of(y, m, d, h, min).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    
    public double calculatePrice() {
        double price = basePrice;

        if (human.getAge() <= 12) {
            price -= 0.5 * price;
        } else if (human.getAge() >= 60) {
            price -= 0.6 * price;
        } else if (human.getGender().equalsIgnoreCase("female")) {
            price -= 0.25 * price;
        }

        return price;
    }
    
    public void generateTicket(Passenger human, Boarding pass) throws IOException {
        ticketFilename = String.format("%s_%s.txt", pass.getPassNumber(), human.getName().toUpperCase());
        PrintWriter writer = new PrintWriter(new FileWriter(ticketFilename));

        writer.println("=============================================================");
        writer.printf("%20s%3s %s\n", "Boarding Pass Number", ":", pass.getPassNumber());
        writer.printf("%20s%3s %s\n", "Date", ":", new SimpleDateFormat("dd/MM/yyyy").format(pass.getDate()));
        writer.printf("%20s%3s %s\n", "Origin", ":", pass.getOrigin());
        writer.printf("%20s%3s %s\n", "Destination", ":", pass.getDestination());
        writer.printf("%20s%3s %s\n", "ETA", ":", pass.getEta());
        writer.printf("%20s%3s %s\n", "Departure Time", ":", pass.getDepartureTime());
        writer.printf("%20s%3s %s\n", "Passenger Name", ":", human.getName());
        writer.printf("%20s%3s %s\n", "Email", ":", human.getEmail());
        writer.printf("%20s%3s %s\n", "Phone Number", ":", human.getPhone());
        writer.printf("%20s%3s %s\n", "Gender", ":", human.getGender());
        writer.printf("%20s%3s %s\n", "Age", ":", human.getAge());
        writer.printf("%20s%3s %s\n", "Total Ticket Price", ":", "$" + calculatePrice());
        writer.println("=============================================================");

        writer.close();
    }
    
    public void displayTicket() throws FileNotFoundException {
        Scanner file = new Scanner(new File(ticketFilename));

        while (file.hasNext()) {
            System.out.println(file.nextLine());
        }

        file.close();
    }
    
}
