package app.service;

import app.model.Room;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {

    void save(Long hotelId, Room room);
}
