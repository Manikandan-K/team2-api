package spicinemas.api.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Booking {
    public Booking(){

    }

    private long id;

    public long getBookingId() {
        return id;
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
        return this.numberOfSeats;
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
