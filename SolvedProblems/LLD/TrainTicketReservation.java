import java.util.*;

class TrainTicketReservation {
    // Class-level variables (static)
    private static int totalSeats = 100; // Example: total number of seats in the train
    private static Set<Integer> bookedSeats = new HashSet<>();
    private static Map<Integer, String> seatToUserMap = new HashMap<>();

    // Instance-level variables
    private String userId;

    // Constructor
    public TrainTicketReservation(String userId) {
        this.userId = userId;
    }

    // Class-level methods (static)
    public static String bookTicket(int seatNumber, String userId) {
        if (seatNumber <= 0 || seatNumber > totalSeats) {
            return "Invalid seat number!";
        }
        if (bookedSeats.contains(seatNumber)) {
            return "Seat already booked!";
        }
        bookedSeats.add(seatNumber);
        seatToUserMap.put(seatNumber, userId);
        return "Seat successfully booked!";
    }

    public static String cancelTicket(int seatNumber, String userId) {
        if (!bookedSeats.contains(seatNumber)) {
            return "Seat is not booked!";
        }
        if (!seatToUserMap.get(seatNumber).equals(userId)) {
            return "Unauthorized cancellation attempt!";
        }
        bookedSeats.remove(seatNumber);
        seatToUserMap.remove(seatNumber);
        return "Seat successfully canceled!";
    }

    public static List<Integer> getBookedSeats() {
        List<Integer> bookedSeatsList = new ArrayList<>(bookedSeats);
        Collections.sort(bookedSeatsList);
        return bookedSeatsList;
    }

    public static boolean isSeatAvailable(int seatNumber) {
        return seatNumber > 0 && seatNumber <= totalSeats && !bookedSeats.contains(seatNumber);
    }

    // Instance-level methods
    public List<Integer> getUserBookings() {
        List<Integer> userBookings = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : seatToUserMap.entrySet()) {
            if (entry.getValue().equals(this.userId)) {
                userBookings.add(entry.getKey());
            }
        }
        Collections.sort(userBookings);
        return userBookings;
    }

    public String bookUserSeat(int seatNumber) {
        return bookTicket(seatNumber, this.userId);
    }

    public String cancelUserSeat(int seatNumber) {
        return cancelTicket(seatNumber, this.userId);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test the system
        TrainTicketReservation user1 = new TrainTicketReservation("user1");
        TrainTicketReservation user2 = new TrainTicketReservation("user2");

        System.out.println(user1.bookUserSeat(10)); // Seat successfully booked!
        System.out.println(user2.bookUserSeat(10)); // Seat already booked!
        System.out.println(user2.bookUserSeat(20)); // Seat successfully booked!
        System.out.println(user1.getUserBookings()); // [10]
        System.out.println(TrainTicketReservation.getBookedSeats()); // [10, 20]

        System.out.println(user1.cancelUserSeat(10)); // Seat successfully canceled!
        System.out.println(user2.cancelUserSeat(10)); // Seat is not booked!
        System.out.println(TrainTicketReservation.getBookedSeats()); // [20]
    }
}
