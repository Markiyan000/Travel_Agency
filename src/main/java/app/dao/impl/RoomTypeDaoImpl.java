package app.dao.impl;

import app.dao.RoomTypeDao;
import app.model.RoomType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class RoomTypeDaoImpl implements RoomTypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public RoomType findByType(String type) {
        Query query = createSelectByTypeQuery(type);

        return (RoomType) query.getSingleResult();
    }

    private Query createSelectByTypeQuery(String type) {
        Query selectByTypeQuery = entityManager.createQuery("select rt from RoomType rt where rt.type =: roomType");
        selectByTypeQuery.setParameter("roomType", type);

        return selectByTypeQuery;
    }
}
