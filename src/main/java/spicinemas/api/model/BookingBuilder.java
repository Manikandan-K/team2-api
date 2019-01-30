package spicinemas.api.model;

public class BookingBuilder {
    private long showId;
    private String userEmail;
    private String userName;

    public BookingBuilder setShowId(long showId) {
        this.showId = showId;
        return this;
    }

    public BookingBuilder setUserEmail(String email) {
        this.userEmail = email;
        return this;
    }

    public BookingBuilder setUserName(String name) {
        this.userName = name;
        return this;
    }

    public Booking createBooking() {
        return new Booking(this.userEmail, this.userName, this.showId);
    }
}
