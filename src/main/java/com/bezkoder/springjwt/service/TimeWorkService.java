package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.TimeWork;
import com.bezkoder.springjwt.repository.TimeWorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeWorkService {
    private final TimeWorkRepository timeWorkRepository;
    public TimeWorkService(TimeWorkRepository timeWorkRepository){
        this.timeWorkRepository=timeWorkRepository;
    }

    public Optional<TimeWork> findOne(String id){
        return timeWorkRepository.findById(id);
    }

    public List<TimeWork>findAll(){
        return timeWorkRepository.findAll();
    }

    public TimeWork save(TimeWork timeWork){
        return timeWorkRepository.save(timeWork);
    }

    public TimeWork update(String id, TimeWork timeWork){
        Optional<TimeWork>timeWork1 = timeWorkRepository.findById(id);
        TimeWork timeWork2 = timeWork1.get();
        timeWork2.setDateOfWork(timeWork.getDateOfWork());
        timeWork2.setCategoryShift(timeWork.getCategoryShift());
        TimeWork timeWorkUpdate = timeWorkRepository.save(timeWork2);
        return timeWorkUpdate;
    }

    public void delete(TimeWork timeWork){
        timeWorkRepository.delete(timeWork);
    }
}
