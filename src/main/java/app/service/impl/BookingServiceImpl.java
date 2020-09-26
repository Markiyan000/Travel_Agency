package app.service.impl;

import app.dao.BookingDao;
import app.dao.RoomDao;
import app.model.Booking;
import app.service.BookingService;
import app.utils.LocalDates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingDao bookingDao;

    private RoomDao roomDao;

    @Autowired
    public BookingServiceImpl(BookingDao bookingDao, RoomDao roomDao) {
        this.bookingDao = bookingDao;
        this.roomDao = roomDao;
    }

    @Override
    @Transactional
    public void save(Booking booking, Long roomId) {
        BigDecimal priceByRoom = roomDao.findPrice(roomId);
        BigDecimal totalPrice = calculateTotalPrice(priceByRoom, booking.getNumberOfRooms());
        booking.setPrice(totalPrice);

        bookingDao.save(roomId, booking);
    }

    @Override
    public boolean checkAvailableRooms(Long roomId, LocalDate arrivalDate, LocalDate departureDate) {
        List<Booking> bookingsOnRoom = bookingDao.findByRoom(roomId);
        if (bookingsOnRoom.isEmpty()) {
            return true;
        }

        Predicate<Booking> availableRoomsPredicate = booking -> LocalDates.minDate(booking.getDepartureDate(), departureDate).compareTo(LocalDates.maxDate(booking.getArrivalDate(), arrivalDate)) > 0;

        return bookingsOnRoom.stream().noneMatch(availableRoomsPredicate);
    }

    private BigDecimal calculateTotalPrice(BigDecimal price, int quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
