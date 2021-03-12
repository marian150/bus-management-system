package com.example.server.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Schedule {
    @Id
    @Column(name = "id_sch")
    private Long schId;

    @Column(name = "day_week")
    private int dayOfWeek;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "price")
    private double price;

    @Column(name = "place_count")
    private int placeCount;

    @JoinColumn(name = "id_dest", foreignKey = @ForeignKey(name = "SCHEDULE_DESTINATION_FK"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Destination destination;

    public Schedule() {}

    public Schedule(Long schId, int dayOfWeek, LocalTime time, double price, int placeCount, Destination destination) {
        this.schId = schId;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.price = price;
        this.placeCount = placeCount;
        this.destination = destination;
    }

    public Long getSchId() {
        return schId;
    }

    public void setSchId(Long schId) {
        this.schId = schId;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(int placeCount) {
        this.placeCount = placeCount;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
