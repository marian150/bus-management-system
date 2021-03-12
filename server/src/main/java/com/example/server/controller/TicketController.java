package com.example.server.controller;

import com.example.server.entity.Ticket;
import com.example.server.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
}
