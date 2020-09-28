package app.service;

import app.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findByUsername(String username);

    void save(User user);

    List<User> findAll();
}
