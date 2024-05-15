package com.hroom.user.repository;

import java.util.List;

import com.hroom.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsername(String username);
}
