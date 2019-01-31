package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Booking;


@Repository
@Transactional
public class BookingRepository {
    @Autowired
    private DSLContext dsl;

    public long addBooking(Booking booking) {
        return (long) dsl.insertInto(DSL.table("Booking"))
                .columns(DSL.field("showId"), DSL.field("userEmail"),
                        DSL.field("numberOfSeats"), DSL.field("userName"))
                .values(booking.getShowId(), booking.getUserEmail(),
                        booking.getNumberOfSeats(), booking.getUserName())
                .returning(DSL.field("id"))
                .fetchOne()
                .get(DSL.field("id"));
    }

    public Booking getBooking(long bookingId) {
        return dsl.select(DSL.field("showId"), DSL.field("userEmail"), DSL.field("userName"))
                .from(DSL.table("Booking"))
                .where(DSL.field("Booking.id").eq(bookingId))
                .fetchOne()
                .into(Booking.class);
    }

    public long getNumberOfSeatsBookedForShow(long showId) {
        String query = "SELECT COALESCE(sum(numberOfSeats), 0) as booked FROM Booking WHERE showId = " + showId;
        Result result = dsl.fetch(query);
        return (long) result.getValue(0, DSL.field("booked"));
    }
}
