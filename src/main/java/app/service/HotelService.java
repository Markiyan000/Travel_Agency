package app.service;

import app.dto.BookingDto;
import app.model.Hotel;
import app.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface HotelService {

    void save(Hotel hotel);

    List<Hotel> findAll();

    Hotel findOne(Long hotelId);

    List<Hotel> findByCountry(String countryName);

    void deleteById(Long hotelId);

    List<Room> findAvailableRooms(Hotel hotel, BookingDto bookingDto);
}
