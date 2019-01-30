package spicinemas.api.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Booking {

    private long bookingId;

    public long getBookingId() {
        return bookingId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public long getShowId() {
        return showId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    private String userEmail;
    private String userName;
    private long showId;
    private int numberOfSeats;

    public Booking(Long showId, String userEmail, String userName, int numberOfSeats) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.showId = showId;
        this.numberOfSeats = numberOfSeats;
    }
}
