package app.dao.impl;

import app.dao.CountryDao;
import app.dao.HotelDao;
import app.model.Country;
import app.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class HotelDaoImpl implements HotelDao {

    @PersistenceContext
    private EntityManager entityManager;

    private CountryDao countryDao;

    @Autowired
    public HotelDaoImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
    public void save(Hotel hotel) {
        entityManager.persist(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> findAll() {
        Query selectAllHotels = entityManager.createQuery("select h from Hotel h join fetch h.country");

        return selectAllHotels.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Hotel> findOne(Long hotelId) {
        Query query = createSelectOneWithJoinQuery(hotelId);
        Hotel hotel = (Hotel) query.getSingleResult();
        return Optional.ofNullable(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> findByCountry(String countryName) {
        Country country = countryDao.findByName(countryName).orElseThrow(() -> new RuntimeException("Cannot found country with name ---> " + countryName));
        Query query = createSelectByCountryQuery(country);

        return query.getResultList();
    }

    private Query createSelectOneWithJoinQuery(Long hotelId) {
        Query selectOneWithJoinQuery = entityManager.createQuery("select h from Hotel h join fetch h.country " +
                "left join fetch h.rooms where h.id =: hotelId");
        selectOneWithJoinQuery.setParameter("hotelId", hotelId);

        return selectOneWithJoinQuery;
    }

    private Query createSelectByCountryQuery(Country country) {
        Query selectByCountryQuery = entityManager.createQuery("select h from Hotel h where h.country =: country");
        selectByCountryQuery.setParameter("country", country);

        return selectByCountryQuery;
    }
}
