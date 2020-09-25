package app.service;

import app.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    void save(Booking booking, Long roomId);
}
