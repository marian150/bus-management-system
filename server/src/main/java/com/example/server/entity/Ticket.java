package com.example.server.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @Column(name = "id_ticket")
    private Long ticketId;

    @Column(name = "res_date")
    private LocalDate resDate;

    @Column(name = "travel_date")
    private LocalDate travelDate;

    @JoinColumn(name = "id_emp", foreignKey = @ForeignKey(name = "TICKET_EMPLOYEE_FK"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @JoinColumn(name = "id_cl", foreignKey = @ForeignKey(name = "TICKET_CLIENT_FK"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @JoinColumn(name = "id_sch", foreignKey = @ForeignKey(name = "TICKET_SCHEDULE_FK"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Schedule schedule;

    public Ticket() {}

    public Ticket(Long ticketId, LocalDate resDate, LocalDate travelDate, Employee employee, Client client, Schedule schedule) {
        this.ticketId = ticketId;
        this.resDate = resDate;
        this.travelDate = travelDate;
        this.employee = employee;
        this.client = client;
        this.schedule = schedule;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDate getResDate() {
        return resDate;
    }

    public void setResDate(LocalDate resDate) {
        this.resDate = resDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
