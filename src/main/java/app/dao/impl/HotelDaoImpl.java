package app.dao.impl;

import app.dao.HotelDao;
import app.model.Hotel;
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

    @Override
    @Transactional
    public void save(Hotel hotel) {
        entityManager.persist(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        Query selectAllHotels = entityManager.createQuery("select h from Hotel h join fetch h.country");

        return selectAllHotels.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Hotel> findOne(Long hotelId) {
        Hotel hotel = entityManager.find(Hotel.class, hotelId);
        return Optional.ofNullable(hotel);
    }
}
