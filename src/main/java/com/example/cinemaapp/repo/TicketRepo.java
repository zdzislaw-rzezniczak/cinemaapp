package com.example.cinemaapp.repo;

import com.example.cinemaapp.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
