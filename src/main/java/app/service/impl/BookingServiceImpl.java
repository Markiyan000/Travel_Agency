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
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

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
    public boolean save(Booking booking, Long roomId) {
        if (!checkAvailableRooms(roomId, booking.getArrivalDate(), booking.getDepartureDate(), booking.getNumberOfRooms())) {
            return false;
        }
        BigDecimal totalPrice = calculateTotalPrice(booking, roomId);
        booking.setPrice(totalPrice);
        bookingDao.save(roomId, booking);

        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkAvailableRooms(Long roomId, LocalDate arrivalDate, LocalDate departureDate, int bookedNumberOfRooms) {
        List<Booking> bookingsOnRoom = bookingDao.findByRoom(roomId);
        int numberOfAvailableRooms = findAvailableRoomsInRangeDate(roomId, bookingsOnRoom, arrivalDate, departureDate);

        return numberOfAvailableRooms >= bookedNumberOfRooms;
    }

    @Override
    public List<Booking> findByUser(Long userId) {
        return bookingDao.findByUser(userId);
    }

    private BigDecimal calculateTotalPrice(Booking booking, Long roomId) {
        BigDecimal priceByRoom = roomDao.findPrice(roomId);
        long days = ChronoUnit.DAYS.between(booking.getArrivalDate(), booking.getDepartureDate());
        int numberOfRooms = booking.getNumberOfRooms();

        return priceByRoom.multiply(BigDecimal.valueOf(days)).multiply(BigDecimal.valueOf(numberOfRooms));
    }

    private int findNumberOfBookedRoomsInRangeDate(List<Booking> bookings, LocalDate arrivalDate, LocalDate departureDate) {
        Predicate<Booking> datesOverlapsPredicate = createDatesOverlapsPredicate(arrivalDate, departureDate);
        return bookings.stream().filter(datesOverlapsPredicate).mapToInt(Booking::getNumberOfRooms).sum();
    }

    private Predicate<Booking> createDatesOverlapsPredicate(LocalDate arrivalDate, LocalDate departureDate) {
        return booking -> LocalDates.minDate(booking.getDepartureDate(), departureDate)
                .compareTo(LocalDates.maxDate(booking.getArrivalDate(), arrivalDate)) > 0;
    }

    private int findAvailableRoomsInRangeDate(Long roomId, List<Booking> bookings, LocalDate arrivalDate, LocalDate departureDate) {
        int numberOfRooms = roomDao.findNumberOfRooms(roomId);
        int numberOfBookedRooms = findNumberOfBookedRoomsInRangeDate(bookings, arrivalDate, departureDate);

        return numberOfRooms - numberOfBookedRooms;
    }
}
