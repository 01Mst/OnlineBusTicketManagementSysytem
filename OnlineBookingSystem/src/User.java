import java.util.ArrayList;

public class User {
    String name;
    String username;
    String password;
    ArrayList<String> bookingHistory;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.bookingHistory = new ArrayList<>();
    }

    public void addBooking(String bookingDetail) {
        bookingHistory.add(bookingDetail);
    }

    public void viewBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No bookings made yet.");
        } else {
            for (String booking : bookingHistory) {
                System.out.println(booking);
            }
        }
    }
}

