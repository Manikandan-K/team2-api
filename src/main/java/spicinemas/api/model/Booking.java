package spicinemas.api.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Booking {

    private Long bookingId;
    private String userEmail;
    private String userName;
    private Long showId;

    public Booking(Long bookingId, String userEmail, String userName, Long showId) {
        this.bookingId = bookingId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.showId = showId;
    }

    public Booking(String userEmail, String userName, Long showId) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.showId = showId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public Long getShowId() {
        return showId;
    }
}
