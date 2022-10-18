package com.example.cinemaapp.repo;

import com.example.cinemaapp.Model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepo extends JpaRepository<Screening, Long> {
}
