package app.dao.impl;

import app.dao.RoomDao;
import app.dao.RoomTypeDao;
import app.model.Hotel;
import app.model.Room;
import app.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

@Repository
public class RoomDaoImpl implements RoomDao {

    @PersistenceContext
    private EntityManager entityManager;

    private RoomTypeDao roomTypeDao;

    @Autowired
    public RoomDaoImpl(RoomTypeDao roomTypeDao) {
        this.roomTypeDao = roomTypeDao;
    }

    @Override
    @Transactional
    public void save(Long hotelId, Room room) {
        Hotel hotelProxy = entityManager.getReference(Hotel.class, hotelId);
        RoomType roomType = roomTypeDao.findByType(room.getRoomType().getType());

        room.setHotel(hotelProxy);
        room.setRoomType(roomType);

        entityManager.persist(room);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal findPrice(Long roomId) {
        Query query = createSelectPriceQuery(roomId);

        return (BigDecimal) query.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public int findNumberOfRooms(Long roomId) {
        Query query = createSelectNumberOfRoomsQuery(roomId);

        return (int) query.getSingleResult();
    }

    private Query createSelectPriceQuery(Long roomId) {
        return entityManager.createNativeQuery("select price from room where id = " + roomId);
    }

    private Query createSelectNumberOfRoomsQuery(Long roomId) {
        return entityManager.createNativeQuery("select quantity from room where id = " + roomId);
    }
}
