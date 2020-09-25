package app.dao;

import app.model.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao {

    void save(Long roomId, Booking booking);

}
