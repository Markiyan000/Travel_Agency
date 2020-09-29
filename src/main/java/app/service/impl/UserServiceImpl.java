package app.service.impl;

import app.dao.UserDao;
import app.dao.UserRoleDao;
import app.exception.EntityNotFoundException;
import app.model.User;
import app.model.UserRole;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static app.message.Messages.*;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private UserRoleDao userRoleDao;

    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder encoder, UserRoleDao userRoleDao) {
        this.userDao = userDao;
        this.userRoleDao = userRoleDao;
        this.encoder = encoder;
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userDao.findByUsername(username).orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + username));
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(constructUser(user));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void enable(Long id) {
        User user = userDao.findOne(id).orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + id));
        boolean isEnabled = user.isEnabled();
        user.setEnabled(!isEnabled);
    }

    private User constructUser(User user) {
        String encryptedPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        UserRole userRoleUser = userRoleDao.findByRole("ROLE_USER");
        user.getUserRoles().add(userRoleUser);

        return user;
    }
}
