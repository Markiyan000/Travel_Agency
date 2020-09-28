package app.service;

import app.dto.BookingDto;
import app.model.Booking;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookingService {

    boolean save(Booking booking, Long roomId);

    boolean checkAvailableRooms(Long roomId, BookingDto bookingDto);

    List<Booking> findByUser(Long userId);
}
