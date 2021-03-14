package com.example.server.controller;

import com.example.server.dto.SaveTicketDto;
import com.example.server.entity.Ticket;
import com.example.server.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> findAll(){
        return ticketService.findAll();
    }

    @PostMapping
    public Ticket save(@RequestBody SaveTicketDto saveTicketDto){
        return ticketService.save(saveTicketDto);
    }
}
