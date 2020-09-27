package app.service;

import app.model.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface BookingService {

    boolean save(Booking booking, Long roomId);

    boolean checkAvailableRooms(Long roomId, LocalDate arrivalDate, LocalDate departureDate, int bookedNumberOfRooms);
}
