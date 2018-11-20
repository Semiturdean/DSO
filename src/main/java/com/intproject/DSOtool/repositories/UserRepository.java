package com.intproject.DSOtool.repositories;

import com.intproject.DSOtool.data.Role;
import com.intproject.DSOtool.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String s);
    Optional<User> findUserById(Long id);
    Optional<User> deleteUserById(Long id);
    List<User> findAllByFirstName(String firstName);
    List<User> findAllByLastName(String lastName);
    Optional<User> findByEmailAddress(String emailAddress);
    List<User> findAllByRoles(Role role);
}
