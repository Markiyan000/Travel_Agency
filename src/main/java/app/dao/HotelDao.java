package app.dao;

import app.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelDao {

    void save(Hotel hotel);

    List<Hotel> findAll();

    Optional<Hotel> findOne(Long hotelId);

    List<Hotel> findByCountry(String countryName);
}
