package com.example.cinemaapp.controllers;


import com.example.cinemaapp.Model.Movie;
import com.example.cinemaapp.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private MovieRepo movieRepo;

    @GetMapping(value = "/")
    public String getStartPage() {return "Dzień dobry";}

    @GetMapping(value = "/movies")
    public List<Movie> getMovies() {
        return movieRepo.findAll();
    }

    @PostMapping(value ="/save")
    public String saveMovie(@RequestBody Movie movie){
        movieRepo.save(movie);
        return "Saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateMovie (@PathVariable long id, @RequestBody Movie movie){
        Movie updatedMovie = movieRepo.findById(id).get();
        updatedMovie.setTitle(movie.getTitle());
        updatedMovie.setDescription (movie.getDescription());
        updatedMovie.setLength(movie.getLength());
        updatedMovie.setDirector(movie.getDirector());
        movieRepo.save(updatedMovie);
        return "Updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteMovie(@PathVariable long id){
        //Movie deleteMovie = userRepo.findById(id).get();
        movieRepo.deleteById(id);
        return "Deleted";
    }
}
