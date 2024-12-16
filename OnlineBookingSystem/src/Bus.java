public class Bus {
    int busId;
    String busName;
    String source;
    String destination;
    String departureTime;
    int totalSeats;
    int availableSeats;

    public Bus(int busId, String busName, String source, String destination, String departureTime, int totalSeats) {
        this.busId = busId;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public void displayBusInfo() {
        System.out.println("Bus ID: " + busId);
        System.out.println("Bus Name: " + busName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Available Seats: " + availableSeats);
    }
}

