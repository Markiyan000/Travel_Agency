package app.service.impl;

import app.dao.CountryDao;
import app.dao.HotelDao;
import app.model.Country;
import app.model.Hotel;
import app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelDao hotelDao;

    private CountryDao countryDao;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao, CountryDao countryDao) {
        this.hotelDao = hotelDao;
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
    public void save(Hotel hotel) {
        String countryName = hotel.getCountry().getName();
        Country country = fetchCountryFromDataSource(countryName);
        hotel.setCountry(country);
        hotelDao.save(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }

    @Override
    @Transactional
    public Hotel findOne(Long hotelId) {
        Hotel foundHotel = hotelDao.findOne(hotelId).orElseThrow(() -> new RuntimeException("Cannot found hotel with id " + hotelId));
        return foundHotel;
    }

    private Country fetchCountryFromDataSource(String countryName) {
        return countryDao.findByName(countryName).orElseGet(() -> {
            Country persistedCountry = new Country(countryName);
            countryDao.save(persistedCountry);
            return persistedCountry;
        });
    }
}
