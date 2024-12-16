import java.util.ArrayList;
import java.util.Scanner;

public class TicketBookingSystem {
    static ArrayList<Bus> buses = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static User loggedInUser = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pre-populate some buses
        buses.add(new Bus(1, "FastBus", "City A", "City B", "10:00 AM", 30));
        buses.add(new Bus(2, "ExpressLine", "City C", "City D", "2:00 PM", 40));

        // Pre-populate users
        users.add(new User("John Doe", "john", "password"));
        users.add(new User("Jane Smith", "jane", "password123"));

        System.out.println("Welcome to the Bus Ticket Management System!");

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                // Authenticate user
                loggedInUser = authenticateUser(username, password);
                if (loggedInUser != null) {
                    userMenu(sc);
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else {
                break;
            }
        }
    }

    // Authenticate user
    static User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    // User Menu after login
    static void userMenu(Scanner sc) {
        while (true) {
            System.out.println("\nWelcome " + loggedInUser.name);
            System.out.println("1. View Bus Schedules");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View Booking History");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                viewBusSchedules();
            } else if (choice == 2) {
                bookTicket(sc);
            } else if (choice == 3) {
                loggedInUser.viewBookingHistory();
            } else if (choice == 4) {
                loggedInUser = null;
                break;
            }
        }
    }

    // Display all buses and their schedules
    static void viewBusSchedules() {
        if (buses.isEmpty()) {
            System.out.println("No buses available.");
        } else {
            for (Bus bus : buses) {
                bus.displayBusInfo();
            }
        }
    }

    // Book a ticket
    static void bookTicket(Scanner sc) {
        System.out.println("\nEnter bus ID to book a ticket:");
        int busId = sc.nextInt();

        Bus selectedBus = null;
        for (Bus bus : buses) {
            if (bus.busId == busId) {
                selectedBus = bus;
                break;
            }
        }

        if (selectedBus != null && selectedBus.availableSeats > 0) {
            System.out.println("Seats available: " + selectedBus.availableSeats);
            System.out.print("Enter number of seats to book: ");
            int seatsToBook = sc.nextInt();

            if (seatsToBook <= selectedBus.availableSeats) {
                selectedBus.availableSeats -= seatsToBook;
                String bookingDetail = "Bus: " + selectedBus.busName + ", Seats: " + seatsToBook + ", Departure: " + selectedBus.departureTime;
                loggedInUser.addBooking(bookingDetail);
                System.out.println("Ticket(s) booked successfully!");
            } else {
                System.out.println("Not enough seats available.");
            }
        } else {
            System.out.println("Invalid bus ID or no seats available.");
        }
    }
}

