package com.example.cinemaapp.Model;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    private long id;

    @Column
    private long seatNumber;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(long seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }
}
