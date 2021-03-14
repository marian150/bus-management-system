package com.example.server.service;

import com.example.server.dto.SaveScheduleDto;
import com.example.server.entity.Destination;
import com.example.server.entity.Schedule;
import com.example.server.exception.DuplicateRecordException;
import com.example.server.exception.RecordNotFoundException;
import com.example.server.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Calendar;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private DestinationService destinationService;

    public Schedule findByTimeAndDestination(String time, String destination){
        LocalTime localTime = LocalTime.parse(time);
        Destination destinationObj = destinationService.findByName(destination);
        return scheduleRepository.findByTimeAndDestination(localTime, destinationObj)
                .orElseThrow(() -> new RecordNotFoundException("Schedule not found"));
    }

    public Schedule save(SaveScheduleDto saveScheduleDto){
        try{
            Destination destination = destinationService.findByName(saveScheduleDto.getDestination());
            LocalTime time = LocalTime.parse(saveScheduleDto.getTime());
            Schedule schedule = new Schedule();
            schedule.setDestination(destination);
            schedule.setTime(time);
            schedule.setPlaceCount(15);
            schedule.setPrice(saveScheduleDto.getPrice());
            schedule.setDayOfWeek(saveScheduleDto.getDayOfWeek());
            return scheduleRepository.save(schedule);
        } catch (DataIntegrityViolationException e){
            throw new DuplicateRecordException("This schedule already exists.");
        }
    }
}
