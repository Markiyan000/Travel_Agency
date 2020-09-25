package app.dao;

import app.model.RoomType;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeDao {

    RoomType findByType(String type);
}
