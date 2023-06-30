package com.example.page.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.page.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  
  @Query("SELECT u FROM User u")
  Page<User> findUserByPage(Pageable pageable);
}
