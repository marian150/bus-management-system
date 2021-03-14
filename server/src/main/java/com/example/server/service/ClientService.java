package com.example.server.service;

import com.example.server.entity.Client;
import com.example.server.exception.RecordNotFoundException;
import com.example.server.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client findByPhoneNumber(String phoneNumber){
        return clientRepository.findByPhone(phoneNumber).orElseThrow(() -> new RecordNotFoundException("Client not found."));
    }
}
