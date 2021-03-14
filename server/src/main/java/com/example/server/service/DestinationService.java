package com.example.server.service;

import com.example.server.entity.Destination;
import com.example.server.exception.DuplicateRecordException;
import com.example.server.exception.RecordNotFoundException;
import com.example.server.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public Destination findByName(String name){
        return destinationRepository.findByName(name)
                .orElseThrow(() -> new RecordNotFoundException("Destination not found"));
    }

    public Destination save(Destination destination){
        try{
            destination.setDestId(null);
            return destinationRepository.save(destination);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateRecordException("Destination with name " + destination.getName() + " already exists.");
        }
    }
}
