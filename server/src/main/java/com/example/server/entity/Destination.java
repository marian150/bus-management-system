package com.example.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Destination {
    @Id
    @Column(name = "id_dest")
    private Long destId;

    @Column(name = "dest_name")
    private String name;

    @Column(name = "dest_price")
    private double price;

    public Destination() {
    }

    public Destination(Long destId, String name, double price) {
        this.destId = destId;
        this.name = name;
        this.price = price;
    }

    public Long getDestId() {
        return destId;
    }

    public void setDestId(Long destId) {
        this.destId = destId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
