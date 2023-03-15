package com.dfive.studentapp.repository;

import com.dfive.studentapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
