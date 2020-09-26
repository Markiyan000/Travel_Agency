package app.dao.impl;

import app.dao.UserRoleDao;
import app.model.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserRole findByRole(String role) {
        Query query = createSelectByRoleQuery(role);

        return (UserRole) query.getSingleResult();
    }

    private Query createSelectByRoleQuery(String role) {
        Query selectByRoleQuery = entityManager.createQuery("select ur from UserRole ur where ur.role =: role");
        selectByRoleQuery.setParameter("role", role);

        return selectByRoleQuery;
    }
}
