package app.service.impl;

import app.dao.BookingDao;
import app.dao.RoomDao;
import app.model.Booking;
import app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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

    private BigDecimal calculateTotalPrice(BigDecimal price, int quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
