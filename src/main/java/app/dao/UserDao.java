package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    User findByUsername(String username);

    void save(User user);

    List<User> findAll();
}
