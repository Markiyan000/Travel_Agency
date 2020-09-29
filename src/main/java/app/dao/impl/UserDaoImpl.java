package app.dao.impl;

import app.dao.UserDao;
import app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByUsername(String username) {
        Query selectByUsernameQuery = createSelectByUsernameQuery(username);
        User foundUser = (User) selectByUsernameQuery.getSingleResult();

        return Optional.ofNullable(foundUser);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> findAll() {
        Query selectAllQuery = entityManager.createQuery("select u from User u join fetch u.userRoles");

        return selectAllQuery.getResultList();
    }

    @Override
    public void delete(Long id) {
        User userProxy = entityManager.getReference(User.class, id);
        entityManager.remove(userProxy);
    }

    @Override
    public Optional<User> findOne(Long id) {
        User user = entityManager.find(User.class, id);

        return Optional.ofNullable(user);
    }

    private Query createSelectByUsernameQuery(String username) {
        Query query = entityManager.createQuery("select u from User u join fetch u.userRoles where u.username =: username");
        query.setParameter("username", username);

        return query;
    }
}
