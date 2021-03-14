package com.example.server.service;

import com.example.server.entity.Position;
import com.example.server.exception.DuplicateRecordException;
import com.example.server.exception.RecordNotFoundException;
import com.example.server.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public Position findByName(String name){
        return positionRepository.findByName(name)
                .orElseThrow(() -> new RecordNotFoundException("Position not found."));
    }

    public Position save(Position position){
        try{
            position.setPosId(null);
            return positionRepository.save(position);
        } catch (DataIntegrityViolationException e){
            throw new DuplicateRecordException("Position with name " + position.getName() + " already exists.");
        }
    }
}
