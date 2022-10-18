package com.example.cinemaapp.repo;

import com.example.cinemaapp.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}
