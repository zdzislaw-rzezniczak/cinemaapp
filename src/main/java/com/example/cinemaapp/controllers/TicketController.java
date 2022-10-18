package com.example.cinemaapp.controllers;

import com.example.cinemaapp.Model.Movie;
import com.example.cinemaapp.Model.Ticket;
import com.example.cinemaapp.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketRepo ticketRepo;

    @GetMapping(value = "/tickets")
    public List<Ticket> getTickets() {
        return ticketRepo.findAll();
    }

    @PostMapping(value ="/saveticket")
    public String saveTicket(@RequestBody Ticket ticket){
        ticketRepo.save(ticket);
        return "Bilet zapisany w bazie danych";
    }

    @PutMapping(value = "/updateTicket/{id}")
    public String updateTicket (@PathVariable long id, @RequestBody Ticket ticket){
        Ticket updatedTicket = ticketRepo.findById(id).get();
        updatedTicket.setPrice(ticket.getPrice());
        updatedTicket.setSeatNumber (ticket.getSeatNumber());
        updatedTicket.setScreening(ticket.getScreening());
        ticketRepo.save(updatedTicket);
        return "Ticket has been updated";
    }

    @DeleteMapping(value = "/deleteTicket/{id}")
    public String deleteTicket(@PathVariable long id){
        ticketRepo.deleteById(id);
        return "Deleted";
    }

}
