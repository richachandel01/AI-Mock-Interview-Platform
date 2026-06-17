package com.richa.aimockinterview.repository;

import com.richa.aimockinterview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}