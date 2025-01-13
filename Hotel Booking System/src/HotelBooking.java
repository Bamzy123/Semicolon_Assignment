import java.util.*;
import java.text.*;

class Room {
    int roomNumber;
    String roomType;
    double pricePerNight;
    boolean isAvailable;
    boolean needsMaintenance;

    Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
        this.needsMaintenance = false;
    }

    public void markAsOccupied() {
        isAvailable = false;
    }

    public void markAsAvailable() {
        isAvailable = true;
        needsMaintenance = false;
    }

    public void markAsUnderMaintenance() {
        isAvailable = false;
        needsMaintenance = true;
    }
}

class Guest {
    String name;
    String phoneNumber;
    String email;
    String bookingReference;

    Guest(String name, String phoneNumber, String email, String bookingReference) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingReference = bookingReference;
    }

    public void getDetails() {
        System.out.println("Guest Details:");
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Booking Reference: " + bookingReference);
    }

    public void editDetails(String newName, String newPhone, String newEmail) {
        if (!newName.isEmpty()) this.name = newName;
        if (!newPhone.isEmpty()) this.phoneNumber = newPhone;
        if (!newEmail.isEmpty()) this.email = newEmail;
        System.out.println("Profile updated successfully.");
    }
}

class Booking {
    Guest guest;
    Room room;
    Date checkInDate;
    Date checkOutDate;
    double totalPayment;

    Booking(Guest guest, Room room, Date checkInDate, Date checkOutDate, double totalPayment) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPayment = totalPayment;
    }

    public static double calculatePayment(double pricePerNight, int days, boolean festivePeriod, double multiplier) {
        double total = pricePerNight * days;
        if (festivePeriod) {
            total *= multiplier;
        }
        return total;
    }

    public static void displayPaymentDetails(String roomType, double pricePerNight, int days, boolean festivePeriod, double multiplier) {
        double total = calculatePayment(pricePerNight, days, festivePeriod, multiplier);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: ₦" + pricePerNight);
        if (festivePeriod) {
            System.out.println("Festive Period Surcharge: 20%");
        }
        System.out.println("Total Payment: ₦" + total);
    }

    public void cancelBooking() {
        room.markAsAvailable();
        System.out.println("Booking canceled successfully.");
    }
}

class HotelSystem {
    List<Room> rooms = new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();
    List<String> notifications = new ArrayList<>();
    double festivePeriodMultiplier = 1.2;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    public void initializeRooms() {
        rooms.add(new Room(101, "Single", 10000));
        rooms.add(new Room(203, "Double", 15000));
        rooms.add(new Room(301, "Suite", 25000));
    }

