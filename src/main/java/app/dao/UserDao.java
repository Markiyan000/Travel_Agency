package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User findByUsername(String username);

    void save(User user);
}
