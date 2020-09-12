package com.example.permission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.permission.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
