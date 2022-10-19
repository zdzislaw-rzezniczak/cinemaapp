package com.example.cinemaapp.repo;

import com.example.cinemaapp.Model.Role;
import com.example.cinemaapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername (String username);

}
