package app.service.impl;

import app.dao.CountryDao;
import app.dao.HotelDao;
import static app.message.Messages.*;

import app.dto.BookingDto;
import app.exception.EntityNotFoundException;
import app.model.Hotel;
import app.model.Room;
import app.service.AvailabilityService;
import app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelDao hotelDao;

    private AvailabilityService availabilityService;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao, AvailabilityService availabilityService) {
        this.hotelDao = hotelDao;
        this.availabilityService = availabilityService;
    }

    @Override
    @Transactional
    public void save(Hotel hotel) {
        hotelDao.save(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }

    @Override
    @Transactional
    public Hotel findOne(Long hotelId) {
        return hotelDao.findOne(hotelId).orElseThrow(() -> new EntityNotFoundException(HOTEL_NOT_FOUND + hotelId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> findByCountry(String countryName) {
        return hotelDao.findByCountry(countryName);
    }

    @Override
    @Transactional
    public void deleteById(Long hotelId) {
        hotelDao.delete(hotelId);
    }

    @Override
    public List<Room> findAvailableRooms(Hotel hotel, BookingDto bookingDto) {
        return hotel.getRooms().
                stream().
                filter(r -> availabilityService.checkAvailableRooms(r.getId(), bookingDto)).
                collect(Collectors.toList());
    }
}
