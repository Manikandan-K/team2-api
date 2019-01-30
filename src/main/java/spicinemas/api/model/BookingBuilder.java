package spicinemas.api.model;

public class BookingBuilder {
    private long showId;
    private String userEmail;
    private String userName;
    private int numberOfSeats;

    public BookingBuilder forShow(long showId) {
        this.showId = showId;
        return this;
    }

    public BookingBuilder forUser(String userName, String email) {
        this.userName = userName;
        this.userEmail = email;
        return this;
    }

    public BookingBuilder blockingSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public Booking createBooking() {
        return new Booking(showId,userName,userEmail,numberOfSeats);
    }
}
