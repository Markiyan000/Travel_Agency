package app.dao;

import app.model.Country;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryDao {

    void save(Country country);

    Optional<Country> findByName(String countryName);
}
