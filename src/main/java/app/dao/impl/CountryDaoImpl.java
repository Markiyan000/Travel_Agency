package app.dao.impl;

import app.dao.CountryDao;
import app.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class CountryDaoImpl implements CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Country country) {
        entityManager.persist(country);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Country> findByName(String countryName) {
        Query selectByNameQuery = createSelectByNameQuery(countryName);
        Country foundCountry = extractCountryFromList(selectByNameQuery.getResultList());

        return Optional.ofNullable(foundCountry);
    }

    private Query createSelectByNameQuery(String countryName) {
        Query selectByNameQuery = entityManager.createQuery("select c from Country c where c.name =: countryName");
        selectByNameQuery.setParameter("countryName", countryName);

        return selectByNameQuery;
    }

    private Country extractCountryFromList(List countries) {
        return countries.isEmpty() ? null : (Country) countries.get(0);
    }
}
