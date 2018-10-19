package com.intproject.DSOtool.repositories;

import com.intproject.DSOtool.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String s);
    Optional<User> findUserById(Long id);
    Optional<User> deleteUserById(Long id);
}
