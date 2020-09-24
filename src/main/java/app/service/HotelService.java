package app.service;

import app.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface HotelService {

    void save(Hotel hotel);

    List<Hotel> findAll();

    Hotel findOne(Long hotelId);
}
