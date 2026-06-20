package com.richa.aimockinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richa.aimockinterview.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}