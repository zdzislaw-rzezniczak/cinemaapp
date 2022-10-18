package com.example.cinemaapp.controllers;

import com.example.cinemaapp.Model.CinemaHall;
import com.example.cinemaapp.repo.CinemaHallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaHallController {

    @Autowired
    CinemaHallRepo cinemaHallRepo;

    @GetMapping(value = "/cinemaHalls")
    public List<CinemaHall> getCinemaHalls(){
        return cinemaHallRepo.findAll();
    }

    @PostMapping(value = "/saveCinemaHall")
        public String saveCinemaHall (@RequestBody CinemaHall cinemaHall){
            cinemaHallRepo.save(cinemaHall);
            return "Cinema Hall created...";
    }

    @PutMapping(value = "/updateCinemaHall/{id}")
    public String updateCinemaHall (@PathVariable long id, @RequestBody CinemaHall cinemaHall){
        CinemaHall updatedCinemaHall = cinemaHallRepo.findById(id).get();
        updatedCinemaHall.setName(cinemaHall.getName());
        updatedCinemaHall.setNumber(cinemaHall.getNumber());
        updatedCinemaHall.setNumberOfSeats(cinemaHall.getNumberOfSeats());

        cinemaHallRepo.save(updatedCinemaHall);
        return "Cinema Hall Updated...";
    }

    @DeleteMapping(value = "/deleteCinemaHall/{id}")
    public String deleteCinemaHall(@PathVariable long id){
        //Movie deleteMovie = userRepo.findById(id).get();
        cinemaHallRepo.deleteById(id);
        return "Cinema Hall has been deleted";
    }



}
