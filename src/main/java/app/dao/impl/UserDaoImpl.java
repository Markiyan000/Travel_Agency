package app.dao.impl;

import app.dao.UserDao;
import app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    private Query createSelectByUsernameQuery(String username) {
        Query query = entityManager.createQuery("select u from User u where u.username =: username");
        query.setParameter("username", username);

        return query;
    }
}