    public void bookRoom(String guestName, String phone, String email, String roomType, int nights, boolean festivePeriod, String checkInDateStr) {
        try {
            Date checkInDate = dateFormat.parse(checkInDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(checkInDate);
            calendar.add(Calendar.DAY_OF_YEAR, nights);
            Date checkOutDate = calendar.getTime();

            for (Room room : rooms) {
                if (room.roomType.equalsIgnoreCase(roomType) && room.isAvailable) {
                    String bookingReference = "REF" + (bookings.size() + 1);
                    Guest guest = new Guest(guestName, phone, email, bookingReference);
                    double totalPayment = Booking.calculatePayment(room.pricePerNight, nights, festivePeriod, festivePeriodMultiplier);
                    bookings.add(new Booking(guest, room, checkInDate, checkOutDate, totalPayment));
                    room.markAsOccupied();
                    notifications.add("Booking confirmed for " + guestName + " (Reference: " + bookingReference + ").");
                    displayBookingDetails(guest, room, nights, totalPayment, checkInDate, checkOutDate);
                    return;
                }
            }
            System.out.println("No available rooms of the requested type.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd-MMM-yyyy.");
        }
    }

    void displayBookingDetails(Guest guest, Room room, int nights, double totalPayment, Date checkInDate, Date checkOutDate) {
        System.out.println("Booking Successful!");
        System.out.println("Guest Details:");
        System.out.println(" Name: " + guest.name);
        System.out.println(" Phone: " + guest.phoneNumber);
        System.out.println(" Email: " + guest.email);
        System.out.println("\nRoom Details:");
        System.out.println(" Room Number: " + room.roomNumber);
        System.out.println(" Type: " + room.roomType);
        System.out.println(" Price per Night: ₦" + room.pricePerNight);
        System.out.println(" Total Payment: ₦" + totalPayment);
        System.out.println(" Booking Reference Number: " + guest.bookingReference);
        System.out.println(" Check-in Date: " + dateFormat.format(checkInDate));
        System.out.println(" Check-out Date: " + dateFormat.format(checkOutDate));
    }

    public void viewBooking(String bookingReference) {
        for (Booking booking : bookings) {
            if (booking.guest.bookingReference.equals(bookingReference)) {
                displayBookingDetails(booking.guest, booking.room, 0, booking.totalPayment, booking.checkInDate, booking.checkOutDate);
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public void editProfile(String bookingReference, String newName, String newPhone, String newEmail) {
        for (Booking booking : bookings) {
            if (booking.guest.bookingReference.equals(bookingReference)) {
                booking.guest.editDetails(newName, newPhone, newEmail);
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public void checkRoomAvailability(String startDateStr, String endDateStr) {
        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);

            System.out.println("Available Rooms:");
            for (Room room : rooms) {
                boolean isAvailable = true;
                for (Booking booking : bookings) {
                    if (booking.room.roomNumber == room.roomNumber &&
                            !(booking.checkOutDate.before(startDate) || booking.checkInDate.after(endDate))) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable && room.isAvailable && !room.needsMaintenance) {
                    System.out.println("Room Number: " + room.roomNumber + ", Type: " + room.roomType + ", Price: ₦" + room.pricePerNight);
                }
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd-MMM-yyyy.");
        }
    }

    public void viewNotifications() {
        System.out.println("Notifications:");
        for (String notification : notifications) {
            System.out.println("- " + notification);
        }
    }

    public void cancelBooking(String bookingReference) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.guest.bookingReference.equals(bookingReference)) {
                booking.room.markAsAvailable();
                iterator.remove();
                notifications.add("Booking with reference " + bookingReference + " has been canceled.");
                System.out.println("Booking canceled successfully.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public void viewAvailableRooms() {
        System.out.println("All Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable && !room.needsMaintenance) {
                System.out.println("Room Number: " + room.roomNumber + ", Type: " + room.roomType + ", Price: ₦" + room.pricePerNight);
            }
        }
    }
}

public class HotelBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelSystem hotelSystem = new HotelSystem();
        hotelSystem.initializeRooms();

        while (true) {
            System.out.println("\nWelcome, Our Esteemed Customer!");
            System.out.println("1. Book Room");
            System.out.println("2. View Booking");
            System.out.println("3. Edit Profile");
            System.out.println("4. Check Room Availability");
            System.out.println("5. Payment Status");
            System.out.println("6. Cancel Booking");
            System.out.println("7. View All Available Rooms");
            System.out.println("8. View Notifications");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter your phone number:");
                    String phone = scanner.nextLine();
                    System.out.println("Enter your email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter room type (Single/Double/Suite):");
                    String roomType = scanner.nextLine();
                    System.out.println("Enter number of nights:");
                    int nights = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter check-in date (dd-MMM-yyyy):");
                    String checkInDate = scanner.nextLine();
                    System.out.println("Is it a festive period? (true/false):");
                    boolean festivePeriod = scanner.nextBoolean();
                    hotelSystem.bookRoom(name, phone, email, roomType, nights, festivePeriod, checkInDate);
                    break;
                case 2, 5:
                    System.out.println("Enter booking reference:");
                    String bookingRef = scanner.nextLine();
                    hotelSystem.viewBooking(bookingRef);
                    break;
                case 3:
                    System.out.println("Enter booking reference:");
                    String ref = scanner.nextLine();
                    System.out.println("Enter new name (leave blank to keep current):");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new phone (leave blank to keep current):");
                    String newPhone = scanner.nextLine();
                    System.out.println("Enter new email (leave blank to keep current):");
                    String newEmail = scanner.nextLine();
                    hotelSystem.editProfile(ref, newName, newPhone, newEmail);
                    break;
                case 4:
                    System.out.println("Enter start date (dd-MMM-yyyy):");
                    String startDate = scanner.nextLine();
                    System.out.println("Enter end date (dd-MMM-yyyy):");
                    String endDate = scanner.nextLine();
                    hotelSystem.checkRoomAvailability(startDate, endDate);
                    break;
                case 6:
                    System.out.println("Enter booking reference:");
                    String cancelRef = scanner.nextLine();
                    hotelSystem.cancelBooking(cancelRef);
                    break;
                case 7:
                    hotelSystem.viewAvailableRooms();
                    break;
                case 8:
                    hotelSystem.viewNotifications();
                    break;
                case 9:
                    System.out.println("Thank you for using Naija Comfort Inn System!");
                    return;
                default:
                    System.out.println("Invalid Option. Try again.");
            }
        }
    }
}