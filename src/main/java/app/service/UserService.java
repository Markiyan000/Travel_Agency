package app.service;

import app.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findByUsername(String username);

    void save(User user);
}
