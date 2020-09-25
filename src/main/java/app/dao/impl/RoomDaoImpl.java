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
}
