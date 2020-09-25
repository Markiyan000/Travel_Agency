package app.dao;

import app.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao {

    void save(Long hotelId, Room room);
}
