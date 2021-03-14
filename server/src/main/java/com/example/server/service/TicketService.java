package com.example.server.service;

import com.example.server.dto.SaveTicketDto;
import com.example.server.entity.Client;
import com.example.server.entity.Employee;
import com.example.server.entity.Schedule;
import com.example.server.entity.Ticket;
import com.example.server.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ScheduleService scheduleService;

    public List<Ticket> findAll(){
        return ticketRepository.findAll(Sort.by("resDate"));
    }

    public Ticket save(SaveTicketDto saveTicketDto){
        try{
            Client client = clientService.findByPhoneNumber(saveTicketDto.getPhoneNumber());
            Employee employee = employeeService.findByName(saveTicketDto.getEmpName());
            Schedule schedule = scheduleService.findByTimeAndDestination(saveTicketDto.getTime(), saveTicketDto.getDestination());
            LocalDate travelDate = LocalDate.parse(saveTicketDto.getTravelDate());
            Ticket ticket = new Ticket(null, LocalDate.now(), travelDate, employee, client, schedule);
            return ticketRepository.save(ticket);
        } catch(Exception e){
            throw new RuntimeException("Something went wrong.");
        }
    }
}
