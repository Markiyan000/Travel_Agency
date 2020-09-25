package app.dao.impl;

import app.dao.BookingDao;
import app.model.Booking;
import app.model.Room;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookingDaoImpl implements BookingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Long roomId, Booking booking) {
        Room roomProxy = entityManager.getReference(Room.class, roomId);
        booking.setRoom(roomProxy);

        entityManager.persist(booking);
    }
}
