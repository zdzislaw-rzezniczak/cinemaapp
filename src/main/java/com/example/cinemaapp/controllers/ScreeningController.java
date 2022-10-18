package com.example.cinemaapp.controllers;


import com.example.cinemaapp.Model.Screening;
import com.example.cinemaapp.repo.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScreeningController {


    @Autowired
    ScreeningRepo screeningRepo;

    @GetMapping(value = "/screenings")
    public List<Screening> getScreening() {
        return screeningRepo.findAll();
    }

    @PostMapping(value ="/savescreening")
    public String saveScreening(@RequestBody Screening screening){
        screeningRepo.save(screening);
        return "Seans zapisany w bazie danych";
    }

    @PutMapping(value = "/updatescreening/{id}")
    public String updateScreening (@PathVariable long id, @RequestBody Screening screening){
        Screening updatedScreening = screeningRepo.findById(id).get();
        updatedScreening.setMovie(screening.getMovie());
        updatedScreening.setCinemaHall (screening.getCinemaHall());
        updatedScreening.setStartTime(screening.getStartTime());
        screeningRepo.save(updatedScreening);
        return "Seans został updateowany";
    }

    @DeleteMapping(value = "/deletescreening/{id}")
    public String deleteScreening(@PathVariable long id){
        screeningRepo.deleteById(id);
        return "Seans usunięty";
    }
}
