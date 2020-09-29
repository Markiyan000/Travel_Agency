package app.service;

import app.dto.BookingDto;
import org.springframework.stereotype.Service;

@Service
public interface AvailabilityService {

    boolean checkAvailableRooms(Long roomId, BookingDto bookingDto);
}
