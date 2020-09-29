package app.service.impl;

import app.dao.BookingDao;
import app.dao.RoomDao;
import app.dto.BookingDto;
import app.model.Booking;
import app.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import static app.utils.LocalDates.*;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private BookingDao bookingDao;

    private RoomDao roomDao;

    @Autowired
    public AvailabilityServiceImpl(BookingDao bookingDao, RoomDao roomDao) {
        this.bookingDao = bookingDao;
        this.roomDao = roomDao;
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
