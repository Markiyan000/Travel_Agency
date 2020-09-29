package app.service.impl;

import app.dao.BookingDao;
import app.dao.RoomDao;
import app.dto.BookingDto;
import app.model.Booking;
import app.service.AvailabilityService;
import app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingDao bookingDao;

    private RoomDao roomDao;

    private AvailabilityService availabilityService;

    @Autowired
    public BookingServiceImpl(BookingDao bookingDao, RoomDao roomDao, AvailabilityService availabilityService) {
        this.bookingDao = bookingDao;
        this.roomDao = roomDao;
        this.availabilityService = availabilityService;
    }

    @Override
    @Transactional
    public boolean save(Booking booking, Long roomId) {
        BookingDto bookingDto = BookingDto.valueOf(booking);
        if (!availabilityService.checkAvailableRooms(roomId, bookingDto)) {
            return false;
        }
        BigDecimal totalPrice = calculateTotalPrice(booking, roomId);
        booking.setPrice(totalPrice);
        bookingDao.save(roomId, booking);

        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findByUser(Long userId) {
        return bookingDao.findByUser(userId);
    }

    private BigDecimal calculateTotalPrice(Booking booking, Long roomId) {
        BigDecimal priceByRoom = roomDao.findPrice(roomId);
        long days = ChronoUnit.DAYS.between(booking.getArrivalDate(), booking.getDepartureDate());
        int numberOfRooms = booking.getNumberOfRooms();

        return priceByRoom.multiply(BigDecimal.valueOf(days)).multiply(BigDecimal.valueOf(numberOfRooms));
    }
}