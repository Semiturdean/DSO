package com.intproject.DSOtool.repositories;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}
