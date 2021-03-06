package com.example.server.entity;

import javax.persistence.*;

@Entity
public class Position {
    @Id
    @Column(name = "id_pos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long posId;

    @Column(name = "pos_name", unique = true)
    private String name;

    public Position(Long posId, String name) {
        this.posId = posId;
        this.name = name;
    }

    public Position() {}

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
