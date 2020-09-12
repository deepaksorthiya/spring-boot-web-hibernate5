package com.example.roles.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.roles.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@EntityGraph(attributePaths = { "permissions" }, type = EntityGraph.EntityGraphType.FETCH)
	@Query("SELECT r from Role r")
	Page<Role> getRoleWithPermissions(Pageable pageable);

}
