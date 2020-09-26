package app.dao;

import app.model.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao {

    UserRole findByRole(String role);
}
