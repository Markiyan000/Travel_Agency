package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao {

    Optional<User> findByUsername(String username);

    void save(User user);

    List<User> findAll();

    void delete(Long id);
}
