package app.dao.impl;

import app.dao.UserDao;
import app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        Query selectByUsernameQuery = createSelectByUsernameQuery(username);

        return (User) selectByUsernameQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        Query selectAllQuery = entityManager.createQuery("select u from User u join fetch u.userRole");

        return selectAllQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User userProxy = entityManager.getReference(User.class, id);
        entityManager.remove(userProxy);
    }

    private Query createSelectByUsernameQuery(String username) {
        Query query = entityManager.createQuery("select u from User u where u.username =: username");
        query.setParameter("username", username);

        return query;
    }
}
