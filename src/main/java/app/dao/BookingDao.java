package app.dao;

import app.model.Booking;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingDao {

    void save(Long roomId, Booking booking);

    List<Booking> findByRoom(Long roomId);

    List<Booking> findByUser(Long userId);
}
