package com.example.cinemaapp.repo;
import com.example.cinemaapp.Model.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaHallRepo extends JpaRepository<CinemaHall, Long> {
}
