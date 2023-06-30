package com.example.page.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.page.model.User;
import com.example.page.repository.UserRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("all")
  public List<User> allUsers(@PathParam("page") Integer page) {
    
    Integer size = 2;
    Pageable pageable = PageRequest.of(page, size);
    Page<User> pageUser = userRepository.findUserByPage(pageable);
    List<User> users = pageUser.getContent();
    return users;
  }

}
