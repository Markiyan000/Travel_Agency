package app.dao;

import app.model.Room;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface RoomDao {

    void save(Long hotelId, Room room);

    BigDecimal findPrice(Long roomId);
}
