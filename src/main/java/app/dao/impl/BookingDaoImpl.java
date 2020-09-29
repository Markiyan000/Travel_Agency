package app.dao.impl;

import app.dao.BookingDao;
import app.model.Booking;
import app.model.Room;
import app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Long roomId, Booking booking) {
        Room roomProxy = entityManager.getReference(Room.class, roomId);
        booking.setRoom(roomProxy);

        entityManager.persist(booking);
    }

    @Override
    public List<Booking> findByRoom(Long roomId) {
        Query query = createSelectByRoomQuery(roomId);

        return query.getResultList();
    }

    @Override
    public List<Booking> findByUser(Long userId) {
        Query query = createSelectByUserQuery(userId);

        return query.getResultList();
    }

    private Query createSelectByRoomQuery(Long roomId) {
        Room room = entityManager.getReference(Room.class, roomId);
        Query selectByRoomQuery = entityManager.createQuery("select b from Booking b where b.room =: room");
        selectByRoomQuery.setParameter("room", room);

        return selectByRoomQuery;
    }

    private Query createSelectByUserQuery(Long userId) {
        User user = entityManager.getReference(User.class, userId);
        Query selectByUserQuery = entityManager.createQuery("select b from Booking b join fetch b.room where b.user =: user " +
                "order by b.arrivalDate");
        selectByUserQuery.setParameter("user", user);

        return selectByUserQuery;
    }
}
