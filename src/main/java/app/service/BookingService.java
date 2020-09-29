package app.service;

import app.dto.BookingDto;
import app.model.Booking;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookingService {

    boolean save(Booking booking, Long roomId);

    List<Booking> findByUser(Long userId);
}
