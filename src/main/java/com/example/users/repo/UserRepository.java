package com.example.users.repo;

import com.example.users.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    String USER_ROLE_PERMISSION = "SELECT u FROM User u LEFT JOIN FETCH u.roles r LEFT JOIN FETCH r.permissions p";
    String COUNT_USER_ROLE_PERMISSION = "SELECT COUNT(*) FROM User u LEFT JOIN u.roles r LEFT JOIN r.permissions p";
    String INNER_COUNT_USER_ROLE_PERMISSION = "SELECT COUNT(*) FROM User u INNER JOIN u.roles r INNER JOIN r.permissions p WHERE u.userId IN(1,2)";

    @Query(value = USER_ROLE_PERMISSION, countQuery = COUNT_USER_ROLE_PERMISSION)
    Page<User> getAllUserWithRolesAndPermissions(Pageable pageable);

    @Query(value = INNER_COUNT_USER_ROLE_PERMISSION)
    long getAllCountUserWithRolesAndPermissions();

    @EntityGraph(attributePaths = {"roles", "roles.permissions"})
    Page<User> findAll(Pageable pageable);
}
