package app.service.impl;

import app.dao.UserDao;
import app.model.User;
import app.model.UserRole;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userDao.save(constructUser(user));
    }

    private User constructUser(User user) {
        String encryptedPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, "ROLE_USER"));
        user.getUserRoles().addAll(userRoles);

        return user;
    }
}
