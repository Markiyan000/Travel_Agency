package app.service.impl;

import static app.utils.LocalDates.*;
import app.dao.BookingDao;
import app.dao.RoomDao;
import app.dto.BookingDto;
import app.model.Booking;
import app.service.BookingService;
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
        BookingDto bookingDto = BookingDto.valueOf(booking);
        if (!checkAvailableRooms(roomId, bookingDto)) {
            return false;
        }
        BigDecimal totalPrice = calculateTotalPrice(booking, roomId);
        booking.setPrice(totalPrice);
        bookingDao.save(roomId, booking);

        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkAvailableRooms(Long roomId, BookingDto bookingDto) {
        if (!checkDates(bookingDto.getArrivalDate(), bookingDto.getDepartureDate())) {
            return false;
        }
        List<Booking> bookingsOnRoom = bookingDao.findByRoom(roomId);
        int numberOfAvailableRooms = findAvailableRoomsInRangeDate(roomId, bookingsOnRoom, bookingDto.getArrivalDate(), bookingDto.getDepartureDate());

        return numberOfAvailableRooms >= bookingDto.getNumberOfRooms();
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
        return booking -> minDate(booking.getDepartureDate(), departureDate)
                .compareTo(maxDate(booking.getArrivalDate(), arrivalDate)) > 0;
    }

    private int findAvailableRoomsInRangeDate(Long roomId, List<Booking> bookings, LocalDate arrivalDate, LocalDate departureDate) {
        int numberOfRooms = roomDao.findNumberOfRooms(roomId);
        int numberOfBookedRooms = findNumberOfBookedRoomsInRangeDate(bookings, arrivalDate, departureDate);

        return numberOfRooms - numberOfBookedRooms;
    }
}